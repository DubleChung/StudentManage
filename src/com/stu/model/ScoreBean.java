package com.stu.model;

/**
 * �ɼ���
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
	 * ��ȡ�ɼ���ʶID
	 * 
	 * @return
	 */
	public int getSid() {
		return this.sid;
	}

	/**
	 * ���óɼ���ʶ ID
	 * 
	 * @param sid
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}

	/**
	 * ��ȡ�ɼ�
	 * 
	 * @return
	 */
	public float getScore() {
		return this.score;
	}

	/**
	 * ���óɼ�
	 * 
	 * @param score
	 */
	public void setScore(float score) {
		this.score = score;
	}


	/**
	 * ��ȡ�γ�
	 * 
	 * @return
	 */
	public String getCourse() {
		return this.course;
	}

	/**
	 * ���ÿγ�
	 * 
	 * @param course
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * ��ȡѧ������
	 * 
	 * @return
	 */
	public String getStuName() {
		return this.stuName;
	}

	/**
	 * ����ѧ������
	 * 
	 * @param stuName
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	/**
	 * ��ȡѧ��
	 * @return
	 */
	public String getStuNo() {
		return this.stuNo;
	}

	/**
	 * ����ѧ��
	 * @param stuNo
	 */
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
}
