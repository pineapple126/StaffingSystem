package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
}
