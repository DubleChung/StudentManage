package com.stu.service;

import com.stu.model.AdminBean;

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
	AdminBean adminLogin(AdminBean model);

	/**
	 * 修改管理员密码
	 * 
	 * @param model
	 * @param newPassword
	 * @return
	 */
	boolean changePassword(int uid,String uPassword, String newUPassword);

}
