package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.Document;
import com.icss.StaffingSystem.service.DocumentService;
import com.icss.StaffingSystem.util.PageResult;

/**
 * ��ҳչ����������������ĵ���ҳ����� Servlet
 * @author pineapple126
 */
public class DocumentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocumentListServlet() {
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
			// ���ܵ��û��������������Ĺ����������������
			String title = request.getParameter("title");
			// ���ܵ��û���Ҫ�鿴��ҳ��
			String currentPageStr = request.getParameter("currentPage");
			
			Integer currentPage = 1;
			if (currentPageStr != null && !"".equals(currentPageStr)) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			
			// ÿҳչʾ����
			Integer pageSize = 5;
			
			// 2.��������
			DocumentService documentService = new DocumentService();
			
			// �й����������з�ҳ��ȡ�û��б� -> ��Ҫһ���ܹ��������ǻ�ȡ�õ�������������ķ�ҳ�������ҳ���б���ǰ��ҳ�롢����������������ҳ����ҵ���߼�
			PageResult<Document> pageResult = documentService.pageByConditions(title, currentPage, pageSize);
			
			request.setAttribute("pageResult", pageResult);	
			
			// 3.�����ת
			request.getRequestDispatcher("/document/documentList.jsp").forward(request, response);
			
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
