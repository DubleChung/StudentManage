package com.stu.model;

/***
 * ѧ���ɼ���
 * 
 */
public class StudentScore extends Student {
	private String cs_no;
	private String cs_name;
	private int sc_score;

	/**
	 * ��ȡ�γ̱��
	 * 
	 * @return
	 */
	public String getCs_no() {
		return cs_no;
	}

	/**
	 * ���ÿγ̱��
	 * 
	 * @param cs_no
	 */
	public void setCs_no(String cs_no) {
		this.cs_no = cs_no;
	}

	/**
	 * ��ȡ�γ�����
	 * 
	 * @return
	 */
	public String getCs_name() {
		return cs_name;
	}

	/**
	 * ��������
	 * 
	 * @param cs_name
	 */
	public void setCs_name(String cs_name) {
		this.cs_name = cs_name;
	}

	/**
	 * ��ȡ�γ̳ɼ�
	 * 
	 * @return
	 */
	public int getSc_score() {
		return sc_score;
	}

	/**
	 * ���ÿγ̳ɼ�
	 * 
	 * @param sc_score
	 */
	public void setSc_score(int sc_score) {
		this.sc_score = sc_score;
	}
}
