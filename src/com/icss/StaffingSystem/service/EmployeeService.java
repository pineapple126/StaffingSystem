package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.EmployeeDao;
import com.icss.StaffingSystem.entity.Employee;
import com.icss.StaffingSystem.util.PageResult;

/**
 * ��������Ա����ص�ҵ���߼�
 * @author pineapple126
 *
 */
public class EmployeeService {

	/**
	 * ʵ�ֻ�ȡ�õ��������������Ա����ҳ�����ҵ���߼�
	 * @param jobid ��������һ��ְλ���
	 * @param name ������������Ա������
	 * @param cardid ���������������֤����
	 * @param sex ���������ģ��Ա�
	 * @param phone ���������壺�ֻ�����
	 * @param depid ���������������ű��
	 * @param currentPage ��ҳ��֪����һ����ǰҳ��
	 * @param pageSize ��ҳ��֪��������ÿҳչ�ֶ�����
	 * @return ������������ĵ�Ա����ҳ�������ҳ�б���ǰҳ�롢����������������ҳ��
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
