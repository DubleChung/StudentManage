package com.stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.stu.core.DB;
import com.stu.model.Admin;
import com.stu.service.AdminService;

public class AdminDao implements AdminService {

	// ʵ�������ݿ���ʶ���
	DB db = new DB();

	public Admin adminLogin(Admin model) {
		Admin returnModel = null;
		try {

			// SQL���
			String sql = "select * from t_admin where uAccounts=? and uPassword=?";

			// ����SQL������
			Object[] params = { model.getUAccouts(), model.getUPassword() };

			// ִ��SQL��ѯ
			db.doPstm(sql, params);

			// ��ȡ�����
			ResultSet rs = db.getRs();

			if (rs != null && rs.next()) {

				// ʵ��������Ա
				returnModel = new Admin();

				// �ӽ�����ж�ȡ�������ù���Աʵ������
				returnModel.setUid(rs.getInt("uid"));// ���ù���Ա��ʶID
				returnModel.setUName(rs.getString("uName"));// ���ù���Ա����
				returnModel.setUAccouts(rs.getString("uAccounts"));// ���ù���Ա�˺�
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return returnModel;
	}

	public boolean changePassword(Admin model, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

}
