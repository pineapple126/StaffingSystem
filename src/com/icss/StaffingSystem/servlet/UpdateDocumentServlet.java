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
 * ʵ���޸�ָ���ĵ��� Servlet
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
			
			// 1.��������			
			// �����û�ѡ���ϸ������ĵ���Ȼ���û��ϴ��ı����ĵ��ϴ��ķ�������
			// ��ȡ�õ����ĵ��洢�ڷ������ϵ�·��
			SmartUpload smu = new SmartUpload();//��������
			smu.setCharset("utf-8");
			smu.initialize(this.getServletConfig(),request,response);//��ʼ�����
			smu.upload();//�ϴ�
			Files files = smu.getFiles();//��ȡ�ϴ��ļ����б�
			File file = files.getFile(0);//��ȡ��һ���ļ�
			String filepath = "";
			//�ж��ϴ��ļ��ĳ����Ƿ����0���Ƿ����ļ��ϴ�
			if(files.getSize() > 0 && file.getSize() > 0){
				file.saveAs("C:\\Users\\pineapple126\\Desktop\\����ʵϰ\\upload\\" + file.getFileName());//�����ļ�
				filepath = file.getFileName();//�ļ���
			}
			System.out.println(filepath);
			String id = smu.getRequest().getParameter("id");
			String title = smu.getRequest().getParameter("title");
			String remark = smu.getRequest().getParameter("remark");
			
			// 2.��������
			DocumentService documentService = new DocumentService();
			documentService.updateDocument(Integer.parseInt(id), title, remark, filepath);
			
			// 3.�����ת
			// ��ת�����ڷ�ҳչ�ֹ����б�� Servlet 
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
