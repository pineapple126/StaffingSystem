package com.icss.StaffingSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.StaffingSystem.entity.Employee;

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
	
}
