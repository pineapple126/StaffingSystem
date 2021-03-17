package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.icss.StaffingSystem.entity.User;

/**
 * �û�����ص����ݿ����
 * @author pineapple126
 * 
 */
public class UserDao {

	/**
	 * ͨ��ָ�����û��������û���Ϣ
	 * @param loginname ָ��Ҫ���ҵĵ�¼��
	 * @return ������ҵ����ص��ǲ��ҵ����û���Ϣ�����򷵻� null
	 * @throws Exception
	 */
	public User selectByUname(String loginname) throws Exception {
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select * from user_inf where loginname=?";		
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, loginname);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setUid(rs.getInt("UID"));
			user.setLoginname(rs.getString("LOGINNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setStatus(rs.getString("STATUS"));
			user.setCreatedate(rs.getTimestamp("CREATEDATE"));
			user.setUsername(rs.getString("USERNAME"));
			user.setIsface(rs.getString("ISFACE"));
		}		
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return user;
	}
	
	/**
	 * ��ѯ�õ��������û��б���Ϣ
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<User> selectAllUserList() throws ClassNotFoundException, SQLException {
		//1������JDBC����
				Class.forName("com.mysql.jdbc.Driver");
				
				//2���������ݿ�����
				Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
				
				//3����д��Ҫִ�е�sql���
				String sql = "select * from user_inf";		
				
				//4������ִ��SQL����Statement����
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
				List<User> userList = new ArrayList<User>();
				while (rs.next()) {
					User user = new User();
					user.setUid(rs.getInt("UID"));
					user.setLoginname(rs.getString("LOGINNAME"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setStatus(rs.getString("STATUS"));
					user.setCreatedate(rs.getTimestamp("CREATEDATE"));
					user.setUsername(rs.getString("USERNAME"));
					user.setIsface(rs.getString("ISFACE"));
					userList.add(user);
				}		
				
				//6���ͷ���Դ
				rs.close();
				st.close();
				conn.close();
				
				return userList;
	}
	
}
