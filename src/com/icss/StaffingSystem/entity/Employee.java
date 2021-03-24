package com.icss.StaffingSystem.entity;

import java.sql.Timestamp;

/**
 * 员工实体类
 * @author pineapple126
 *
 */
public class Employee {

	private int id;//员工编号
	private int depid;//所属部门编号
	private int jobid;//所属职位编号
	private String name;//员工姓名
	private String cardid;//身份证号
	private String address;//地址
	private String postcode;//邮编
	private String tel;//电话
	private String phone;//手机号码
	private String qqnum;//QQ号码
	private String email;//电子邮箱
	private String sex;//性别：1代表男，2代表女
	private String party;//政治面貌
	private String birthday;//出生日期
	private String race;//民族
	private String education;//学历
	private String speciality;//专业
	private String hobby;//爱好
	private String remark;//备注
	private Timestamp createdate;//创建时间
	private int levelid;//所属薪资等级编号
	private double salary;//薪资
	
	private String depname;//部门名称
	private String jobname;//职位名称
	
	public Employee() {
		super();
	}
	public Employee(int id, int depid, int jobid, String name, String cardid, String address, String postcode,
			String tel, String phone, String qqnum, String email, String sex, String party, String birthday,
			String race, String education, String speciality, String hobby, String remark, Timestamp createdate,
			int levelid, double salary, String depname, String jobname) {
		super();
		this.id = id;
		this.depid = depid;
		this.jobid = jobid;
		this.name = name;
		this.cardid = cardid;
		this.address = address;
		this.postcode = postcode;
		this.tel = tel;
		this.phone = phone;
		this.qqnum = qqnum;
		this.email = email;
		this.sex = sex;
		this.party = party;
		this.birthday = birthday;
		this.race = race;
		this.education = education;
		this.speciality = speciality;
		this.hobby = hobby;
		this.remark = remark;
		this.createdate = createdate;
		this.levelid = levelid;
		this.salary = salary;
		this.depname = depname;
		this.jobname = jobname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQqnum() {
		return qqnum;
	}
	public void setQqnum(String qqnum) {
		this.qqnum = qqnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
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
	public int getLevelid() {
		return levelid;
	}
	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
}
