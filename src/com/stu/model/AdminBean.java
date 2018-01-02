package com.stu.model;

/**
 * 管理员类
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
	 * 获取管理员标识ID
	 * 
	 * @return
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * 设置管理员标识ID
	 * 
	 * @param uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * 获取管理员姓名
	 * 
	 * @return
	 */
	public String getUName() {
		return uName;
	}

	/**
	 * 设置管理员姓名
	 * 
	 * @param name
	 */
	public void setUName(String name) {
		uName = name;
	}

	/**
	 * 获取管理员账号
	 * 
	 * @return
	 */
	public String getUAccounts() {
		return uAccounts;
	}

	/**
	 * 设置管理员账号
	 * 
	 * @param accounts
	 */
	public void setUAccounts(String accounts) {
		uAccounts = accounts;
	}

	/**
	 * 获取管理员密码
	 * 
	 * @return
	 */
	public String getUPassword() {
		return uPassword;
	}

	/**
	 * 设置管理员密码
	 * 
	 * @param password
	 */
	public void setUPassword(String password) {
		uPassword = password;
	}

	/**
	 * 获取管理员备注
	 * 
	 * @return
	 */
	public String getURemark() {
		return uRemark;
	}

	/**
	 * 设置管理员备注
	 * 
	 * @param remark
	 */
	public void setURemark(String remark) {
		uRemark = remark;
	}

}
