package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.service.UserService;

/**
 * �û���¼�� servlet
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
			//1. ��������
			//��1����ȡ�õ��û�����ĵ�¼�û���
			String loginname = request.getParameter("loginname");
			//��2����ȡ�õ��û�����ĵ�¼����
			String password = request.getParameter("password");
			
			//2. �������� -> ��Ҫ��һ���ܹ���������ʵ�ֵ�¼���ܵ�ҵ���߼�
			UserService userService = new UserService();
			int result = userService.login(loginname, password);
			
			//3. �����ת
			if (result == 1) {
				// ��ת������Ա��½�ɹ���ҳ����ȥ����ҳ��
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			} else if (result == 2) {
				// ��ת����ͨ�û���½�ɹ���ҳ����ȥ����ҳ��
				request.getRequestDispatcher("/main.jsp").forward(request, response);
			}
			else if (result == 3) {
				// ����һ��������ʾ����һ����Դ��ȥ
				// ��ת����½ʧ�ܵ�ҳ����ȥ����¼��
				request.setAttribute("errorMsg", "��¼������");	
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else if (result == 4) {
				// ����һ��������ʾ����һ����Դ��ȥ
				// ��ת����¼ʧ�ܵ�ҳ����ȥ����¼��
				request.setAttribute("errorMsg", "�������");	
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
