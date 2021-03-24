package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.LevelDao;
import com.icss.StaffingSystem.entity.Level;

/**
 * �й�н�ʵȼ���ҵ���߼�
 * @author pineapple126
 *
 */
public class LevelService {

	/**
	 * ʵ�ֻ�ȡ�õ�����н�ʵȼ��б��ҵ���߼�
	 * @return ��ȡ�õ�������н�ʵȼ��б�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Level> findAll() throws ClassNotFoundException, SQLException {
		
		LevelDao levelDao = new LevelDao();
		
		List<Level> levelList = levelDao.selectAllLevelList();
		
		return levelList;
		
	}
	
}
