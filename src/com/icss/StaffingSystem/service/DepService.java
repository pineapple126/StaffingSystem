package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.DepDao;
import com.icss.StaffingSystem.entity.Dep;

/**
 * �йز��ŵ�ҵ���߼�
 * @author pineapple126
 *
 */
public class DepService {

	/**
	 * ʵ�ֻ�ȡ�õ����в����б��ҵ���߼�
	 * @return ��ȡ�õ������в����б�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Dep> findAll() throws ClassNotFoundException, SQLException {
		
		DepDao depDao = new DepDao();
		
		List<Dep> depList = depDao.selectAllDepList();
		
		return depList;
		
	}
	
}
