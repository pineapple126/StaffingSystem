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
 * չʾ�û��б�� servlet -> ����Ϊչ����������������û��б�չʾ�� servlet -> ����Ϊ��������������ҷ�ҳ���û��б�չʾ�� servlet
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
			// 1.��������
			// �׶�1���޹����������޷�ҳ��ȡ�û��б��޲���
			
			// �׶�2���й����������޷�ҳ��ȡ�û��б�
			String username = request.getParameter("username");
			String status = request.getParameter("status");
			
			// �׶�3���й����������з�ҳ��ȡ�û��б�
			// ���ܵ��û���Ҫ�鿴��ҳ��
			String currentPageStr = request.getParameter("currentPage");
			
			Integer currentPage = 1;
			if (currentPageStr != null && !"".equals(currentPageStr)) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			
			// ÿҳչʾ����
			Integer pageSize = 5;
			
			// 2.��������
			UserService userService = new UserService();
			
			// �׶�1���޹����������޷�ҳ��ȡ�û��б�
			// List<User> userList = userService.findAllUserList();
			
			// �׶�2���й����������޷�ҳ��ȡ�û��б�
			// List<User> userList = userService.findUserListByCondition(username, status);
			
			// �׶�3���й����������з�ҳ��ȡ�û��б� -> ��Ҫһ���ܹ��������ǻ�ȡ�õ�������������ķ�ҳ�������ҳ���б���ǰ��ҳ�롢����������������ҳ����ҵ���߼�
			PageResult<User> pageResult = userService.pageByConditions(username, status, currentPage, pageSize);
			
			request.setAttribute("pageResult", pageResult);	
			
			// 3.�����ת
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
