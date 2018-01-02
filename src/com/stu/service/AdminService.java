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
	 * ��ӹ���Ա
	 * @param model
	 * @return
	 */
	boolean addAdmin(AdminBean model);

	/**
	 * �޸Ĺ���Ա����
	 * 
	 * @param model
	 * @param newPassword
	 * @return
	 */
	boolean changePassword(AdminBean model, String newPassword);

}
