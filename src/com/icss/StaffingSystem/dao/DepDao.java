package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.StaffingSystem.entity.Dep;

/**
 * 有关部门的数据库操作
 * @author pineapple126
 *
 */
public class DepDao {

	/**
	 * 查询得到的所有部门列表信息
	 * @return 查询得到的所有部门列表
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<Dep> selectAllJobList() throws ClassNotFoundException, SQLException {
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select * from dep_inf";		
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		List<Dep> depList = new ArrayList<Dep>();
		while (rs.next()) {
			Dep dep = new Dep();
			dep.setId(rs.getInt("ID"));
			dep.setName(rs.getString("NAME"));
			dep.setRemark(rs.getString("REMARK"));
			depList.add(dep);
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return depList;
	}
	
}
