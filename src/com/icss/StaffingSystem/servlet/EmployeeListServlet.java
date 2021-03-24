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
 * ���ڷ�ҳչ���������������Ա���б�� Servlet
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
			
			// 1.��������			
			// �й����������з�ҳ��ȡ�û��б�
			// ���յ���������һ��Ա��ְλ
			String jobidStr = request.getParameter("job_id");
			// ���յ�������������Ա������
			String name = request.getParameter("name");
			// ���յ����������������֤����
			String cardid = request.getParameter("cardId");
			// ���յ����������ģ��Ա�
			String sex = request.getParameter("sex");
			// ���յ����������壺�ֻ�����
			String phone = request.getParameter("phone");
			// ���յ����������������ű��
			String deptidStr = request.getParameter("dept_id");
			
			// ���ܵ��û���Ҫ�鿴��ҳ��
			String currentPageStr = request.getParameter("currentPage");
			
			Integer currentPage = 1;
			if (currentPageStr != null && !"".equals(currentPageStr)) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			
			// ÿҳչʾ����
			Integer pageSize = 5;
			
			// 2.��������
			
			//(1)��Ҫ��һ����������ʵ�ֻ�ȡ�õ��������������Ա����ҳ�����ҵ���߼�
			EmployeeService employeeService = new EmployeeService();
			
			int jobid = 0;
			if (jobidStr != null && !"".equals(jobidStr)) {
				jobid = Integer.parseInt(jobidStr);
			}
			int depid = 0;
			if (deptidStr != null && !"".equals(deptidStr)) {
				depid = Integer.parseInt(deptidStr);
			}
			
			// �й����������з�ҳ��ȡ�û��б� -> ��Ҫһ���ܹ��������ǻ�ȡ�õ�������������ķ�ҳ�������ҳ���б���ǰ��ҳ�롢����������������ҳ����ҵ���߼�
			PageResult<Employee> pageResult = employeeService.pageByConditions(jobid, name, cardid, sex, phone, depid, currentPage, pageSize);
			request.setAttribute("pageResult", pageResult);
			
			//��2����Ҫһ���������ǻ�ȡ�õ�����ְλ�б��ҵ���߼�
			JobService jobService = new JobService();
			List<Job> jobList = jobService.findAll();
			request.setAttribute("jobs", jobList);
			
			//��3����Ҫһ���������ǻ�ȡ��ȡ���в����б��ҵ���߼�
			DepService depService = new DepService();
			List<Dep> depList = depService.findAll();
			request.setAttribute("depts", depList);
			
			
			// 3.�����ת
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
