package com.stu.model;

/**
 * �ɼ���
 *
 */
public class Score {
	private int sc_id;
	private String cs_no;
	private String stu_no;
	private int sc_score;
	
	/**
	 * ��ȡ�ɼ���ʶID
	 * @return
	 */
	public int getSc_id() {
		return sc_id;
	}
	/**
	 * ���óɼ���ʶIDeas
	 * @param sc_id
	 */
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	
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
	 * ��ȡѧ��
	 * @return
	 */
	public String getStu_no() {
		return stu_no;
	}
	/**
	 * ����ѧ��
	 * @param stu_no
	 */
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	
	/**
	 * ��ȡ�ɼ�
	 * @return
	 */
	public int getSc_score() {
		return sc_score;
	}
	/**
	 * ���óɼ�
	 * @param sc_score
	 */
	public void setSc_score(int sc_score) {
		this.sc_score = sc_score;
	}
	
}
