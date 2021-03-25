package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.service.EmployeeService;
import com.icss.StaffingSystem.util.LevelPercentage;

import net.sf.json.JSONArray;

/**
 * ����ʵ�ֻ�ȡ�õ�ÿһ��н�ʵȼ���ռ�ٷֱȵ� Servlet
 * @author pineapple126
 */
public class EmployeeStatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeStatisticsServlet() {
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
			
			// 2.�������� -> ��Ҫ��һ���ܹ��������ǻ�ȡ�õ�����н�ʵȼ���ռ�ٷֱȵ�ҵ���߼�
			EmployeeService employeeService = new EmployeeService();
			
			List<LevelPercentage> list = employeeService.findLevelPercentage();
			
			// �ѵõ���н�ʵȼ���ռ�ٷֱȵ��б�ת���� JSON ��ʽ����
			JSONArray jsonArray = JSONArray.fromObject(list);
			
			request.setAttribute("levelPercentageJson", jsonArray);
			
			// 3.�����ת
			request.getRequestDispatcher("/employee/showEmployeeStatistics.jsp").forward(request, response);
			
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
