package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * �ĵ�������ص���ɾ�Ĳ�
 * @author pineapple126
 *
 */
public class DocumentDao {

	/**
	 * �����ݿ���ɾ����ָ������û��������w�ĵ���Ϣ
	 * @param ids ָ���Ķ���û����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void deleteByUserids(String ids) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "delete from document_inf where userid in(" + ids + ")";	
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
	}
	
}
