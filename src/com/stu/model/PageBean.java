package com.stu.model;

import java.util.List;

/**
 * ��ҳ��
 * 
 * @author Administrator
 * 
 */
public class PageBean<T> {
	private int currentPage = 1; // ��ǰҳ��, Ĭ����ʾ��һҳ
	private int pageSize = 10; // ҳ��С(ÿҳ��ʾ����������), Ĭ��ÿҳ��ʾ10��
	private int totalCount; // ����������
	private int totalPage; // ��ҳ�� = �ܼ����� / ÿҳ��ʾ������ (+1)
	private List<T> pageData; // ��ҳ��ѯ��������
	private int nextPage = 1;// ��һҳҳ��
	private int prevPage = 1;// ��һҳҳ��
	private int lastPage = 1;// ���һҳҳ��

	/**
	 * ��ȡ��ҳ��
	 * 
	 * @return
	 */
	public int getTotalPage() {
		if (this.totalCount % this.pageSize == 0) {
			this.totalPage = this.totalCount / this.pageSize;
		} else {
			this.totalPage = this.totalCount / this.pageSize + 1;
		}
		return this.totalPage;
	}

	/**
	 * ��ȡ��ǰҳ��
	 * 
	 * @return
	 */
	public int getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * ���õ�ǰҳ��
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * ��ȡҳ��С
	 * 
	 * @return
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * ����ҳ��С
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��ȡ����������
	 * 
	 * @return
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * ��������������
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * ��ȡ��ҳ����
	 * 
	 * @return
	 */
	public List<T> getPageData() {
		return this.pageData;
	}

	/**
	 * ���÷�ҳ����
	 * 
	 * @param pageData
	 */
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	/**
	 * ��ȡ��һҳҳ��
	 * 
	 * @return
	 */
	public int getNextPage() {
		if((this.getCurrentPage() + 1) >= this.getTotalPage())
		{
			return this.getTotalPage();
		}
		else
		{
			return this.getCurrentPage() + 1;
		}
	}

	/**
	 * ��ȡ��һҳҳ��
	 * 
	 * @return
	 */
	public int getPrevPage() {
		if(this.getCurrentPage() < 2)
		{
			return 1;
		}
		else
		{
			return this.getCurrentPage() -1;
		}
	}

	/**
	 * ��ȡ���һҳҳ��
	 * 
	 * @return
	 */
	public int getLastPage() {
		return this.getTotalPage();
	}

}
