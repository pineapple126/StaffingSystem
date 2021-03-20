package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 文档中心相关的增删改查
 * @author pineapple126
 *
 */
public class DocumentDao {

	/**
	 * 从数据库中删除和指定多个用户相关联的w文档信息
	 * @param ids 指定的多个用户编号
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void deleteByUserids(String ids) throws ClassNotFoundException, SQLException {
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "delete from document_inf where userid in(" + ids + ")";	
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6、释放资源
		st.close();
		conn.close();
		
	}
	
}
