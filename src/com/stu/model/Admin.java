package com.stu.model;

/***
 * ����Ա��
 * 
 */
public class Admin {
	private int uid;
	private String uName;
	private String uAccouts;
	private String uPassword;

	/**
	 * ��ȡ����Ա��ʶID
	 * 
	 * @return
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * ���ù���Ա��ʶID
	 * 
	 * @param uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

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
	public String getUPassword() {
		return uPassword;
	}

	/**
	 * ��������
	 * 
	 * @param password
	 */
	public void setUPassword(String password) {
		uPassword = password;
	}

}
