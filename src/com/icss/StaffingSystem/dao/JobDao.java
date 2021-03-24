package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.StaffingSystem.entity.Job;
import com.icss.StaffingSystem.entity.User;

/**
 * �й�ְλ�����ݿ����
 * @author pineapple126
 *
 */
public class JobDao {

	/**
	 * ��ѯ�õ�������ְλ�б���Ϣ
	 * @return ��ѯ�õ�������ְλ�б�
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<Job> selectAllJobList() throws ClassNotFoundException, SQLException {
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select * from job_inf";		
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		List<Job> jobList = new ArrayList<Job>();
		while (rs.next()) {
			Job job = new Job();
			job.setId(rs.getInt("ID"));
			job.setName(rs.getString("NAME"));
			job.setRemark(rs.getString("REMARK"));
			jobList.add(job);
		}		
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return jobList;
	}
	
}
