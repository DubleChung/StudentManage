package com.stu.model;

/**
 * 成绩类
 * 
 * @author Administrator
 * 
 */
public class ScoreBean {
	private int sid;
	private float score;
	private String course;
	private String stuName;
	private String stuNo;

	/**
	 * 获取成绩标识ID
	 * 
	 * @return
	 */
	public int getSid() {
		return this.sid;
	}

	/**
	 * 设置成绩标识 ID
	 * 
	 * @param sid
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}

	/**
	 * 获取成绩
	 * 
	 * @return
	 */
	public float getScore() {
		return this.score;
	}

	/**
	 * 设置成绩
	 * 
	 * @param score
	 */
	public void setScore(float score) {
		this.score = score;
	}


	/**
	 * 获取课程
	 * 
	 * @return
	 */
	public String getCourse() {
		return this.course;
	}

	/**
	 * 设置课程
	 * 
	 * @param course
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * 获取学生姓名
	 * 
	 * @return
	 */
	public String getStuName() {
		return this.stuName;
	}

	/**
	 * 设置学生姓名
	 * 
	 * @param stuName
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	/**
	 * 获取学号
	 * @return
	 */
	public String getStuNo() {
		return this.stuNo;
	}

	/**
	 * 设置学号
	 * @param stuNo
	 */
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
}
