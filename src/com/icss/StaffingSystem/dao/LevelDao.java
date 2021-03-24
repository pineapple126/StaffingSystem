package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.StaffingSystem.entity.Level;

/**
 * 有关薪资等级的数据库操作
 * @author pineapple126
 *
 */
public class LevelDao {

	/**
	 * 查询得到的所有薪资等级列表信息
	 * @return 查询得到的所有薪资等级列表
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<Level> selectAllLevelList() throws ClassNotFoundException, SQLException {
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select * from level_inf";		
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		List<Level> levelList = new ArrayList<Level>();
		while (rs.next()) {
			Level level = new Level();
			level.setId(rs.getInt("ID"));
			level.setRange(rs.getString("RANGE"));
			level.setMinsalary(rs.getDouble("MINSALARY"));
			level.setMaxsalary(rs.getDouble("MAXSALARY"));
			levelList.add(level);
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return levelList;
	}
	
}
