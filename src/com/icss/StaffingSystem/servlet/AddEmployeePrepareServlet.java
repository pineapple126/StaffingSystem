package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.Dep;
import com.icss.StaffingSystem.entity.Job;
import com.icss.StaffingSystem.entity.Level;
import com.icss.StaffingSystem.service.DepService;
import com.icss.StaffingSystem.service.JobService;
import com.icss.StaffingSystem.service.LevelService;

/**
 * ��ȡ���Ա��ҳ������Ҫչ�ֵ����ж�̬���ݵ�Servlet
 * @author pineapple126
 */
public class AddEmployeePrepareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeePrepareServlet() {
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
			
			// 3.�����ת
			request.getRequestDispatcher("/employee/addEmployee.jsp").forward(request, response);
			
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
