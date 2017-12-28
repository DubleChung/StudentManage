package com.stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.stu.core.DB;
import com.stu.model.Admin;
import com.stu.service.AdminService;

public class AdminDao implements AdminService {

	// 实例化数据库访问对象
	DB db = new DB();

	public Admin adminLogin(Admin model) {
		Admin returnModel = null;
		try {

			// SQL语句
			String sql = "select * from t_admin where uAccounts=? and uPassword=?";

			// 设置SQL语句参数
			Object[] params = { model.getUAccouts(), model.getUPassword() };

			// 执行SQL查询
			db.doPstm(sql, params);

			// 获取结果集
			ResultSet rs = db.getRs();

			if (rs != null && rs.next()) {

				// 实例化管理员
				returnModel = new Admin();

				// 从结果集中读取，并设置管理员实体数据
				returnModel.setUid(rs.getInt("uid"));// 设置管理员标识ID
				returnModel.setUName(rs.getString("uName"));// 设置管理员姓名
				returnModel.setUAccouts(rs.getString("uAccounts"));// 设置管理员账号
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
