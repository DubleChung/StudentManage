package com.stu.model;

/**
 * 成绩类
 * @author Administrator
 *
 */
public class ScoreBean {
	private int sid;
	private float score;
	private String course;
	private String stuno;

	/**
	 * 获取成绩标识ID
	 * 
	 * @return
	 */
	public int getSid() {
		return sid;
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
		return score;
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
	 * 获取学生学号
	 * 
	 * @return
	 */
	public String getStuno() {
		return stuno;
	}

	/**
	 * 设置学生学号
	 * 
	 * @param stuno
	 */
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	/**
	 * 获取课程
	 * @return
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * 设置课程
	 * @param course
	 */
	public void setCourse(String course) {
		this.course = course;
	}
}
