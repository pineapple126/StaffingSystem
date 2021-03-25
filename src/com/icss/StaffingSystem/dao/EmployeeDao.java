package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.StaffingSystem.entity.Employee;
import com.icss.StaffingSystem.util.LevelPercentage;

/**
 * 员工相关的数据库操作
 * @author pineapple126
 *
 */
public class EmployeeDao {

	/**
	 * 查询得到满足过滤条件的分页列表
	 * @param jobid 过滤条件一：职位编号
	 * @param name 过滤条件二：员工姓名
	 * @param cardid 过滤条件三：身份证号码
	 * @param sex 过滤条件四：性别
	 * @param phone 过滤条件五：手机号码
	 * @param depid 过滤条件六：部门编号
	 * @param firstResult 起始条数
	 * @param pageSize 每页展现多少条
	 * @return 满足过滤条件的分页列表
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Employee> pageByConditions(int jobid, String name, String cardid, String sex, String phone, int depid, Integer firstResult, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select e.*, j.name jobname, d.name depname from employee_inf e, job_inf j, dep_inf d where e.jobid=j.id and e.depid=d.id";
	    if(jobid>0){
	      sql += " and jobid="+jobid;
	    }
	    if(name!=null && !"".equals(name)){
	      sql += " and e.name like '%"+name+"%'";
	    }
	    if(cardid!=null && !"".equals(cardid)){
	      sql += " and e.cardid like '%"+cardid+"%'";
	    }
	    if(sex!=null && !"".equals(sex)){
	      sql += " and e.sex='"+sex+"'";
	    }
	    if(phone!=null && !"".equals(phone)){
	      sql += " and e.phone like '%"+phone+"%'";
	    }
	    if(depid>0){
	      sql += " and e.depid="+depid;
	    }
	    sql += " limit ?,?";

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, firstResult);
		st.setInt(2, pageSize);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		List<Employee> employeeList = new ArrayList<Employee>();
		while (rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("ID"));
			employee.setDepid(rs.getInt("DEPID"));
			employee.setJobid(rs.getInt("JOBID"));
			employee.setName(rs.getString("NAME"));
			employee.setCardid(rs.getString("CARDID"));
			employee.setAddress(rs.getString("ADDRESS"));
			employee.setPostcode(rs.getString("POSTCODE"));
			employee.setTel(rs.getString("TEL"));
			employee.setPhone(rs.getString("PHONE"));
			employee.setQqnum(rs.getString("QQNUM"));
			employee.setEmail(rs.getString("EMAIL"));
	      	employee.setSex(rs.getString("SEX"));
	      	employee.setParty(rs.getString("PARTY"));
			employee.setBirthday(rs.getString("BIRTHDAY"));
			employee.setRace(rs.getString("RACE"));
			employee.setEducation(rs.getString("EDUCATION"));
			employee.setSpeciality(rs.getString("SPECIALITY"));
			employee.setHobby(rs.getString("HOBBY"));
			employee.setRemark(rs.getString("REMARK"));
	      	employee.setCreatedate(rs.getTimestamp("CREATEDATE"));
	      	employee.setLevelid(rs.getInt("LEVELID"));
	      	employee.setSalary(rs.getDouble("SALARY"));
	      	employee.setJobname(rs.getString("JOBNAME"));
	      	employee.setDepname(rs.getString("DEPNAME"));
	      	employeeList.add(employee);
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return employeeList;
		
	}

	/**
	 * 查询得到满足过滤条件的员工数量
	 * @param jobid 过滤条件一：职位编号
	 * @param name 过滤条件二：员工姓名
	 * @param cardid 过滤条件三：身份证号码
	 * @param sex 过滤条件四：性别
	 * @param phone 过滤条件五：手机号码
	 * @param depid 过滤条件六：部门编号
	 * @return 满足过滤条件的员工数量
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int countByConditions(int jobid, String name, String cardid, String sex, String phone, int depid) throws ClassNotFoundException, SQLException{
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select count(*) from employee_inf where 1=1";
	    if(jobid>0){
	      sql += " and jobid="+jobid;
	    }
	    if(name!=null && !"".equals(name)){
	      sql += " and name like '%"+name+"%'";
	    }
	    if(cardid!=null && !"".equals(cardid)){
	      sql += " and cardid like '%"+cardid+"%'";
	    }
	    if(sex!=null && !"".equals(sex)){
	      sql += " and sex='"+sex+"'";
	    }
	    if(phone!=null && !"".equals(phone)){
	      sql += " and phone like '%"+phone+"%'";
	    }
	    if(depid>0){
	      sql += " and depid="+depid;
	    }

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		int totalCount = 0;
		if (rs.next()) {
			totalCount = rs.getInt(1); // 获取到 rs 这一行指定的第一列对应的值
		}
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return totalCount;
	}
	
	/**
	 * 实现添加一条指定员工信息的数据库操作
	 * @param name 修改的员工的姓名
	 * @param cardid 修改的员工的身份证号码
	 * @param sex 修改的员工的性别
	 * @param jobid 修改的员工的所属的职位编号
	 * @param education 修改的员工的学历
	 * @param email 修改的员工的邮箱
	 * @param phone 修改的员工的手机号码
	 * @param tel 修改的员工的电话号码
	 * @param party 修改的员工的政治面貌
	 * @param qqnum 修改的员工的qq号码
	 * @param address 修改的员工的联系地址
	 * @param postcode 修改的员工的邮编
	 * @param birthday 修改的员工的出生日期
	 * @param race 修改的员工的民族
	 * @param speciality 修改的员工的所学专业
	 * @param hobby 修改的员工的爱好
	 * @param remark 修改的员工的备注
	 * @param depid 修改的员工的所属部门编号
	 * @param levelid 修改的员工的所属薪资范围编号
	 * @param salary 修改的员工的薪资
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void insertEmployee(String name,String cardid,String sex,int jobid,
		String education,String email,String phone,String tel,String party,
		String qqnum,String address,String postcode,String birthday,String race,
		String speciality,String hobby,String remark,int depid,int levelid,double salary) throws ClassNotFoundException, SQLException{
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "insert into employee_inf(depid, jobid, name, cardid, sex, education, email, phone, tel,"
				+ " party, qqnum, address, postcode, birthday, race, speciality, hobby, remark, createdate,"
				+ " levelid, salary) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, depid);
		st.setInt(2, jobid);
		st.setString(3, name);
		st.setString(4, cardid);
		st.setString(5, sex);
		st.setString(6, education);
		st.setString(7, email);
		st.setString(8, phone);
		st.setString(9, tel);
		st.setString(10, party);
		st.setString(11, qqnum);
		st.setString(12, address);
		st.setString(13, postcode);
		st.setString(14, birthday);
		st.setString(15, race);
		st.setString(16, speciality);
		st.setString(17, hobby);
		st.setString(18, remark);
		st.setTimestamp(19, new Timestamp(System.currentTimeMillis()));
		st.setInt(20, levelid);
		st.setDouble(21, salary);
		st.execute();
		
		
		//6、释放资源
		st.close();
		conn.close();
		
  	}
	
	/**
	 * 从数据库中查询得到指定员工编号的员工信息
	 * @param id 指定的员工编号
	 * @return 查询得到的员工信息
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Employee selectById(int id) throws ClassNotFoundException, SQLException {
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select e.*, j.name jobname, d.name depname from employee_inf e, job_inf j, dep_inf d where e.jobid=j.id and e.depid=d.id and e.id=?";

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		Employee employee = null;
		while (rs.next()) {
			employee = new Employee();
			employee.setId(rs.getInt("ID"));
			employee.setDepid(rs.getInt("DEPID"));
			employee.setJobid(rs.getInt("JOBID"));
			employee.setName(rs.getString("NAME"));
			employee.setCardid(rs.getString("CARDID"));
			employee.setAddress(rs.getString("ADDRESS"));
			employee.setPostcode(rs.getString("POSTCODE"));
			employee.setTel(rs.getString("TEL"));
			employee.setPhone(rs.getString("PHONE"));
			employee.setQqnum(rs.getString("QQNUM"));
			employee.setEmail(rs.getString("EMAIL"));
	      	employee.setSex(rs.getString("SEX"));
	      	employee.setParty(rs.getString("PARTY"));
			employee.setBirthday(rs.getString("BIRTHDAY"));
			employee.setRace(rs.getString("RACE"));
			employee.setEducation(rs.getString("EDUCATION"));
			employee.setSpeciality(rs.getString("SPECIALITY"));
			employee.setHobby(rs.getString("HOBBY"));
			employee.setRemark(rs.getString("REMARK"));
	      	employee.setCreatedate(rs.getTimestamp("CREATEDATE"));
	      	employee.setLevelid(rs.getInt("LEVELID"));
	      	employee.setSalary(rs.getDouble("SALARY"));
	      	employee.setJobname(rs.getString("JOBNAME"));
	      	employee.setDepname(rs.getString("DEPNAME"));
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return employee;
	}
	
	
	/**
	 * 实现修改指定员工编号的员工信息的数据库操作
	 * @param id 指定要修改的员工编号
	 * @param name 修改的员工的姓名
	 * @param cardid 修改的员工的身份证号码
	 * @param sex 修改的员工的性别
	 * @param jobid 修改的员工的所属的职位编号
	 * @param education 修改的员工的学历
	 * @param email 修改的员工的邮箱
	 * @param phone 修改的员工的手机号码
	 * @param tel 修改的员工的电话号码
	 * @param party 修改的员工的政治面貌
	 * @param qqnum 修改的员工的qq号码
	 * @param address 修改的员工的联系地址
	 * @param postcode 修改的员工的邮编
	 * @param birthday 修改的员工的出生日期
	 * @param race 修改的员工的民族
	 * @param speciality 修改的员工的所学专业
	 * @param hobby 修改的员工的爱好
	 * @param remark 修改的员工的备注
	 * @param depid 修改的员工的所属部门编号
	 * @param levelid 修改的员工的所属薪资范围编号
	 * @param salary 修改的员工的薪资
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void updateEmployee(int id,String name,String cardid,String sex,int jobid,
		String education,String email,String phone,String tel,String party,
		String qqnum,String address,String postcode,String birthday,String race,
		String speciality,String hobby,String remark,int depid,int levelid,double salary) throws ClassNotFoundException, SQLException{
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "update employee_inf set depid=?,jobid=?,name=?,cardid=?,address=?,"
		        + "postcode=?,tel=?,phone=?,qqnum=?,email=?,sex=?,party=?,birthday=?,"
		        + "race=?,education=?,speciality=?,hobby=?,remark=?,levelid=?,salary=?"
		        + " where id=?";

		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, depid);
	    st.setInt(2, jobid);
	    st.setString(3, name);
	    st.setString(4, cardid);
	    st.setString(5, address);
	    st.setString(6, postcode);
	    st.setString(7, tel);
	    st.setString(8, phone);
	    st.setString(9, qqnum);
	    st.setString(10, email);
	    st.setString(11, sex);
	    st.setString(12, party);
	    st.setString(13, birthday);
	    st.setString(14, race);
	    st.setString(15, education);
	    st.setString(16, speciality);
	    st.setString(17, hobby);
	    st.setString(18, remark);
	    st.setInt(19, levelid);
	    st.setDouble(20, salary);
	    st.setInt(21, id);
		st.execute();
		
		
		//6、释放资源
		st.close();
		conn.close();
		
	}
	
	/**
	 * 从数据库中统计查询出所有薪资等级所占百分比列表
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<LevelPercentage> selectLevelPercentage() throws ClassNotFoundException, SQLException {
		
		//1、加载JDBC驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、建立数据库连接
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3、编写想要执行的sql语句
		String sql = "select l.range,t.percentage from (select"
				+ " levelid,round(count(*)/(select count(*) from employee_inf)*100,2)"
				+ " percentage from employee_inf group by levelid) t,"
				+ " level_inf l where t.levelid=l.id;";
		
		//4、创建执行SQL语句的Statement对象
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5、如果是查询语句，则需要处理结果集 ResultSet
		List<LevelPercentage> list = new ArrayList<LevelPercentage>();
		while (rs.next()) {
			LevelPercentage levelPercentage = new LevelPercentage();
			levelPercentage.setName(rs.getString("RANGE"));
			levelPercentage.setY(rs.getDouble("PERCENTAGE"));
			list.add(levelPercentage);
		}		
		
		//6、释放资源
		rs.close();
		st.close();
		conn.close();
		
		return list;
				
	}
}
