package com.stu.model;

/**
 * 课程类
 * @author zhong
 *
 */
public class Courses {
	private String cs_no;
	private String cs_Name;
	private int cs_hour;
	private int cs_score;
	
	/**
	 * 获取课程编号
	 * @return
	 */
	public String getCs_no() {
		return cs_no;
	}
	/**
	 * 设置课程编号
	 * @param cs_no
	 */
	public void setCs_no(String cs_no) {
		this.cs_no = cs_no;
	}
	
	/**
	 * 获取课程名称
	 * @return
	 */
	public String getCs_Name() {
		return cs_Name;
	}
	/**
	 * 设置课程名称
	 * @param cs_Name
	 */
	public void setCs_Name(String cs_Name) {
		this.cs_Name = cs_Name;
	}
	
	/**
	 * 获取课程学时
	 * @return
	 */
	public int getCs_hour() {
		return cs_hour;
	}
	/**
	 * 设置课程学时
	 * @param cs_hour
	 */
	public void setCs_hour(int cs_hour) {
		this.cs_hour = cs_hour;
	}
	
	/**
	 * 获取课程学分
	 * @return
	 */
	public int getCs_score() {
		return cs_score;
	}
	/**
	 * 设置课程学分
	 * @param cs_score
	 */
	public void setCs_score(int cs_score) {
		this.cs_score = cs_score;
	}
	
}
