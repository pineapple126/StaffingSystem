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
	
	/**
	 * ʵ�����һ��ָ���ĵ���ҵ���߼�
	 * @param title Ҫ��ӵ��ĵ�����
	 * @param remark Ҫ��ӵ��ĵ�����
	 * @param filepath �ĵ��洢��·��
	 * @param userid �ϴ����û����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addDocument(String title, String remark, String filepath, int userid) throws ClassNotFoundException, SQLException {
		
		DocumentDao documentDao = new DocumentDao();
		
		documentDao.insertDocument(title, remark, filepath, userid);
		
	}
	
	/**
	 * ʵ�ִ����ݿ���ͨ��ָ�����ĵ���Ų����ĵ���Ϣ��ҵ���߼�
	 * @param id ָ�����ĵ���ű��
	 * @return ���ҵ����ĵ���Ϣ
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Document findById(int id) throws ClassNotFoundException, SQLException {
		
		DocumentDao documentDao = new DocumentDao();
		
		Document document = documentDao.selectById(id);
	
		return document;
	}
	
}
