package com.icss.StaffingSystem.entity;

/**
 * 薪资等级实体类
 * @author pineapple126
 *
 */
public class Level {

	private int id;//等级编号
	private String range;//等级范围描述
	private double minsalary;//最低薪资
	private double maxsalary;//最高薪资
	
	public Level() {
		super();
	}
	public Level(int id, String range, double minsalary, double maxsalary) {
		super();
		this.id = id;
		this.range = range;
		this.minsalary = minsalary;
		this.maxsalary = maxsalary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public double getMinsalary() {
		return minsalary;
	}
	public void setMinsalary(double minsalary) {
		this.minsalary = minsalary;
	}
	public double getMaxsalary() {
		return maxsalary;
	}
	public void setMaxsalary(double maxsalary) {
		this.maxsalary = maxsalary;
	}
	
}
