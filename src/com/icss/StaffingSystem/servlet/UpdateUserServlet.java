package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.User;
import com.icss.StaffingSystem.service.UserService;

/**
 * 用于实现修改指定用户信息的 Servlet
 * @author pineapple126
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
			String uid = request.getParameter("uid");
			String username = request.getParameter("username");
			String status = request.getParameter("status");
			String loginname = request.getParameter("loginname");
			
			// 2.处理请求
			UserService userService = new UserService();
			boolean flag = userService.updateUser(Integer.parseInt(uid), username, status, loginname);
			
			// 3.完成跳转
			if (flag) {
				request.getRequestDispatcher("/user/UserListServlet").forward(request, response);
			} else {
				request.setAttribute("errorMsg", "该登录名已被占用，请重新输入！");
				// 获取得到要修改的用户信息，然后将得到的用户信息传递到下一个资源上去
				User user = userService.findByUid(Integer.parseInt(uid));
				request.setAttribute("user", user);
				request.getRequestDispatcher("/user/editUser.jsp").forward(request, response);
			}
			
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
