package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.Document;
import com.icss.StaffingSystem.service.DocumentService;;

/**
 * ����չ��Ҫ�޸��ĵ���ԭ��Ϣ�� Servlet
 * @author pineapple126
 */
public class EditDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDocumentServlet() {
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
			String id = request.getParameter("id");
			
			// 2.��������
			DocumentService documentService = new DocumentService();
			Document document = documentService.findById(Integer.parseInt(id));
			request.setAttribute("document", document);
			
			// 3.�����ת
			request.getRequestDispatcher("/document/editDocument.jsp").forward(request, response);
			
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
