package com.icss.StaffingSystem.entity;

import java.sql.Timestamp;

public class Document {

	private int id; // 文档编号
	private String title; // 文档标题
	private String filepath; // 文档的存储路径
	private String remark; // 文档的详细描述
	private Timestamp createdate; // 文档的创建时间
	private int userid; // 创建该文档的用户编号
	private String loginname; // 创建该文档的登录号
	
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
