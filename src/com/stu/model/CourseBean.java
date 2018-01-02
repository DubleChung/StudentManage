package com.stu.model;

/**
 * 课程类
 * 
 * @author Administrator
 * 
 */
public class CourseBean {
	private int csid;
	private String csName;
	private String csno;

	/**
	 * 获取课程标识ID
	 * 
	 * @return
	 */
	public int getCsid() {
		return csid;
	}

	/**
	 * 设置课程标识ID
	 * 
	 * @param csid
	 */
	public void setCsid(int csid) {
		this.csid = csid;
	}

	/**
	 * 获取课程名称
	 * 
	 * @return
	 */
	public String getCsName() {
		return csName;
	}

	/**
	 * 设置课程名称
	 * 
	 * @param csName
	 */
	public void setCsName(String csName) {
		this.csName = csName;
	}

	/**
	 * 获取课程编号
	 * 
	 * @return
	 */
	public String getCsno() {
		return csno;
	}

	/**
	 * 设置课程编号
	 * 
	 * @param csno
	 */
	public void setCsno(String csno) {
		this.csno = csno;
	}

}
