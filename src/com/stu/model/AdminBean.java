package com.stu.model;

/**
 * ����Ա��
 * @author Administrator
 *
 */
public class AdminBean {
	private int uid;
	private String uName;
	private String uAccounts;
	private String uPassword;
	private String uRemark;

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
	 * ��ȡ����Ա����
	 * 
	 * @return
	 */
	public String getUName() {
		return uName;
	}

	/**
	 * ���ù���Ա����
	 * 
	 * @param name
	 */
	public void setUName(String name) {
		uName = name;
	}

	/**
	 * ��ȡ����Ա�˺�
	 * 
	 * @return
	 */
	public String getUAccounts() {
		return uAccounts;
	}

	/**
	 * ���ù���Ա�˺�
	 * 
	 * @param accounts
	 */
	public void setUAccounts(String accounts) {
		uAccounts = accounts;
	}

	/**
	 * ��ȡ����Ա����
	 * 
	 * @return
	 */
	public String getUPassword() {
		return uPassword;
	}

	/**
	 * ���ù���Ա����
	 * 
	 * @param password
	 */
	public void setUPassword(String password) {
		uPassword = password;
	}

	/**
	 * ��ȡ����Ա��ע
	 * 
	 * @return
	 */
	public String getURemark() {
		return uRemark;
	}

	/**
	 * ���ù���Ա��ע
	 * 
	 * @param remark
	 */
	public void setURemark(String remark) {
		uRemark = remark;
	}

}
