package com.icss.StaffingSystem.entity;

import java.sql.Timestamp;

/**
 * 用户实体类
 * @author pineapple126
 *
 */
public class User {
	
	private int uid; // 用户主键
	private String loginname; // 登录名
	private String password; // 密码
	private String status; // 用户状态, 1 代表管理员，2 代表普通用户
	private Timestamp createdate; // 创建时间
	private String username; // 用户名
	private String isface; // 是否已进行人脸注册，1 代表已注册，2 代表未注册
	
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
