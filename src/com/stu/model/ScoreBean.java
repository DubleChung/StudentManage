package com.stu.model;

/**
 * �ɼ���
 * @author Administrator
 *
 */
public class ScoreBean {
	private int sid;
	private float score;
	private String course;
	private String stuno;

	/**
	 * ��ȡ�ɼ���ʶID
	 * 
	 * @return
	 */
	public int getSid() {
		return sid;
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
		return score;
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
	 * ��ȡѧ��ѧ��
	 * 
	 * @return
	 */
	public String getStuno() {
		return stuno;
	}

	/**
	 * ����ѧ��ѧ��
	 * 
	 * @param stuno
	 */
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	/**
	 * ��ȡ�γ�
	 * @return
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * ���ÿγ�
	 * @param course
	 */
	public void setCourse(String course) {
		this.course = course;
	}
}
