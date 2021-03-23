package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.StaffingSystem.entity.Notice;

/**
 * ���ڹ������ɾ�Ĳ�
 * @author pineapple126
 *
 */
public class NoticeDao {

	/**
	 * �����ݿ���ɾ����ָ������û�������Ĺ�����Ϣ
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
		String sql = "delete from notice_inf where userid in(" + ids + ")";	
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
	}
	
	/**
	 * ��ѯ�õ�������������ķ�ҳ�б�
	 * @param title ��������һ���������
	 * @param content ��������������������
	 * @param firstResult ��ʼ����
	 * @param pageSize ÿҳչ�ֶ�����
	 * @return ������������ķ�ҳ�б�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Notice> pageByConditions(String title, String content, Integer firstResult, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select n.*, u.loginname from notice_inf n, user_inf u where n.userid=u.uid";	
		
		if (title != null && !"".equals(title)) {
			sql += " and n.title like '%" + title + "%'";
		}
		if (content != null && !"".equals(content)) {
			sql += " and n.content like '%" + content + "%'";
		}
		sql += " limit ?,?";

		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, firstResult);
		st.setInt(2, pageSize);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		List<Notice> noticeList = new ArrayList<Notice>();
		while (rs.next()) {
			Notice notice = new Notice();
			notice.setId(rs.getInt("ID"));
			notice.setTitle(rs.getString("TITLE"));
			notice.setContent(rs.getString("CONTENT"));
			notice.setCreatedate(rs.getTimestamp("CREATEDATE"));
			notice.setUserid(rs.getInt("USERID"));
			notice.setLoginname(rs.getString("LOGINNAME"));
			noticeList.add(notice);
		}		
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return noticeList;
		
	}

	/**
	 * ��ѯ�õ�������������Ĺ�������
	 * @param title ��������һ���������
	 * @param content ��������������������
	 * @return ������������Ĺ�������
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int countByConditions(String title, String content) throws ClassNotFoundException, SQLException{
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select count(*) from notice_inf where 1=1";	
		
		if (title != null && !"".equals(title)) {
			sql += " and title like '%" + title + "%'";
		}
		if (content != null && !"".equals(content)) {
			sql += " and content like '%" + content + "%'";
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
	 * �����ݿ������һ��ָ���Ĺ�����Ϣ
	 * @param title ��ӵĹ������
	 * @param content ��ӵĹ�������
	 * @param userid ��ӵĹ�����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void insertNotice(String title, String content, int userid) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "insert into notice_inf(title, content, createdate, userid) values(?,?,?,?)";	
		
	
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
		st.setInt(4, userid);
		st.execute();
		
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
	}
	
}
