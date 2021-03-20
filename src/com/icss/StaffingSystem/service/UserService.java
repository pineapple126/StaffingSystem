package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.*;

import com.icss.StaffingSystem.dao.DocumentDao;
import com.icss.StaffingSystem.dao.NoticeDao;
import com.icss.StaffingSystem.dao.UserDao;
import com.icss.StaffingSystem.entity.User;
import com.icss.StaffingSystem.util.PageResult;

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
		User user = userDao.selectByLoginname(loginname);
		
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
	
	/**
	 * 实现获取得到的所有用户列表的业务逻辑
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
	 * 实现获取得到满足过滤条件的用户列表的业务逻辑
	 * @param username 过滤条件一：用户名
	 * @param status 过滤条件二：用户状态
	 * @return 获取得到的满足过滤条件的用户列表
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<User> findUserListByConditions(String username, String status) throws ClassNotFoundException, SQLException {
		
		UserDao userDao = new UserDao();
		
		List<User> userList = userDao.selectUserListByConditions(username, status);
		
		return userList;
	}
	
	/**
	 * 实现获取得到满足过滤条件的分页结果（分页的列表，当前的页码、共多少条、共多少页）的业务逻辑
	 * @param username 过滤条件一：用户名
	 * @param status 过滤条件二：用户状态
	 * @param currentPage 分页的已知条件一：展现的当前页码
	 * @param pageSize 分页的已知条件二：每页展现多少条
	 * @return 获取得到满足过滤条件的分页结果（分页的列表，当前的页码、共多少条、共多少页）
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
	 * 实现添加指定用户信息的业务逻辑
	 * @param username 要添加的用户名
	 * @param status 要添加的用户状态
	 * @param loginname 要添加的登录名
	 * @param password 要添加的密码
	 * @return 要添加的添加指定用户是否成功
	 * @throws Exception 
	 */
	public boolean addUser(String username, String status, String loginname, String password) throws Exception {
		
		UserDao userDao = new UserDao();
		
		User user = userDao.selectByLoginname(loginname);
		
		if (user != null) {
			return false;
		}
		
		userDao.insertUser(username, status, loginname, password);
		return true;
	}
	
	/**
	 * 实现从数据库中通过指定的用户编号查找用户信息的业务逻辑
	 * @param uid 指定的用户编号
	 * @return 查找到的用户信息
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public User findByUid(int uid) throws ClassNotFoundException, SQLException {
		
		UserDao userDao = new UserDao();
		
		User user = userDao.selectByUid(uid);
	
		return user;
	}
	
	/**
	 * 实现修改指定用户信息的业务逻辑
	 * @param uid 指定的用户编号
	 * @param username 修改后的用户名
	 * @param status 修改后的状态
	 * @param loginname 修改后的登录名
	 * @return 修改是否成功
	 * @throws Exception
	 */
	public boolean updateUser(int uid, String username, String status, String loginname) throws Exception {
		
		UserDao userDao = new UserDao();
		
		User user = userDao.selectByLoginname(loginname);
		
		if (user != null && user.getUid() != uid) {
			return false;
		}
		
		userDao.updateUser(uid, username, status, loginname);
		return true;
	}
	
	/**
	 * 实现删除多条指定用户编号的用户信息的业务逻辑
	 * @param ids 指定的用户编号
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteUsers(String ids) throws ClassNotFoundException, SQLException {
		// 1.由于用户和公告是相关联的，所以在删除用户之前，需要将他们的关联数据也删除掉
		NoticeDao noticeDao = new NoticeDao();
		noticeDao.deleteByUserids(ids);
		
		// 2.由于用户和文档中心是相关联的，所以在删除用户之前，需要将他们的关联数据也删除掉
		DocumentDao documentDao = new DocumentDao();
		documentDao.deleteByUserids(ids);
		
		// 3.从数据库里删除多条指定编号的用户信息
		UserDao userDao = new UserDao();		
		userDao.deleteUsers(ids);
		
	}
	
}
