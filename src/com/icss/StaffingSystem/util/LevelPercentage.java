package com.icss.StaffingSystem.util;

/**
 * 薪资等级百分比实体类
 * @author pineapple126
 *
 */
public class LevelPercentage {

	private String name;// 薪资等级范围的描述
	private double y;//	所占百分比
	
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
