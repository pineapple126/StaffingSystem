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
 * �й�н�ʵȼ������ݿ����
 * @author pineapple126
 *
 */
public class LevelDao {

	/**
	 * ��ѯ�õ�������н�ʵȼ��б���Ϣ
	 * @return ��ѯ�õ�������н�ʵȼ��б�
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<Level> selectAllLevelList() throws ClassNotFoundException, SQLException {
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select * from level_inf";		
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		List<Level> levelList = new ArrayList<Level>();
		while (rs.next()) {
			Level level = new Level();
			level.setId(rs.getInt("ID"));
			level.setRange(rs.getString("RANGE"));
			level.setMinsalary(rs.getDouble("MINSALARY"));
			level.setMaxsalary(rs.getDouble("MAXSALARY"));
			levelList.add(level);
		}		
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return levelList;
	}
	
}
