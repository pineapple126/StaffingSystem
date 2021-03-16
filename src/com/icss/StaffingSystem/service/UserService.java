package com.icss.StaffingSystem.service;

import com.icss.StaffingSystem.dao.UserDao;
import com.icss.StaffingSystem.entity.User;

/**
 * �û���ص�ҵ���߼�
 * @author pineapple126
 * 
 */
public class UserService {
	
	// ������������1��������Ҫʲô����ֵ��2��������Ҫʲô������3������������ôʵ�ֵ�

	/**
	 * ʵ���û���¼��ҵ���߼�
	 * @param loginname Ҫ��½���û��ĵ�¼��
	 * @param password Ҫ��½���û�������
	 * @return 1 �������Ա��½�ɹ���2 ������ͨ�û���½�ɹ���3 �����û�������4 �����������
	 * @throws Exception 
	 */
	public int login(String loginname, String password) throws Exception {
		
		UserDao userDao = new UserDao();
		// ͨ��Ҫ��¼���û���ȥ���ݿ��в����û���Ϣ
		User user = userDao.selectByUname(loginname);
		
		// ������ҵ��û���Ϣ
			// ���жϲ��ҵ����û���Ϣ��������û������Ҫ��½������������Ƿ�һ��
			// �������һ��
				// ��ȡ�õ����ҵ��û���Ϣ���û�״̬
				// ������û�״̬��ֵΪ 1�������ǹ���Ա���ͷ��� 1
				// ������û�״̬��ֵΪ 2����������ͨ�û����ͷ��� 2
			// ������ݲ�һ��
				// ֤��������󣬾ͷ��� 4
		// ���û�в��ҵ����û���Ϣ
			// ֤���û������󣬾ͷ��� 3
		int result = 1;
		if (user != null) {
			if(user.getPassword().equals(password)) {
				String status = user.getStatus();
				//if ("1".equals(status)) {
				//	result = 1;
				//} else {
				//	result = 2;
				//}
				result = Integer.parseInt(status);
			} else {
				result = 4;
			}	
		} else {
			result = 3;
		}
		return result;
	}
	
}
