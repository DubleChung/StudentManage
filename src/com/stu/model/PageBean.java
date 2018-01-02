package com.stu.model;

import java.util.List;

/**
 * 分页类
 * 
 * @author Administrator
 * 
 */
public class PageBean<T> {
	private int currentPage = 1; // 当前页码, 默认显示第一页
	private int pageSize = 10; // 页大小(每页显示多少条数据), 默认每页显示10条
	private int totalCount; // 数据总条数
	private int totalPage; // 总页数 = 总记条数 / 每页显示的条数 (+1)
	private List<T> pageData; // 分页查询到的数据
	private int nextPage = 1;// 下一页页码
	private int prevPage = 1;// 上一页页码
	private int lastPage = 1;// 最后一页页码

	/**
	 * 获取总页数
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
	 * 获取当前页码
	 * 
	 * @return
	 */
	public int getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * 设置当前页码
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 获取页大小
	 * 
	 * @return
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * 设置页大小
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取数据总条数
	 * 
	 * @return
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 设置数据总条数
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 获取分页数据
	 * 
	 * @return
	 */
	public List<T> getPageData() {
		return this.pageData;
	}

	/**
	 * 设置分页数据
	 * 
	 * @param pageData
	 */
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	/**
	 * 获取下一页页码
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
	 * 获取上一页页码
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
	 * 获取最后一页页码
	 * 
	 * @return
	 */
	public int getLastPage() {
		return this.getTotalPage();
	}

}
