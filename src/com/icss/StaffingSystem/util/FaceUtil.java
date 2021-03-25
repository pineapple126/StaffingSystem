package com.icss.StaffingSystem.util;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;



/**
 * 人脸识别工具类
 * @author pineapple126
 *
 */
public class FaceUtil {

	//设置APPID/AK/SK
    public static final String APP_ID = "23866262";
    public static final String API_KEY = "5DEDaQvwVOmUBk69Uh0Vb6ij";
    public static final String SECRET_KEY = "s5Pcx2ly1Epx8Gq5LRwG7G204C67ZObv";
    
    static AipFace client = null;
    
    static {
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        //可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }
	
	/**
	 * 人脸注册
	 * @param image 注册图片
	 * @param userinfo 用户资料
	 * @param groupId 人脸库用户组编号
	 * @param userId 人脸注册的信息
	 * @return 人脸注册的信息
	 */
	public static String faceRegister(String image, String userinfo, String groupId, String userId) {
		
		// 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("user_info", userinfo);
	    options.put("quality_control", "NORMAL");
	    options.put("liveness_control", "LOW");
	    options.put("action_type", "REPLACE");
	    
	    String imageType = "BASE64";
	    
	    // 人脸注册
	    JSONObject res = client.addUser(image, imageType, groupId, userId, options);
	    System.out.println(res.toString(2));
	    return res.toString(2);
	    
	}
	
}
