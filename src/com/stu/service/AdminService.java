package com.stu.service;

import com.stu.model.AdminBean;

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
	AdminBean adminLogin(AdminBean model);

	/**
	 * �޸Ĺ���Ա����
	 * 
	 * @param model
	 * @param newPassword
	 * @return
	 */
	boolean changePassword(int uid,String uPassword, String newUPassword);

}
