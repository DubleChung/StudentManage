package com.stu.model;

/***
 * 学生成绩类
 * 
 */
public class StudentScore extends Student {
	private String cs_no;
	private String cs_name;
	private int sc_score;

	/**
	 * 获取课程编号
	 * 
	 * @return
	 */
	public String getCs_no() {
		return cs_no;
	}

	/**
	 * 设置课程编号
	 * 
	 * @param cs_no
	 */
	public void setCs_no(String cs_no) {
		this.cs_no = cs_no;
	}

	/**
	 * 获取课程名称
	 * 
	 * @return
	 */
	public String getCs_name() {
		return cs_name;
	}

	/**
	 * 设置名称
	 * 
	 * @param cs_name
	 */
	public void setCs_name(String cs_name) {
		this.cs_name = cs_name;
	}

	/**
	 * 获取课程成绩
	 * 
	 * @return
	 */
	public int getSc_score() {
		return sc_score;
	}

	/**
	 * 设置课程成绩
	 * 
	 * @param sc_score
	 */
	public void setSc_score(int sc_score) {
		this.sc_score = sc_score;
	}
}
