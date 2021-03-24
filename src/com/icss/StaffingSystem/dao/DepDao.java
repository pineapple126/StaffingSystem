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
 * �йز��ŵ����ݿ����
 * @author pineapple126
 *
 */
public class DepDao {

	/**
	 * ��ѯ�õ������в����б���Ϣ
	 * @return ��ѯ�õ������в����б�
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<Dep> selectAllJobList() throws ClassNotFoundException, SQLException {
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select * from dep_inf";		
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		List<Dep> depList = new ArrayList<Dep>();
		while (rs.next()) {
			Dep dep = new Dep();
			dep.setId(rs.getInt("ID"));
			dep.setName(rs.getString("NAME"));
			dep.setRemark(rs.getString("REMARK"));
			depList.add(dep);
		}		
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return depList;
	}
	
}
