package com.icss.StaffingSystem.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.StaffingSystem.dao.DocumentDao;
import com.icss.StaffingSystem.entity.Document;
import com.icss.StaffingSystem.util.PageResult;

/**
 * 文档中心相关的业务逻辑
 * @author pineapple126
 *
 */
public class DocumentService {

	/**
	 * 实现获取得到满足过滤条件的文档分页结果的业务逻辑
	 * @param title 过滤条件：文档的标题
	 * @param currentPage 分页的已知条件一：展现的当前页码
	 * @param pageSize 分页的已知条件二：每页展现多少条
	 * @return 得到的满足过滤条件的文档分页结果
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
