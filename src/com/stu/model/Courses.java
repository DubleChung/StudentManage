package com.stu.model;

/**
 * �γ���
 * @author zhong
 *
 */
public class Courses {
	private String cs_no;
	private String cs_Name;
	private int cs_hour;
	private int cs_score;
	
	/**
	 * ��ȡ�γ̱��
	 * @return
	 */
	public String getCs_no() {
		return cs_no;
	}
	/**
	 * ���ÿγ̱��
	 * @param cs_no
	 */
	public void setCs_no(String cs_no) {
		this.cs_no = cs_no;
	}
	
	/**
	 * ��ȡ�γ�����
	 * @return
	 */
	public String getCs_Name() {
		return cs_Name;
	}
	/**
	 * ���ÿγ�����
	 * @param cs_Name
	 */
	public void setCs_Name(String cs_Name) {
		this.cs_Name = cs_Name;
	}
	
	/**
	 * ��ȡ�γ�ѧʱ
	 * @return
	 */
	public int getCs_hour() {
		return cs_hour;
	}
	/**
	 * ���ÿγ�ѧʱ
	 * @param cs_hour
	 */
	public void setCs_hour(int cs_hour) {
		this.cs_hour = cs_hour;
	}
	
	/**
	 * ��ȡ�γ�ѧ��
	 * @return
	 */
	public int getCs_score() {
		return cs_score;
	}
	/**
	 * ���ÿγ�ѧ��
	 * @param cs_score
	 */
	public void setCs_score(int cs_score) {
		this.cs_score = cs_score;
	}
	
}
