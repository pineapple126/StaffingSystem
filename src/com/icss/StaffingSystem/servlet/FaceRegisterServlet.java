package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.entity.User;
import com.icss.StaffingSystem.util.FaceUtil;

import net.sf.json.JSONObject;

/**
 * ����ע������ʶ��� Servlet
 * @author pineapple126
 */
public class FaceRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaceRegisterServlet() {
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
			// ���ܵõ��ϴ�������ͼƬ
			String img = request.getParameter("img");
			// ��ȡ�õ��ĸ��û����ڽ�������ע��
			User u = (User)request.getSession().getAttribute("loginUser");
			
			String userinfo = JSONObject.fromObject(u).toString();
			
			// 2.��������
			// ��1����ٶ� AI �н�������ע��
			String resp = FaceUtil.faceRegister(img, userinfo, "StaffingSystem", u.getUid()+"");
			// ����������ж��Ƿ�ע��ɹ�
			JSONObject jsonObj = JSONObject.fromObject(resp);
			String msg = jsonObj.getString("error_msg").toString();
			
			PrintWriter out = response.getWriter();//������Ӧ����
			if ("SUCCESS".equals(msg)) {
				// ��2������ɹ�������ͼƬ�ϴ����˰ٶ� AI �������У�����Ҫһ���ܰ�������ʵ���޸�ָ���û�������ע���ʶ��ҵ���߼�
				out.print("SUCCESS");
			} else {
				out.print("FAIL");
			}
			
			// 3.�����ת -> ������Ӧ
			
			
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
