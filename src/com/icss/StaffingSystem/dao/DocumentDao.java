package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.StaffingSystem.entity.Document;

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
	
	/**
	 * ��ѯ�õ�������������ķ�ҳ�б�
	 * @param title �����������ĵ�����
	 * @param firstResult ��ʼ����
	 * @param pageSize ÿҳչ�ֶ�����
	 * @return ������������ķ�ҳ�б�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Document> pageByConditions(String title, Integer firstResult, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select d.*, u.loginname from document_inf d, user_inf u where d.userid=u.uid";	
		
		if (title != null && !"".equals(title)) {
			sql += " and d.title like '%" + title + "%'";
		}
		sql += " limit ?,?";

		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, firstResult);
		st.setInt(2, pageSize);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		List<Document> documentList = new ArrayList<Document>();
		while (rs.next()) {
			Document document = new Document();
			document.setId(rs.getInt("ID"));
			document.setTitle(rs.getString("TITLE"));
			document.setFilepath(rs.getString("FILEPATH"));
			document.setRemark(rs.getString("REMARK"));
			document.setCreatedate(rs.getTimestamp("CREATEDATE"));
			document.setUserid(rs.getInt("USERID"));
			document.setLoginname(rs.getString("LOGINNAME"));
			documentList.add(document);
		}		
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return documentList;
		
	}

	/**
	 * ��ѯ�õ���������������ĵ�����
	 * @param title �����������ĵ�����
	 * @return ��������������ĵ�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int countByConditions(String title) throws ClassNotFoundException, SQLException{
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select count(*) from document_inf where 1=1";	
		
		if (title != null && !"".equals(title)) {
			sql += " and title like '%" + title + "%'";
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
	 * �����ݿ������һ��ָ�����ĵ���¼
	 * @param title Ҫ��ӵ��ĵ�����
	 * @param remark Ҫ��ӵ��ĵ�����
	 * @param filepath �ĵ��洢��·��
	 * @param userid �ϴ��ĵ����û����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void insertDocument(String title, String remark, String filepath, int userid) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "insert into document_inf(title, filepath, remark, createdate, userid) values(?,?,?,?,?)";	
		
	
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, filepath);
		st.setString(3, remark);
		st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		st.setInt(5, userid);
		st.execute();
		
		
		//6���ͷ���Դ
		st.close();
		conn.close();
	}
	
	/**
	 * ͨ��ָ�����ĵ���Ų�ѯ�ĵ���Ϣ
	 * @param id ���ҵ��ĵ����
	 * @return ��ѯ�õ����ĵ���Ϣ������ null
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Document selectById(int id) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select * from document_inf where id=?";		
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		Document document = null;
		if (rs.next()) {
			document = new Document();
			document.setId(rs.getInt("ID"));
			document.setTitle(rs.getString("TITLE"));
			document.setFilepath(rs.getString("FILEPATH"));
			document.setRemark(rs.getString("REMARK"));
			document.setCreatedate(rs.getTimestamp("CREATEDATE"));
			document.setUserid(rs.getInt("USERID"));
		}		
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return document;		
		
	}
	
}
