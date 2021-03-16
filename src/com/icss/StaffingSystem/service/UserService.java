package com.icss.StaffingSystem.service;

import com.icss.StaffingSystem.dao.UserDao;
import com.icss.StaffingSystem.entity.User;

/**
 * 用户相关的业务逻辑
 * @author pineapple126
 * 
 */
public class UserService {
	
	// 创建方法：（1）方法需要什么返回值（2）方法需要什么参数（3）方法体是怎么实现的

	/**
	 * 实现用户登录的业务逻辑
	 * @param loginname 要登陆的用户的登录名
	 * @param password 要登陆的用户的密码
	 * @return 1 代表管理员登陆成功、2 代表普通用户登陆成功、3 代表用户名错误、4 代表密码错误
	 * @throws Exception 
	 */
	public int login(String loginname, String password) throws Exception {
		
		UserDao userDao = new UserDao();
		// 通过要登录的用户名去数据库中查找用户信息
		User user = userDao.selectByUname(loginname);
		
		// 如果查找到用户信息
			// 则判断查找到的用户信息的密码和用户输入的要登陆的密码的内容是否一致
			// 如果内容一致
				// 获取得到查找的用户信息的用户状态
				// 如果该用户状态的值为 1，代表是管理员，就返回 1
				// 如果该用户状态的值为 2，代表是普通用户，就返回 2
			// 如果内容不一致
				// 证明密码错误，就返回 4
		// 如果没有查找到该用户信息
			// 证明用户名错误，就返回 3
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
