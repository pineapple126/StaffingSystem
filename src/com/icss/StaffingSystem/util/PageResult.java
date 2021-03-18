package com.icss.StaffingSystem.util;

import java.util.*;

import com.icss.StaffingSystem.entity.User;

public class PageResult<T> {

	private List<T> list; // ��ҳ���б�
	private Integer currentPage; // ��ǰ��ҳ��
	private Integer totalCount; // ���ж�����
	private Integer totalPage; // ���ж���ҳ
	
	public PageResult() {
		super();
	}
	
	public PageResult(List<T> list, Integer currentPage, Integer totalCount, Integer totalPage) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
}
