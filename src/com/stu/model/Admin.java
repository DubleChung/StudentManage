package com.stu.model;

/***
 * 管理员类
 * 
 */
public class Admin {

	private String uName;
	private String uAccouts;
	private String uPwd;

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
	public String getUPwd() {
		return uPwd;
	}

	/**
	 * 设置密码
	 * 
	 * @param pwd
	 */
	public void setUPwd(String pwd) {
		uPwd = pwd;
	}

}
