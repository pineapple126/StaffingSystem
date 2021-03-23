package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.Notice;
import com.icss.StaffingSystem.service.NoticeService;
import com.icss.StaffingSystem.util.PageResult;

/**
 * ��������������ҷ�ҳչʾ�����б��� Servlet
 * @author pineapple126
 */
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
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
			// �й����������з�ҳ��ȡ�û��б�
			// ���ܵ��û��������������Ĺ�������һ���������
			String title = request.getParameter("title");
			// ���ܵ��û��������������Ĺ�������������������
			String content = request.getParameter("content");
			// ���ܵ��û���Ҫ�鿴��ҳ��
			String currentPageStr = request.getParameter("currentPage");
			
			Integer currentPage = 1;
			if (currentPageStr != null && !"".equals(currentPageStr)) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			
			// ÿҳչʾ����
			Integer pageSize = 5;
			
			// 2.��������
			NoticeService noticeService = new NoticeService();
			
			// �й����������з�ҳ��ȡ�û��б� -> ��Ҫһ���ܹ��������ǻ�ȡ�õ�������������ķ�ҳ�������ҳ���б�����ǰ��ҳ�롢����������������ҳ����ҵ���߼�
			PageResult<Notice> pageResult = noticeService.pageByConditions(title, content, currentPage, pageSize);
			
			request.setAttribute("pageResult", pageResult);	
			
			// 3.�����ת
			request.getRequestDispatcher("/notice/noticeList.jsp").forward(request, response);
			
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