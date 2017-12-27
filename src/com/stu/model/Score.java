package com.stu.model;

/**
 * 成绩类
 *
 */
public class Score {
	private int sc_id;
	private String cs_no;
	private String stu_no;
	private int sc_score;
	
	/**
	 * 获取成绩标识ID
	 * @return
	 */
	public int getSc_id() {
		return sc_id;
	}
	/**
	 * 设置成绩标识IDeas
	 * @param sc_id
	 */
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	
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
	 * 获取学号
	 * @return
	 */
	public String getStu_no() {
		return stu_no;
	}
	/**
	 * 设置学号
	 * @param stu_no
	 */
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	
	/**
	 * 获取成绩
	 * @return
	 */
	public int getSc_score() {
		return sc_score;
	}
	/**
	 * 设置成绩
	 * @param sc_score
	 */
	public void setSc_score(int sc_score) {
		this.sc_score = sc_score;
	}
	
}
