package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.Notice;
import com.icss.StaffingSystem.service.NoticeService;

/**
 * 用于实现展现公告详情的 Servlet
 * @author pineapple126
 */
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
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
			// 接受得到想要展现的公告详情的公告编号
			String id = request.getParameter("id");
			
			//2.处理请求
			NoticeService noticeService = new NoticeService();
			Notice notice = noticeService.findById(Integer.parseInt(id));
			request.setAttribute("notice", notice);
			
			//3.完成跳转
			request.getRequestDispatcher("/notice/noticeDetail.jsp").forward(request, response);
			
		} catch(Exception e) {
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
