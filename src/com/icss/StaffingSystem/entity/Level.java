package com.icss.StaffingSystem.entity;

/**
 * н�ʵȼ�ʵ����
 * @author pineapple126
 *
 */
public class Level {

	private int id;//�ȼ����
	private String range;//�ȼ���Χ����
	private double minsalary;//���н��
	private double maxsalary;//���н��
	
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
