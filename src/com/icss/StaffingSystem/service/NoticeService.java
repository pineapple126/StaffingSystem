package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.NoticeDao;
import com.icss.StaffingSystem.entity.Notice;
import com.icss.StaffingSystem.util.PageResult;

/**
 * ������ص�ҵ���߼�
 * @author pineapple126
 *
 */
public class NoticeService {

	/**
	 * ʵ�ֻ�ȡ�õ�������������ķ�ҳ�������ҳ���б���ǰ��ҳ�롢����������������ҳ����ҵ���߼�
	 * @param title ��������һ���������
	 * @param content ��������������������
	 * @param currentPage ��ҳ����֪����һ��չ�ֵĵ�ǰҳ��
	 * @param pageSize ��ҳ����֪��������ÿҳչ�ֶ�����
	 * @return ��ȡ�õ�������������ķ�ҳ�������ҳ���б���ǰ��ҳ�롢����������������ҳ��
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
