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
 * 用于实现获取得到每一个薪资等级所占百分比的 Servlet
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
			
			// 1.接受请求
			
			// 2.处理请求 -> 需要有一个能够帮助我们获取得到所有薪资等级所占百分比的业务逻辑
			EmployeeService employeeService = new EmployeeService();
			
			List<LevelPercentage> list = employeeService.findLevelPercentage();
			
			// 把得到的薪资等级所占百分比的列表转换成 JSON 格式数据
			JSONArray jsonArray = JSONArray.fromObject(list);
			
			request.setAttribute("levelPercentageJson", jsonArray);
			
			// 3.完成跳转
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
