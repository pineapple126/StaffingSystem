package com.icss.StaffingSystem.entity;

/**
 * ����ʵ����
 * @author pineapple126
 *
 */
public class Dep {

	private int id;//���ű��
	private String name;//��������
	private String remark;//��������
	
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