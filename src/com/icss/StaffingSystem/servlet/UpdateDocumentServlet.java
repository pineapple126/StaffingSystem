package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.service.DocumentService;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

/**
 * 实现修改指定文档的 Servlet
 * @author pineapple126
 */
public class UpdateDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDocumentServlet() {
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
			// 接受用户选择上个穿的文档，然后将用户上传的本地文档上传的服务器上
			// 获取得到该文档存储在服务器上的路径
			SmartUpload smu = new SmartUpload();//创建对象
			smu.setCharset("utf-8");
			smu.initialize(this.getServletConfig(),request,response);//初始化组件
			smu.upload();//上传
			Files files = smu.getFiles();//获取上传文件的列表
			File file = files.getFile(0);//获取第一个文件
			String filepath = "";
			//判断上传文件的长度是否大于0，是否有文件上传
			if(files.getSize() > 0 && file.getSize() > 0){
				file.saveAs("C:\\Users\\pineapple126\\Desktop\\生产实习\\upload\\" + file.getFileName());//保存文件
				filepath = file.getFileName();//文件名
			}
			System.out.println(filepath);
			String id = smu.getRequest().getParameter("id");
			String title = smu.getRequest().getParameter("title");
			String remark = smu.getRequest().getParameter("remark");
			
			// 2.处理请求
			DocumentService documentService = new DocumentService();
			documentService.updateDocument(Integer.parseInt(id), title, remark, filepath);
			
			// 3.完成跳转
			// 跳转到用于分页展现公告列表的 Servlet 
			request.getRequestDispatcher("/document/DocumentListServlet").forward(request, response);
			
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
