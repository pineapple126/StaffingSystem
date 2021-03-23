package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.User;
import com.icss.StaffingSystem.service.NoticeService;

/**
 * �������ָ��������Ϣ�� Servlet
 */
public class AddNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNoticeServlet() {
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
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// ��ȡ�õ���ǰ��¼�ĵ�½�˺�
			User loginUser = (User)request.getSession().getAttribute("loginUser");
			int userid = loginUser.getUid();
			
			// 2.��������
			NoticeService noticeService = new NoticeService();
			noticeService.addNotice(title, content, userid);
			
			// 3.�����ת
			// ��ת�����ڷ�ҳչ�ֹ����б�� Servlet 
			request.getRequestDispatcher("/notice/NoticeListServlet").forward(request, response);
			
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
