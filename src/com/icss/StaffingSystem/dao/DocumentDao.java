package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.StaffingSystem.entity.Document;

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
	
	/**
	 * 查询得到满足过滤条件的分页列表
	 * @param title 过滤条件：文档标题
	 * @param firstResult 起始条数
	 * @param pageSize 每页展现多少条
	 * @return 满足过滤条件的分页列表
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Document> pageByConditions(String title, Integer firstResult, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select d.*, u.loginname from document_inf d, user_inf u where d.userid=u.uid";	
		
		if (title != null && !"".equals(title)) {
			sql += " and d.title like '%" + title + "%'";
		}
		sql += " limit ?,?";

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, firstResult);
		st.setInt(2, pageSize);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		List<Document> noticeList = new ArrayList<Document>();
		while (rs.next()) {
			Document notice = new Document();
			notice.setId(rs.getInt("ID"));
			notice.setTitle(rs.getString("TITLE"));
			notice.setCreatedate(rs.getTimestamp("CREATEDATE"));
			notice.setUserid(rs.getInt("USERID"));
			notice.setLoginname(rs.getString("LOGINNAME"));
			noticeList.add(notice);
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return noticeList;
		
	}

	/**
	 * 查询得到满足过滤条件的文档数量
	 * @param title 过滤条件：文档标题
	 * @return 满足过滤条件的文档数量
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int countByConditions(String title) throws ClassNotFoundException, SQLException{
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select count(*) from document_inf where 1=1";	
		
		if (title != null && !"".equals(title)) {
			sql += " and title like '%" + title + "%'";
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
	
}
