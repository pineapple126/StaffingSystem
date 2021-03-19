package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import com.icss.StaffingSystem.entity.User;

/**
 * 用户表相关的数据库操作
 * @author pineapple126
 * 
 */
public class UserDao {

	/**
	 * 通过指定的用户名查找用户信息
	 * @param loginname 指定要查找的登录名
	 * @return 如果查找到返回的是查找到的用户信息，否则返回 null
	 * @throws Exception
	 */
	public User selectByUname(String loginname) throws Exception {
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select * from user_inf where loginname=?";		
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, loginname);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setUid(rs.getInt("UID"));
			user.setLoginname(rs.getString("LOGINNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setStatus(rs.getString("STATUS"));
			user.setCreatedate(rs.getTimestamp("CREATEDATE"));
			user.setUsername(rs.getString("USERNAME"));
			user.setIsface(rs.getString("ISFACE"));
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return user;
	}
	
	/**
	 * 查询得到的所有用户列表信息
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<User> selectAllUserList() throws ClassNotFoundException, SQLException {
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select * from user_inf";		
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		List<User> userList = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setUid(rs.getInt("UID"));
			user.setLoginname(rs.getString("LOGINNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setStatus(rs.getString("STATUS"));
			user.setCreatedate(rs.getTimestamp("CREATEDATE"));
			user.setUsername(rs.getString("USERNAME"));
			user.setIsface(rs.getString("ISFACE"));
			userList.add(user);
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return userList;
	}
	
	
	/**
	 * 查询得到满足过滤条件的用户列表
	 * @param username 过滤条件一：用户名
	 * @param status 过滤条件二：用户状态
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<User> selectUserListByCondition(String username, String status) throws ClassNotFoundException, SQLException {
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select * from user_inf where 1=1";	
		
		if (username != null && !"".equals(username)) {
			sql += " and username='" + username + "'";
		}
		if (status != null && !"".equals(status)) {
			sql += " and status='" + status + "'";
		}

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		List<User> userList = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setUid(rs.getInt("UID"));
			user.setLoginname(rs.getString("LOGINNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setStatus(rs.getString("STATUS"));
			user.setCreatedate(rs.getTimestamp("CREATEDATE"));
			user.setUsername(rs.getString("USERNAME"));
			user.setIsface(rs.getString("ISFACE"));
			userList.add(user);
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return userList;
	}
	
	/**
	 * 查询得到满足过滤条件的分页列表
	 * @param username 过滤条件一：用户名
	 * @param status 过滤条件二：用户状态
	 * @param firstResult 起始条数
	 * @param pageSize 每页展现多少条
	 * @return 满足过滤条件的分页列表
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<User> pageByConditions(String username, String status, Integer firstResult, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select * from user_inf where 1=1";	
		
		if (username != null && !"".equals(username)) {
			sql += " and username='" + username + "'";
		}
		if (status != null && !"".equals(status)) {
			sql += " and status='" + status + "'";
		}
		sql += " limit ?,?";

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, firstResult);
		st.setInt(2, pageSize);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		List<User> userList = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setUid(rs.getInt("UID"));
			user.setLoginname(rs.getString("LOGINNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setStatus(rs.getString("STATUS"));
			user.setCreatedate(rs.getTimestamp("CREATEDATE"));
			user.setUsername(rs.getString("USERNAME"));
			user.setIsface(rs.getString("ISFACE"));
			userList.add(user);
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return userList;
		
	}
	
	/**
	 * 查询得到满足过滤条件的用户数量
	 * @param username 过滤条件一：用户名
	 * @param status 过滤条件二：用户状态
	 * @return 满足过滤条件的用户数量
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public int countByConditions(String username, String status) throws ClassNotFoundException, SQLException{
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select count(*) from user_inf where 1=1";	
		
		if (username != null && !"".equals(username)) {
			sql += " and username='" + username + "'";
		}
		if (status != null && !"".equals(status)) {
			sql += " and status='" + status + "'";
		}

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		int totalCount = 0;
		if (rs.next()) {
			totalCount = rs.getInt(1); // 获取到 rs 这一行指定的第一列对应的值
		}
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return totalCount;
	}
	
	/**
	 * 向数据库添加一条用户信息
	 * @param username 要添加的用户名
	 * @param status 要添加的状态
	 * @param loginname 要添加的登录名
	 * @param password 要添加的密码
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void insertUser(String username, String status, String loginname, String password) throws ClassNotFoundException, SQLException {
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "insert into user_inf(loginname, password, status, createdate, username, isface) values(?, ?, ?, ?, ?, ?)";	
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, loginname);
		st.setString(2, password);
		st.setString(3, status);
		st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		st.setString(5, username);
		st.setString(6, "2");
		st.execute();
		
		//6、释放资源
		st.close();
		conn.close();
		
	}
	
	/**
	 * 通过指定的用户编号查询用户信息
	 * @param uid 查找的 uid
	 * @return 查询得到的用户信息，或者 null
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User selectByUid(int uid) throws ClassNotFoundException, SQLException {
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select * from user_inf where uid=?";		
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, uid);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setUid(rs.getInt("UID"));
			user.setLoginname(rs.getString("LOGINNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setStatus(rs.getString("STATUS"));
			user.setCreatedate(rs.getTimestamp("CREATEDATE"));
			user.setUsername(rs.getString("USERNAME"));
			user.setIsface(rs.getString("ISFACE"));
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return user;		
		
	}
	
}
