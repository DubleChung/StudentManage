package com.stu.model;

/**
 * �γ���
 * 
 * @author Administrator
 * 
 */
public class CourseBean {
	private int csid;
	private String csName;
	private String csno;

	/**
	 * ��ȡ�γ̱�ʶID
	 * 
	 * @return
	 */
	public int getCsid() {
		return csid;
	}

	/**
	 * ���ÿγ̱�ʶID
	 * 
	 * @param csid
	 */
	public void setCsid(int csid) {
		this.csid = csid;
	}

	/**
	 * ��ȡ�γ�����
	 * 
	 * @return
	 */
	public String getCsName() {
		return csName;
	}

	/**
	 * ���ÿγ�����
	 * 
	 * @param csName
	 */
	public void setCsName(String csName) {
		this.csName = csName;
	}

	/**
	 * ��ȡ�γ̱��
	 * 
	 * @return
	 */
	public String getCsno() {
		return csno;
	}

	/**
	 * ���ÿγ̱��
	 * 
	 * @param csno
	 */
	public void setCsno(String csno) {
		this.csno = csno;
	}

}
