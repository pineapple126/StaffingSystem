package com.icss.StaffingSystem.util;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;



/**
 * ����ʶ�𹤾���
 * @author pineapple126
 *
 */
public class FaceUtil {

	//����APPID/AK/SK
    public static final String APP_ID = "23866262";
    public static final String API_KEY = "5DEDaQvwVOmUBk69Uh0Vb6ij";
    public static final String SECRET_KEY = "s5Pcx2ly1Epx8Gq5LRwG7G204C67ZObv";
    
    static AipFace client = null;
    
    static {
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        //��ѡ�������������Ӳ���
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }
	
	/**
	 * ����ע��
	 * @param image ע��ͼƬ
	 * @param userinfo �û�����
	 * @param groupId �������û�����
	 * @param userId ����ע�����Ϣ
	 * @return ����ע�����Ϣ
	 */
	public static String faceRegister(String image, String userinfo, String groupId, String userId) {
		
		// �����ѡ�������ýӿ�
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("user_info", userinfo);
	    options.put("quality_control", "NORMAL");
	    options.put("liveness_control", "LOW");
	    options.put("action_type", "REPLACE");
	    
	    String imageType = "BASE64";
	    
	    // ����ע��
	    JSONObject res = client.addUser(image, imageType, groupId, userId, options);
	    System.out.println(res.toString(2));
	    return res.toString(2);
	    
	}
	
}
