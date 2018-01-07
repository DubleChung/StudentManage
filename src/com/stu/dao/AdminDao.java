package com.stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.stu.core.DB;
import com.stu.model.AdminBean;
import com.stu.service.AdminService;

/**
 * ����Ա���ݿ������
 * 
 * @author Administrator
 * 
 */
public class AdminDao implements AdminService {

	// ʵ�������ݿ���ʶ���
	DB db = new DB();

	public AdminBean adminLogin(AdminBean model) {
		AdminBean returnModel = null;

		// SQL���
		String sql = "select * from t_admin where uAccounts=? and uPassword=?";

		// ����SQL������
		Object[] params = { model.getUAccounts(), model.getUPassword() };

		try {

			// ִ��SQL��ѯ
			db.doPstm(sql, params);

			// ��ȡ�����
			ResultSet rs = db.getRs();

			if (rs != null) {
				// ʵ��������Ա
				returnModel = new AdminBean();

				while (rs.next()) {
					// �ӽ�����ж�ȡ�������ù���Աʵ������
					returnModel.setUid(rs.getInt("uid"));// ���ù���Ա��ʶID
					returnModel.setUName(rs.getString("uName"));// ���ù���Ա����
					returnModel.setUAccounts(rs.getString("uAccounts"));// ���ù���Ա�˺�
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ����ݿ�����
			db.close();
		}

		return returnModel;
	}

	/**
	 * �޸�����
	 */
	public boolean changePassword(int uid, String uPassword, String newUPassword) {

		// ��ִ��SQL
		String sql = "update t_admin set uPassword = ? where uid = ? and uPassword = ?";

		// SQL����
		Object[] params = { newUPassword, uid, uPassword };

		try {

			// ִ�����ݿ����
			db.doPstm(sql, params);

			// ��ȡӰ������
			int rowCount = db.getCount();

			// ���>0��ʾ�ɹ�
			return (rowCount > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ͷ����ݿ�����
			db.close();
		}

		return false;
	}

}
