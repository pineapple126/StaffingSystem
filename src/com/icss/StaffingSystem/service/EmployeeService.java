package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.EmployeeDao;
import com.icss.StaffingSystem.entity.Employee;
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
	
}
