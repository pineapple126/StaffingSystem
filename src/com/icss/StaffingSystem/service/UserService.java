package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.*;

import com.icss.StaffingSystem.dao.UserDao;
import com.icss.StaffingSystem.entity.User;
import com.icss.StaffingSystem.util.PageResult;

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
	
	/**
	 * ʵ�ֻ�ȡ�õ��������û��б��ҵ���߼�
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<User> findAllUserList() throws ClassNotFoundException, SQLException {
		
		UserDao userDao = new UserDao();
		
		List<User> userList = userDao.selectAllUserList();
		
		return userList;
	}
	
	/**
	 * ʵ�ֻ�ȡ�õ���������������û��б��ҵ���߼�
	 * @param username ��������һ���û���
	 * @param status �������������û�״̬
	 * @return ��ȡ�õ�����������������û��б�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<User> findUserListByCondition(String username, String status) throws ClassNotFoundException, SQLException {
		
		UserDao userDao = new UserDao();
		
		List<User> userList = userDao.selectUserListByCondition(username, status);
		
		return userList;
	}
	
	/**
	 * ʵ�ֻ�ȡ�õ�������������ķ�ҳ�������ҳ���б���ǰ��ҳ�롢����������������ҳ����ҵ���߼�
	 * @param username ��������һ���û���
	 * @param status �������������û�״̬
	 * @param currentPage ��ҳ����֪����һ��չ�ֵĵ�ǰҳ��
	 * @param pageSize ��ҳ����֪��������ÿҳչ�ֶ�����
	 * @return ��ȡ�õ�������������ķ�ҳ�������ҳ���б���ǰ��ҳ�롢����������������ҳ��
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public PageResult<User> pageByConditions(String username, String status, Integer currentPage, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		PageResult<User> pageResult = new PageResult<User>();
		
		UserDao userDao = new UserDao();
		Integer firstResult = (currentPage - 1) * pageSize;
		List<User> list = userDao.pageByConditions(username, status, firstResult, pageSize);
		int totalCount = userDao.countByConditions(username, status);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		pageResult.setList(list);
		pageResult.setCurrentPage(currentPage);
		pageResult.setTotalCount(totalCount);
		pageResult.setTotalPage(totalPage);
	
		return pageResult;
	}
	
	/**
	 * ʵ�����ָ���û���Ϣ��ҵ���߼�
	 * @param username Ҫ��ӵ��û���
	 * @param status Ҫ��ӵ��û�״̬
	 * @param loginname Ҫ��ӵĵ�¼��
	 * @param password Ҫ��ӵ�����
	 * @return Ҫ��ӵ����ָ���û��Ƿ�ɹ�
	 * @throws Exception 
	 */
	public boolean addUser(String username, String status, String loginname, String password) throws Exception {
		
		UserDao userDao = new UserDao();
		
		User u = userDao.selectByUname(loginname);
		
		if (u != null) {
			return false;
		}
		
		userDao.insertUser(username, status, loginname, password);
		return true;
	}
	
}
