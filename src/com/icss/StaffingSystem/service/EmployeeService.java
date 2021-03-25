package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.EmployeeDao;
import com.icss.StaffingSystem.entity.Employee;
import com.icss.StaffingSystem.util.LevelPercentage;
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
	
	/**
	 * ʵ�����һ��ָ��Ա����Ϣ��ҵ���߼�
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
	public void addEmployee(String name,String cardid,String sex,int jobid,
		String education,String email,String phone,String tel,String party,
		String qqnum,String address,String postcode,String birthday,String race,
		String speciality,String hobby,String remark,int depid,int levelid,double salary) throws ClassNotFoundException, SQLException {

		EmployeeDao employeeDao = new EmployeeDao();
		
		employeeDao.insertEmployee(name, cardid, sex, jobid, education, email, phone, tel, party, qqnum, address, postcode, birthday, race, speciality, hobby, remark, depid, levelid, salary);
		
  	}
	
	/**
	 * ʵ�ֻ�ȡ�õ�ָ��Ա����ŵ�Ա����Ϣ��ҵ���߼�
	 * @param id ָ����Ա�����
	 * @return ���ҵ���Ա����Ϣ
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Employee findById(int id) throws ClassNotFoundException, SQLException {
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		Employee employee = employeeDao.selectById(id);
		
		return employee;
		
	}
	
	/**
	 * ʵ���޸�ָ��Ա����ŵ�Ա����Ϣ��ҵ���߼�
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
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		employeeDao.updateEmployee(id, name, cardid, sex, jobid, education, email, phone, tel, party, qqnum, address, postcode, birthday, race, speciality, hobby, remark, depid, levelid, salary);
		
	}
	
	/**
	 * ʵ�ֻ�ȡ�õ�����н�ʵȼ���ռ�ٷֱȵ�ҵ���߼�
	 * @return ����н�ʵȼ���ռ�ٷֱȵ��б�
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<LevelPercentage> findLevelPercentage() throws ClassNotFoundException, SQLException {
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		List<LevelPercentage> list = employeeDao.selectLevelPercentage();
		
		return list;
		
	}
	
	/**
	 * ʵ��ɾ������ָ��Ա����ŵ�Ա����Ϣ��ҵ���߼�
	 * @param ids ָ����Ա�����
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteEmployees(String ids) throws ClassNotFoundException, SQLException {
		
		// 3.�����ݿ���ɾ������ָ����ŵ��û���Ϣ
		EmployeeDao employeeDao = new EmployeeDao();		
		employeeDao.deleteEmployees(ids);
		
	}
	
}
