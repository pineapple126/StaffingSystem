package com.icss.StaffingSystem.entity;

import java.sql.Timestamp;

/**
 * ����ʵ����
 * @author pineapple126
 *
 */
public class Notice {

	private int id; // ��������
	private String title; // ��������
	private String content; // ��������
	private Timestamp createdate; // ����ʱ��
	private int userid; // ������
	
	public Notice() {
		super();
	}
	public Notice(int id, String title, String content, Timestamp createdate, int userid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdate = createdate;
		this.userid = userid;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

}
