package com.stu.service;

import com.stu.model.Admin;

/***
 * ����ԱService
 * 
 */
public interface AdminService {

	/**
	 * ����Ա��¼
	 * 
	 * @param model
	 * @return
	 */
	Admin adminLogin(Admin model);

	/**
	 * �޸Ĺ���Ա����
	 * 
	 * @param model
	 * @param newPassword
	 * @return
	 */
	boolean changePassword(Admin model, String newPassword);

}
