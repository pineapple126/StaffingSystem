package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	
	
	/**
	 * ��ѯ�õ���������������û��б�
	 * @param username ��������һ���û���
	 * @param status �������������û�״̬
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<User> selectUserListByCondition(String username, String status) throws ClassNotFoundException, SQLException {
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select * from user_inf where 1=1";	
		
		if (username != null && !"".equals(username)) {
			sql += " and username='" + username + "'";
		}
		if (status != null && !"".equals(status)) {
			sql += " and status='" + status + "'";
		}

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
	
	/**
	 * ��ѯ�õ�������������ķ�ҳ�б�
	 * @param username ��������һ���û���
	 * @param status �������������û�״̬
	 * @param firstResult ��ʼ����
	 * @param pageSize ÿҳչ�ֶ�����
	 * @return ������������ķ�ҳ�б�
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<User> pageByConditions(String username, String status, Integer firstResult, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select * from user_inf where 1=1";	
		
		if (username != null && !"".equals(username)) {
			sql += " and username='" + username + "'";
		}
		if (status != null && !"".equals(status)) {
			sql += " and status='" + status + "'";
		}
		sql += " limit ?,?";

		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, firstResult);
		st.setInt(2, pageSize);
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
	
	/**
	 * ��ѯ�õ���������������û�����
	 * @param username ��������һ���û���
	 * @param status �������������û�״̬
	 * @return ��������������û�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public int countByConditions(String username, String status) throws ClassNotFoundException, SQLException{
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select count(*) from user_inf where 1=1";	
		
		if (username != null && !"".equals(username)) {
			sql += " and username='" + username + "'";
		}
		if (status != null && !"".equals(status)) {
			sql += " and status='" + status + "'";
		}

		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		int totalCount = 0;
		if (rs.next()) {
			totalCount = rs.getInt(1); // ��ȡ�� rs ��һ��ָ���ĵ�һ�ж�Ӧ��ֵ
		}
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return totalCount;
	}
	
	/**
	 * �����ݿ����һ���û���Ϣ
	 * @param username Ҫ��ӵ��û���
	 * @param status Ҫ��ӵ�״̬
	 * @param loginname Ҫ��ӵĵ�¼��
	 * @param password Ҫ��ӵ�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void insertUser(String username, String status, String loginname, String password) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "insert into user_inf(loginname, password, status, createdate, username, isface) values(?, ?, ?, ?, ?, ?)";	
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, loginname);
		st.setString(2, password);
		st.setString(3, status);
		st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		st.setString(5, username);
		st.setString(6, "2");
		st.execute();
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
	}
	
	/**
	 * ͨ��ָ�����û���Ų�ѯ�û���Ϣ
	 * @param uid ���ҵ� uid
	 * @return ��ѯ�õ����û���Ϣ������ null
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User selectByUid(int uid) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select * from user_inf where uid=?";		
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, uid);
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
	
}
