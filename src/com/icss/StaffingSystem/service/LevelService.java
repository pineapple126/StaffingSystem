package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.LevelDao;
import com.icss.StaffingSystem.entity.Level;

/**
 * 有关薪资等级的业务逻辑
 * @author pineapple126
 *
 */
public class LevelService {

	/**
	 * 实现获取得到所有薪资等级列表的业务逻辑
	 * @return 获取得到的所有薪资等级列表
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Level> findAll() throws ClassNotFoundException, SQLException {
		
		LevelDao levelDao = new LevelDao();
		
		List<Level> levelList = levelDao.selectAllLevelList();
		
		return levelList;
		
	}
	
}
