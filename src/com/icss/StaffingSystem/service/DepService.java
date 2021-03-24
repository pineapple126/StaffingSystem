package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.DepDao;
import com.icss.StaffingSystem.entity.Dep;

/**
 * 有关部门的业务逻辑
 * @author pineapple126
 *
 */
public class DepService {

	/**
	 * 实现获取得到所有部门列表的业务逻辑
	 * @return 获取得到的所有部门列表
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Dep> findAll() throws ClassNotFoundException, SQLException {
		
		DepDao depDao = new DepDao();
		
		List<Dep> depList = depDao.selectAllDepList();
		
		return depList;
		
	}
	
}
