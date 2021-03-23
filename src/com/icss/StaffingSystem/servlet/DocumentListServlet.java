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
 * 分页展现满足过滤条件的文档分页结果的 Servlet
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
			
			// 1.接受请求			
			// 有过滤条件、有分页获取用户列表
			// 接受到用户在浏览器上输入的过滤条件：公告标题
			String title = request.getParameter("title");
			// 接受到用户想要查看的页码
			String currentPageStr = request.getParameter("currentPage");
			
			Integer currentPage = 1;
			if (currentPageStr != null && !"".equals(currentPageStr)) {
				currentPage = Integer.parseInt(currentPageStr);
			}
			
			// 每页展示条数
			Integer pageSize = 5;
			
			// 2.处理请求
			DocumentService documentService = new DocumentService();
			
			// 有过滤条件、有分页获取用户列表 -> 需要一个能够帮助我们获取得到满足过滤条件的分页结果（分页的列表，当前的页码、共多少条、共多少页）的业务逻辑
			PageResult<Document> pageResult = documentService.pageByConditions(title, currentPage, pageSize);
			
			request.setAttribute("pageResult", pageResult);	
			
			// 3.完成跳转
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
