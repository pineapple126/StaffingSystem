package com.icss.StaffingSystem.servlet;

import java.util.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.User;
import com.icss.StaffingSystem.service.UserService;
import com.icss.StaffingSystem.util.PageResult;

/**
 * 展示用户列表的 servlet -> 完善为展现满足过滤条件的用户列表展示的 servlet -> 完善为满足过滤条件并且分页的用户列表展示的 servlet
 * @author pineapple126
 * 
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			// 1.接受请求
			// 阶段1：无过滤条件、无分页获取用户列表。无参数
			
			// 阶段2：有过滤条件、无分页获取用户列表。
			String username = request.getParameter("username");
			String status = request.getParameter("status");
			
			// 阶段3：有过滤条件、有分页获取用户列表
			// 接受到用户想要查看的页码
			String currentPageStr = request.getParameter("currentPage");
			
			Integer currentPage = 1;
			if (currentPageStr != null && !"".equals(currentPageStr)) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			
			// 每页展示条数
			Integer pageSize = 5;
			
			// 2.处理请求
			UserService userService = new UserService();
			
			// 阶段1：无过滤条件、无分页获取用户列表
			// List<User> userList = userService.findAllUserList();
			
			// 阶段2：有过滤条件、无分页获取用户列表
			// List<User> userList = userService.findUserListByCondition(username, status);
			
			// 阶段3：有过滤条件、有分页获取用户列表 -> 需要一个能够帮助我们获取得到满足过滤条件的分页结果（分页的列表，当前的页码、共多少条、共多少页）的业务逻辑
			PageResult<User> pageResult = userService.pageByConditions(username, status, currentPage, pageSize);
			
			request.setAttribute("pageResult", pageResult);	
			
			// 3.完成跳转
			request.getRequestDispatcher("/user/userList.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
