package com.icss.StaffingSystem.util;

/**
 * н�ʵȼ��ٷֱ�ʵ����
 * @author pineapple126
 *
 */
public class LevelPercentage {

	private String name;// н�ʵȼ���Χ������
	private double y;//	��ռ�ٷֱ�
	
	public LevelPercentage() {
		super();
	}
	public LevelPercentage(String name, double y) {
		super();
		this.name = name;
		this.y = y;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

}
