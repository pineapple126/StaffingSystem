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
	
	/**
	 * 添加指定公告信息的业务逻辑
	 * @param title 添加的公告标题
	 * @param content 添加的公告内容
	 * @param userid 添加的公告人
	 * @return 添加成功与否
	 * @throws Exception
	 */
	public void addNotice(String title, String content, int userid) throws Exception {
		
		NoticeDao noticeDao = new NoticeDao();
		
		noticeDao.insertNotice(title, content, userid);

	}
	
	/**
	 * 查询得到指定公告编号的公告信息的业务逻辑
	 * @param id 指定的公告编号
	 * @return 指定公告编号的公告信息
	 * @throws Exception
	 */
	public Notice findById(int id) throws Exception {
		
		NoticeDao noticeDao = new NoticeDao();
		
		Notice notice = noticeDao.selectById(id);
		
		return notice;
		
	}
	
}
