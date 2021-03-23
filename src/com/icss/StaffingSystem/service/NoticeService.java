package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.NoticeDao;
import com.icss.StaffingSystem.entity.Notice;
import com.icss.StaffingSystem.util.PageResult;

/**
 * 公告相关的业务逻辑
 * @author pineapple126
 *
 */
public class NoticeService {

	/**
	 * 实现获取得到满足过滤条件的分页结果（分页的列表，当前的页码、共多少条、共多少页）的业务逻辑
	 * @param title 过滤条件一：公告标题
	 * @param content 过滤条件二：公告内容
	 * @param currentPage 分页的已知条件一：展现的当前页码
	 * @param pageSize 分页的已知条件二：每页展现多少条
	 * @return 获取得到满足过滤条件的分页结果（分页的列表，当前的页码、共多少条、共多少页）
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public PageResult<Notice> pageByConditions(String title, String content, Integer currentPage, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		PageResult<Notice> pageResult = new PageResult<Notice>();
		
		NoticeDao noticeDao = new NoticeDao();
		Integer firstResult = (currentPage - 1) * pageSize;
		List<Notice> list = noticeDao.pageByConditions(title, content, firstResult, pageSize);
		int totalCount = noticeDao.countByConditions(title, content);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		pageResult.setList(list);
		pageResult.setCurrentPage(currentPage);
		pageResult.setTotalCount(totalCount);
		pageResult.setTotalPage(totalPage);
	
		return pageResult;
	}
	
}
