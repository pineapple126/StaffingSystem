package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.service.EmployeeService;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 用于实现修改指定员工信息的 Servlet
     * @author pineapple126
     */
    public UpdateEmployeeServlet() {
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
			//接收得到要修改的员工编号
			String id = request.getParameter("id");
			//接收得到修改的员工的姓名
			String name = request.getParameter("name");
			//接收得到修改的员工的身份证号码
			String cardid = request.getParameter("cardId");
			//接收得到修改的员工的性别
			String sex = request.getParameter("sex");
			//接收得到修改的员工的所属的职位编号
			String jobid = request.getParameter("job_id");
			//接收得到修改的员工的学历
			String education = request.getParameter("education");
			//接收得到修改的员工的邮箱
			String email = request.getParameter("email");
			//接收得到修改的员工的手机号码
			String phone = request.getParameter("phone");
			//接收得到修改的员工的电话号码
			String tel = request.getParameter("tel");
			//接收得到修改的员工的政治面貌
			String party = request.getParameter("party");
			//接收得到修改的员工的qq号码
			String qqnum = request.getParameter("qqNum");
			//接收得到修改的员工的联系地址
			String address = request.getParameter("address");
			//接收得到修改的员工的邮编
			String postcode = request.getParameter("postCode");
			//接收得到修改的员工的出生日期
			String birthday = request.getParameter("birthday");
			//接收得到修改的员工的民族
			String race = request.getParameter("race");
			//接收得到修改的员工的所学专业
			String speciality = request.getParameter("speciality");
			//接收得到修改的员工的爱好
			String hobby = request.getParameter("hobby");
			//接收得到修改的员工的备注
			String remark = request.getParameter("remark");
			//接收得到修改的员工的所属部门编号
			String depid = request.getParameter("dept_id");
			//接收得到修改的员工的所属薪资范围编号
			String levelid = request.getParameter("levelid");
			//接收得到修改的员工的薪资
			String salary = request.getParameter("salary");
				
			// 2.处理请求
			EmployeeService employeeService = new EmployeeService();
			employeeService.updateEmployee(Integer.parseInt(id), name, cardid, sex, Integer.parseInt(jobid), education, email, phone, tel, party, qqnum, address, postcode, birthday, race, speciality, hobby, remark, Integer.parseInt(depid), Integer.parseInt(levelid), Double.parseDouble(salary));
			
			// 3.完成跳转
			
			request.getRequestDispatcher("/employee/EmployeeListServlet").forward(request, response);
			
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
