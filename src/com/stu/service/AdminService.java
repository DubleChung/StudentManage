package com.stu.service;

import com.stu.model.AdminBean;

/***
 * ����ԱService
 * 
 * @author ���
 * 
 */
public interface AdminService {

	/**
	 * ����Ա��¼
	 * 
	 * @author ���
	 * 
	 * @param model
	 * @return
	 */
	AdminBean adminLogin(AdminBean model);

	/**
	 * �޸Ĺ���Ա����
	 * 
	 * @author ���
	 * 
	 * @param model
	 * @param newPassword
	 * @return
	 */
	boolean changePassword(int uid,String uPassword, String newUPassword);

}
