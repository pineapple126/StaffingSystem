package com.icss.StaffingSystem.entity;

/**
 * 部门实体类
 * @author pineapple126
 *
 */
public class Dep {

	private int id;//部门编号
	private String name;//部门名称
	private String remark;//部门描述
	
	public Dep() {
		super();
	}
	public Dep(int id, String name, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
