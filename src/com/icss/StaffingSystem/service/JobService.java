package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.JobDao;
import com.icss.StaffingSystem.entity.Job;

/**
 * 有关职位的业务逻辑
 * @author pineapple126
 *
 */
public class JobService {

	/**
	 * 实现获取得到所有职位列表的业务逻辑
	 * @return 获取得到的所有职位列表
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Job> findAll() throws ClassNotFoundException, SQLException {
		
		JobDao jobDao = new JobDao();
		
		List<Job> jobList = jobDao.selectAllJobList();
		
		return jobList;
		
	}
	
}
