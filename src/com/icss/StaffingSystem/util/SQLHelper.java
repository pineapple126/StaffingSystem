package com.icss.StaffingSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ��������ɾ�Ĳ鷽��
 * @author pineapple126
 *
 */
public class SQLHelper {
	
	/**
	 * SQL ����
	 */
	private Connection conn = null;
	
	public SQLHelper() throws ClassNotFoundException, SQLException {
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		//2���������ݿ�����
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
	}

	/**
	 * �������ݿ�Ĳ���
	 * @param sql
	 * @return �����Ƿ�ɹ�
	 * @throws SQLException 
	 */
	public boolean insert(String sql) throws SQLException {
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
		return true;
	}
	
	/**
	 * ɾ�����ݿ�Ĳ���
	 * @param sql
	 * @return ɾ���Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean delete(String sql) throws SQLException {
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
		return true;
	}
	
	/**
	 * �޸����ݿ�Ĳ���
	 * @param sql
	 * @return �޸��Ƿ�ɹ�
	 * @throws SQLException
	 */
	public boolean update(String sql) throws SQLException {
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
		return true;
	}
	
	/**
	 * ��ѯ���ݿ�Ĳ���
	 * @param sql
	 * @return ��ѯ���Ľ�������� null
	 * @throws SQLException
	 */
	public ResultSet select(String sql) throws SQLException {
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return rs;
	}
	
}
