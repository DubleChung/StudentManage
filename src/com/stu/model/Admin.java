package com.stu.model;

/***
 * ����Ա��
 * 
 */
public class Admin {

	private String uName;
	private String uAccouts;
	private String uPwd;

	/**
	 * ��ȡ����
	 * 
	 * @return
	 */
	public String getUName() {
		return uName;
	}

	/**
	 * ��������
	 * 
	 * @param name
	 */
	public void setUName(String name) {
		uName = name;
	}

	/**
	 * ��ȡ�˺�
	 * 
	 * @return
	 */
	public String getUAccouts() {
		return uAccouts;
	}

	/**
	 * �����˺�
	 * 
	 * @param accouts
	 */
	public void setUAccouts(String accouts) {
		uAccouts = accouts;
	}

	/**
	 * ��ȡ����
	 * 
	 * @return
	 */
	public String getUPwd() {
		return uPwd;
	}

	/**
	 * ��������
	 * 
	 * @param pwd
	 */
	public void setUPwd(String pwd) {
		uPwd = pwd;
	}

}
