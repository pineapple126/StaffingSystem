package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.DocumentDao;
import com.icss.StaffingSystem.entity.Document;
import com.icss.StaffingSystem.util.PageResult;

/**
 * �ĵ�������ص�ҵ���߼�
 * @author pineapple126
 *
 */
public class DocumentService {

	/**
	 * ʵ�ֻ�ȡ�õ���������������ĵ���ҳ�����ҵ���߼�
	 * @param title �����������ĵ��ı���
	 * @param currentPage ��ҳ����֪����һ��չ�ֵĵ�ǰҳ��
	 * @param pageSize ��ҳ����֪��������ÿҳչ�ֶ�����
	 * @return �õ�����������������ĵ���ҳ���
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public PageResult<Document> pageByConditions(String title, Integer currentPage, Integer pageSize) throws ClassNotFoundException, SQLException {
		
		PageResult<Document> pageResult = new PageResult<Document>();
		
		DocumentDao documentDao = new DocumentDao();
		Integer firstResult = (currentPage - 1) * pageSize;
		List<Document> list = documentDao.pageByConditions(title, firstResult, pageSize);
		int totalCount = documentDao.countByConditions(title);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		
		pageResult.setList(list);
		pageResult.setCurrentPage(currentPage);
		pageResult.setTotalCount(totalCount);
		pageResult.setTotalPage(totalPage);
	
		return pageResult;
	}
	
}
