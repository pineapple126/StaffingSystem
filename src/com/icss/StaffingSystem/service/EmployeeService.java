package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.EmployeeDao;
import com.icss.StaffingSystem.entity.Employee;
import com.icss.StaffingSystem.util.LevelPercentage;
import com.icss.StaffingSystem.util.PageResult;

/**
 * 用来处理员工相关的业务逻辑
 * @author pineapple126
 *
 */
public class EmployeeService {

	/**
	 * 实现获取得到满足过滤条件的员工分页结果的业务逻辑
	 * @param jobid 过滤条件一：职位编号
	 * @param name 过滤条件二：员工姓名
	 * @param cardid 过滤条件三：身份证号码
	 * @param sex 过滤条件四：性别
	 * @param phone 过滤条件五：手机号码
	 * @param depid 过滤条件六：部门编号
	 * @param currentPage 分页已知条件一：当前页码
	 * @param pageSize 分页已知条件二：每页展现多少条
	 * @return 满足过滤条件的的员工分页结果（分页列表、当前页码、共多少条、共多少页）
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public PageResult<Employee> pageByConditions(int jobid, String name, String cardid, String sex, String phone, int depid, Integer currentPage, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		PageResult<Employee> pageResult = new PageResult<Employee>();
		
		EmployeeDao employeeDao = new EmployeeDao();
		Integer firstResult = (currentPage - 1) * pageSize;
		List<Employee> list = employeeDao.pageByConditions(jobid, name, cardid, sex, phone, depid, firstResult, pageSize);
		int totalCount = employeeDao.countByConditions(jobid, name, cardid, sex, phone, depid);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		pageResult.setList(list);
		pageResult.setCurrentPage(currentPage);
		pageResult.setTotalCount(totalCount);
		pageResult.setTotalPage(totalPage);
	
		return pageResult;
	}
	
	/**
	 * 实现添加一条指定员工信息的业务逻辑
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
	public void addEmployee(String name,String cardid,String sex,int jobid,
		String education,String email,String phone,String tel,String party,
		String qqnum,String address,String postcode,String birthday,String race,
		String speciality,String hobby,String remark,int depid,int levelid,double salary) throws ClassNotFoundException, SQLException {

		EmployeeDao employeeDao = new EmployeeDao();
		
		employeeDao.insertEmployee(name, cardid, sex, jobid, education, email, phone, tel, party, qqnum, address, postcode, birthday, race, speciality, hobby, remark, depid, levelid, salary);
		
  	}
	
	/**
	 * 实现获取得到指定员工编号的员工信息的业务逻辑
	 * @param id 指定的员工编号
	 * @return 查找到的员工信息
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Employee findById(int id) throws ClassNotFoundException, SQLException {
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		Employee employee = employeeDao.selectById(id);
		
		return employee;
		
	}
	
	/**
	 * 实现修改指定员工编号的员工信息的业务逻辑
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
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		employeeDao.updateEmployee(id, name, cardid, sex, jobid, education, email, phone, tel, party, qqnum, address, postcode, birthday, race, speciality, hobby, remark, depid, levelid, salary);
		
	}
	
	/**
	 * 实现获取得到所有薪资等级所占百分比的业务逻辑
	 * @return 所有薪资等级所占百分比的列表
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<LevelPercentage> findLevelPercentage() throws ClassNotFoundException, SQLException {
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		List<LevelPercentage> list = employeeDao.selectLevelPercentage();
		
		return list;
		
	}
	
	/**
	 * 实现删除多条指定员工编号的员工信息的业务逻辑
	 * @param ids 指定的员工编号
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteEmployees(String ids) throws ClassNotFoundException, SQLException {
		
		// 3.从数据库里删除多条指定编号的用户信息
		EmployeeDao employeeDao = new EmployeeDao();		
		employeeDao.deleteEmployees(ids);
		
	}
	
}
