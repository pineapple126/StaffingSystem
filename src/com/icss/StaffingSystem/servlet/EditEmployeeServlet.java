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
import com.icss.StaffingSystem.entity.Level;
import com.icss.StaffingSystem.service.DepService;
import com.icss.StaffingSystem.service.EmployeeService;
import com.icss.StaffingSystem.service.JobService;
import com.icss.StaffingSystem.service.LevelService;

/**
 * չ��ָ��Ҫ�޸�Ա��ԭ��Ϣ�� Servlet
 * @author pineapple126
 */
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
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
			//���յõ�Ҫ�޸ĵ�Ա�����
			String id = request.getParameter("id");
					
			// 2.��������
			//��1����Ҫһ���������ǻ�ȡ�õ�����ְλ�б��ҵ���߼�
			JobService jobService = new JobService();
			List<Job> jobList = jobService.findAll();
			request.setAttribute("jobs", jobList);
			
			//��2����Ҫһ���������ǻ�ȡ��ȡ���в����б��ҵ���߼�
			DepService depService = new DepService();
			List<Dep> depList = depService.findAll();
			request.setAttribute("depts", depList);
			
			//��3����Ҫһ���ܹ��������ǻ�ȡ����н�ʵȼ��б��ҵ���߼�
			LevelService levelService = new LevelService();
			List<Level> levelList = levelService.findAll();
			request.setAttribute("levels", levelList);
			
			//��4����Ҫһ���ܹ��������ǻ�ȡԭԱ����Ϣ��ҵ���߼�
			EmployeeService employeeService = new EmployeeService();
			Employee employee = employeeService.findById(Integer.parseInt(id));
			request.setAttribute("employee", employee);
			
			// 3.�����ת
			request.getRequestDispatcher("/employee/editEmployee.jsp").forward(request, response);
			
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
