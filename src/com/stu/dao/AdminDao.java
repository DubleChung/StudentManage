package com.stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.stu.core.DB;
import com.stu.model.AdminBean;
import com.stu.service.AdminService;

/**
 * ����Ա���ݿ������
 * @author Administrator
 *
 */
public class AdminDao implements AdminService {

	// ʵ�������ݿ���ʶ���
	DB db = new DB();

	public AdminBean adminLogin(AdminBean model) {
		AdminBean returnModel = null;
		try {

			// SQL���
			String sql = "select * from t_admin where uAccounts=? and uPassword=?";

			// ����SQL������
			Object[] params = { model.getUAccounts(), model.getUPassword() };

			// ִ��SQL��ѯ
			db.doPstm(sql, params);

			// ��ȡ�����
			ResultSet rs = db.getRs();

			if (rs != null) 
			{
				// ʵ��������Ա
				returnModel = new AdminBean();
				
				while(rs.next())
				{
					// �ӽ�����ж�ȡ�������ù���Աʵ������
					returnModel.setUid(rs.getInt("uid"));// ���ù���Ա��ʶID
					returnModel.setUName(rs.getString("uName"));// ���ù���Ա����
					returnModel.setUAccounts(rs.getString("uAccounts"));// ���ù���Ա�˺�
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			db.close();
		}
		
		return returnModel;
	}
	
	public boolean addAdmin(AdminBean model) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changePassword(AdminBean model, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}


}
