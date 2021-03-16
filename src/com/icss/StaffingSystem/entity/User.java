package com.icss.StaffingSystem.entity;

import java.sql.Timestamp;

/**
 * �û�ʵ����
 * @author pineapple126
 *
 */
public class User {
	
	private int uid; // �û�����
	private String loginname; // ��¼��
	private String password; // ����
	private String status; // �û�״̬, 1 �������Ա��2 ������ͨ�û�
	private Timestamp createdate; // ����ʱ��
	private String username; // �û���
	private String isface; // �Ƿ��ѽ�������ע�ᣬ1 ������ע�ᣬ2 ����δע��
	
	public User() {
		super();
	}
	public User(int uid, String loginname, String password, String status, Timestamp createdate, String username,
			String isface) {
		super();
		this.uid = uid;
		this.loginname = loginname;
		this.password = password;
		this.status = status;
		this.createdate = createdate;
		this.username = username;
		this.isface = isface;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIsface() {
		return isface;
	}
	public void setIsface(String isface) {
		this.isface = isface;
	}
	
}
