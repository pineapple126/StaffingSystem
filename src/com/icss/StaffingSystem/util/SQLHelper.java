package com.icss.StaffingSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库操作的增删改查方法
 * @author pineapple126
 *
 */
public class SQLHelper {
	
	/**
	 * SQL 连接
	 */
	private Connection conn = null;
	
	public SQLHelper() throws ClassNotFoundException, SQLException {
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、建立数据库连接
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
	}

	/**
	 * 增加数据库的操作
	 * @param sql
	 * @return 增加是否成功
	 * @throws SQLException 
	 */
	public boolean insert(String sql) throws SQLException {
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6、释放资源
		st.close();
		conn.close();
		
		return true;
	}
	
	/**
	 * 删除数据库的操作
	 * @param sql
	 * @return 删除是否成功
	 * @throws SQLException
	 */
	public boolean delete(String sql) throws SQLException {
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6、释放资源
		st.close();
		conn.close();
		
		return true;
	}
	
	/**
	 * 修改数据库的操作
	 * @param sql
	 * @return 修改是否成功
	 * @throws SQLException
	 */
	public boolean update(String sql) throws SQLException {
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6、释放资源
		st.close();
		conn.close();
		
		return true;
	}
	
	/**
	 * 查询数据库的操作
	 * @param sql
	 * @return 查询到的结果集或者 null
	 * @throws SQLException
	 */
	public ResultSet select(String sql) throws SQLException {
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return rs;
	}
	
}
