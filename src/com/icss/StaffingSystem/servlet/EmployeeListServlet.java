package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.Dep;
import com.icss.StaffingSystem.entity.Employee;
import com.icss.StaffingSystem.entity.Job;
import com.icss.StaffingSystem.service.DepService;
import com.icss.StaffingSystem.service.EmployeeService;
import com.icss.StaffingSystem.service.JobService;
import com.icss.StaffingSystem.util.PageResult;

/**
 * 用于分页展现满足过滤条件的员工列表的 Servlet
 */
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			// 1.接受请求			
			// 有过滤条件、有分页获取用户列表
			// 接收到过滤条件一：员工职位
			String jobidStr = request.getParameter("job_id");
			// 接收到过滤条件二：员工姓名
			String name = request.getParameter("name");
			// 接收到过滤条件三：身份证号码
			String cardid = request.getParameter("cardId");
			// 接收到过滤条件四：性别
			String sex = request.getParameter("sex");
			// 接收到过滤条件五：手机号码
			String phone = request.getParameter("phone");
			// 接收到过滤条件六：部门编号
			String deptidStr = request.getParameter("dept_id");
			
			// 接受到用户想要查看的页码
			String currentPageStr = request.getParameter("currentPage");
			
			Integer currentPage = 1;
			if (currentPageStr != null && !"".equals(currentPageStr)) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			
			// 每页展示条数
			Integer pageSize = 5;
			
			// 2.处理请求
			
			//(1)需要有一个帮助我们实现获取得到满足过滤条件的员工分页结果的业务逻辑
			EmployeeService employeeService = new EmployeeService();
			
			int jobid = 0;
			if (jobidStr != null && !"".equals(jobidStr)) {
				jobid = Integer.parseInt(jobidStr);
			}
			int depid = 0;
			if (deptidStr != null && !"".equals(deptidStr)) {
				depid = Integer.parseInt(deptidStr);
			}
			
			// 有过滤条件、有分页获取用户列表 -> 需要一个能够帮助我们获取得到满足过滤条件的分页结果（分页的列表，当前的页码、共多少条、共多少页）的业务逻辑
			PageResult<Employee> pageResult = employeeService.pageByConditions(jobid, name, cardid, sex, phone, depid, currentPage, pageSize);
			request.setAttribute("pageResult", pageResult);
			
			//（2）需要一个帮助我们获取得到所有职位列表的业务逻辑
			JobService jobService = new JobService();
			List<Job> jobList = jobService.findAll();
			request.setAttribute("jobs", jobList);
			
			//（3）需要一个帮助我们获取得取所有部门列表的业务逻辑
			DepService depService = new DepService();
			List<Dep> depList = depService.findAll();
			request.setAttribute("depts", depList);
			
			
			// 3.完成跳转
			request.getRequestDispatcher("/employee/employeeList.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
