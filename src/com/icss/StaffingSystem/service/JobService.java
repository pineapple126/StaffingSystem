package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.JobDao;
import com.icss.StaffingSystem.entity.Job;

/**
 * �й�ְλ��ҵ���߼�
 * @author pineapple126
 *
 */
public class JobService {

	/**
	 * ʵ�ֻ�ȡ�õ�����ְλ�б��ҵ���߼�
	 * @return ��ȡ�õ�������ְλ�б�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Job> findAll() throws ClassNotFoundException, SQLException {
		
		JobDao jobDao = new JobDao();
		
		List<Job> jobList = jobDao.selectAllJobList();
		
		return jobList;
		
	}
	
}
