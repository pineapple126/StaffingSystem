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
 * Ա����ص����ݿ����
 * @author pineapple126
 *
 */
public class EmployeeDao {

	/**
	 * ��ѯ�õ�������������ķ�ҳ�б�
	 * @param jobid ��������һ��ְλ���
	 * @param name ������������Ա������
	 * @param cardid ���������������֤����
	 * @param sex ���������ģ��Ա�
	 * @param phone ���������壺�ֻ�����
	 * @param depid ���������������ű��
	 * @param firstResult ��ʼ����
	 * @param pageSize ÿҳչ�ֶ�����
	 * @return ������������ķ�ҳ�б�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Employee> pageByConditions(int jobid, String name, String cardid, String sex, String phone, int depid, Integer firstResult, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
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

		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, firstResult);
		st.setInt(2, pageSize);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
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
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return employeeList;
		
	}

	/**
	 * ��ѯ�õ��������������Ա������
	 * @param jobid ��������һ��ְλ���
	 * @param name ������������Ա������
	 * @param cardid ���������������֤����
	 * @param sex ���������ģ��Ա�
	 * @param phone ���������壺�ֻ�����
	 * @param depid ���������������ű��
	 * @return �������������Ա������
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int countByConditions(int jobid, String name, String cardid, String sex, String phone, int depid) throws ClassNotFoundException, SQLException{
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
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

		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		int totalCount = 0;
		if (rs.next()) {
			totalCount = rs.getInt(1); // ��ȡ�� rs ��һ��ָ���ĵ�һ�ж�Ӧ��ֵ
		}
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return totalCount;
	}
	
	/**
	 * ʵ�����һ��ָ��Ա����Ϣ�����ݿ����
	 * @param name �޸ĵ�Ա��������
	 * @param cardid �޸ĵ�Ա�������֤����
	 * @param sex �޸ĵ�Ա�����Ա�
	 * @param jobid �޸ĵ�Ա����������ְλ���
	 * @param education �޸ĵ�Ա����ѧ��
	 * @param email �޸ĵ�Ա��������
	 * @param phone �޸ĵ�Ա�����ֻ�����
	 * @param tel �޸ĵ�Ա���ĵ绰����
	 * @param party �޸ĵ�Ա����������ò
	 * @param qqnum �޸ĵ�Ա����qq����
	 * @param address �޸ĵ�Ա������ϵ��ַ
	 * @param postcode �޸ĵ�Ա�����ʱ�
	 * @param birthday �޸ĵ�Ա���ĳ�������
	 * @param race �޸ĵ�Ա��������
	 * @param speciality �޸ĵ�Ա������ѧרҵ
	 * @param hobby �޸ĵ�Ա���İ���
	 * @param remark �޸ĵ�Ա���ı�ע
	 * @param depid �޸ĵ�Ա�����������ű��
	 * @param levelid �޸ĵ�Ա��������н�ʷ�Χ���
	 * @param salary �޸ĵ�Ա����н��
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void insertEmployee(String name,String cardid,String sex,int jobid,
		String education,String email,String phone,String tel,String party,
		String qqnum,String address,String postcode,String birthday,String race,
		String speciality,String hobby,String remark,int depid,int levelid,double salary) throws ClassNotFoundException, SQLException{
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "insert into employee_inf(depid, jobid, name, cardid, sex, education, email, phone, tel,"
				+ " party, qqnum, address, postcode, birthday, race, speciality, hobby, remark, createdate,"
				+ " levelid, salary) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		//4������ִ��SQL����Statement����
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
		
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
  	}
	
	/**
	 * �����ݿ��в�ѯ�õ�ָ��Ա����ŵ�Ա����Ϣ
	 * @param id ָ����Ա�����
	 * @return ��ѯ�õ���Ա����Ϣ
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Employee selectById(int id) throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select e.*, j.name jobname, d.name depname from employee_inf e, job_inf j, dep_inf d where e.jobid=j.id and e.depid=d.id and e.id=?";

		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
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
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return employee;
	}
	
	
	/**
	 * ʵ���޸�ָ��Ա����ŵ�Ա����Ϣ�����ݿ����
	 * @param id ָ��Ҫ�޸ĵ�Ա�����
	 * @param name �޸ĵ�Ա��������
	 * @param cardid �޸ĵ�Ա�������֤����
	 * @param sex �޸ĵ�Ա�����Ա�
	 * @param jobid �޸ĵ�Ա����������ְλ���
	 * @param education �޸ĵ�Ա����ѧ��
	 * @param email �޸ĵ�Ա��������
	 * @param phone �޸ĵ�Ա�����ֻ�����
	 * @param tel �޸ĵ�Ա���ĵ绰����
	 * @param party �޸ĵ�Ա����������ò
	 * @param qqnum �޸ĵ�Ա����qq����
	 * @param address �޸ĵ�Ա������ϵ��ַ
	 * @param postcode �޸ĵ�Ա�����ʱ�
	 * @param birthday �޸ĵ�Ա���ĳ�������
	 * @param race �޸ĵ�Ա��������
	 * @param speciality �޸ĵ�Ա������ѧרҵ
	 * @param hobby �޸ĵ�Ա���İ���
	 * @param remark �޸ĵ�Ա���ı�ע
	 * @param depid �޸ĵ�Ա�����������ű��
	 * @param levelid �޸ĵ�Ա��������н�ʷ�Χ���
	 * @param salary �޸ĵ�Ա����н��
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void updateEmployee(int id,String name,String cardid,String sex,int jobid,
		String education,String email,String phone,String tel,String party,
		String qqnum,String address,String postcode,String birthday,String race,
		String speciality,String hobby,String remark,int depid,int levelid,double salary) throws ClassNotFoundException, SQLException{
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "update employee_inf set depid=?,jobid=?,name=?,cardid=?,address=?,"
		        + "postcode=?,tel=?,phone=?,qqnum=?,email=?,sex=?,party=?,birthday=?,"
		        + "race=?,education=?,speciality=?,hobby=?,remark=?,levelid=?,salary=?"
		        + " where id=?";

		//4������ִ��SQL����Statement����
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
		
		
		//6���ͷ���Դ
		st.close();
		conn.close();
		
	}
	
	/**
	 * �����ݿ���ͳ�Ʋ�ѯ������н�ʵȼ���ռ�ٷֱ��б�
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public List<LevelPercentage> selectLevelPercentage() throws ClassNotFoundException, SQLException {
		
		//1������JDBC����
		Class.forName("com.mysql.jdbc.Driver");
		
		//2���������ݿ�����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_staffingsystem","root","root");
		
		//3����д��Ҫִ�е�sql���
		String sql = "select l.range,t.percentage from (select"
				+ " levelid,round(count(*)/(select count(*) from employee_inf)*100,2)"
				+ " percentage from employee_inf group by levelid) t,"
				+ " level_inf l where t.levelid=l.id;";
		
		//4������ִ��SQL����Statement����
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		//5������ǲ�ѯ��䣬����Ҫ�������� ResultSet
		List<LevelPercentage> list = new ArrayList<LevelPercentage>();
		while (rs.next()) {
			LevelPercentage levelPercentage = new LevelPercentage();
			levelPercentage.setName(rs.getString("RANGE"));
			levelPercentage.setY(rs.getDouble("PERCENTAGE"));
			list.add(levelPercentage);
		}		
		
		//6���ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		return list;
				
	}
}
