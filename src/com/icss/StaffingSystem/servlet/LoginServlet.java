package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.service.UserService;

/**
 * 用户登录的 servlet
 * @author pineapple126
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1. 接受请求
			//（1）获取得到用户输入的登录用户名
			String loginname = request.getParameter("loginname");
			//（2）获取得到用户输入的登录密码
			String password = request.getParameter("password");
			
			//2. 处理请求 -> 想要有一个能够帮助我们实现登录功能的业务逻辑
			UserService userService = new UserService();
			int result = userService.login(loginname, password);
			
			//3. 完成跳转
			if (result == 1) {
				// 跳转到管理员登陆成功的页面上去（首页）
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			} else if (result == 2) {
				// 跳转到普通用户登陆成功的页面上去（首页）
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			}
			else if (result == 3) {
				// 传递一个错误提示到下一个资源上去
				// 跳转到登陆失败的页面上去（登录）
				request.setAttribute("errorMsg", "登录名错误");	
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (result == 4) {
				// 传递一个错误提示到下一个资源上去
				// 跳转到登录失败的页面上去（登录）
				request.setAttribute("errorMsg", "密码错误");	
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
