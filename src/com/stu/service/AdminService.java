package com.stu.service;

import com.stu.model.Admin;

/***
 * 管理员Service
 * 
 */
public interface AdminService {

	/**
	 * 管理员登录
	 * 
	 * @param model
	 * @return
	 */
	Admin adminLogin(Admin model);

	/**
	 * 修改管理员密码
	 * 
	 * @param model
	 * @param newPassword
	 * @return
	 */
	boolean changePassword(Admin model, String newPassword);

}
