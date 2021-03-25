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
 * 用于注册人脸识别的 Servlet
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
			
			// 1.接受请求
			// 接受得到上传的人脸图片
			String img = request.getParameter("img");
			// 获取得到哪个用户正在进行人脸注册
			User u = (User)request.getSession().getAttribute("loginUser");
			
			String userinfo = JSONObject.fromObject(u).toString();
			
			// 2.处理请求
			// （1）向百度 AI 中进行人脸注册
			String resp = FaceUtil.faceRegister(img, userinfo, "StaffingSystem", u.getUid()+"");
			// 解析结果，判断是否注册成功
			JSONObject jsonObj = JSONObject.fromObject(resp);
			String msg = jsonObj.getString("error_msg").toString();
			
			PrintWriter out = response.getWriter();//给出响应内容
			if ("SUCCESS".equals(msg)) {
				// （2）如果成功将人脸图片上传到了百度 AI 人脸库中，则需要一个能帮助我们实现修改指定用户的人脸注册标识的业务逻辑
				out.print("SUCCESS");
			} else {
				out.print("FAIL");
			}
			
			// 3.完成跳转 -> 给出响应
			
			
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
