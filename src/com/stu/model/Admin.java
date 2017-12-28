package com.stu.model;

/***
 * 管理员类
 * 
 */
public class Admin {
	private int uid;
	private String uName;
	private String uAccouts;
	private String uPassword;

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
	 * 获取姓名
	 * 
	 * @return
	 */
	public String getUName() {
		return uName;
	}

	/**
	 * 设置姓名
	 * 
	 * @param name
	 */
	public void setUName(String name) {
		uName = name;
	}

	/**
	 * 获取账号
	 * 
	 * @return
	 */
	public String getUAccouts() {
		return uAccouts;
	}

	/**
	 * 设置账号
	 * 
	 * @param accouts
	 */
	public void setUAccouts(String accouts) {
		uAccouts = accouts;
	}

	/**
	 * 获取密码
	 * 
	 * @return
	 */
	public String getUPassword() {
		return uPassword;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 */
	public void setUPassword(String password) {
		uPassword = password;
	}

}
