package com.icss.StaffingSystem.entity;

import java.sql.Timestamp;

public class Document {

	private int id; // �ĵ����
	private String title; // �ĵ�����
	private String filepath; // �ĵ��Ĵ洢·��
	private String remark; // �ĵ�����ϸ����
	private Timestamp createdate; // �ĵ��Ĵ���ʱ��
	private int userid; // �������ĵ����û����
	private String loginname; // �������ĵ��ĵ�¼��
	
	public Document() {
		super();
	}
	public Document(int id, String title, String filepath, String remark, Timestamp createdate, int userid,
			String loginname) {
		super();
		this.id = id;
		this.title = title;
		this.filepath = filepath;
		this.remark = remark;
		this.createdate = createdate;
		this.userid = userid;
		this.loginname = loginname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
}
