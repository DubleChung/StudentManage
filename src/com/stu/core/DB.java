package com.stu.core;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	private Connection con;
	private PreparedStatement pstm;
	private String url;
	private String user;
	private String password;

	/**
	 * @���ܣ����췽�����÷����м������ݿ����á�������
	 */
	public DB() {
		try {

			// ͨ������������������ݿ������ļ�
			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream("/DB.properties");
			prop.load(in);

			// ��ȡ���ݿ��û���
			user = prop.getProperty("DB_USER");

			// ��ȡ���ݿ�����
			password = prop.getProperty("DB_PASSWORD");

			// ��ȡ���ݿ����ӵ�ַ
			url = prop.getProperty("DB_URL");

			// ��ȡ���ݿ�����
			Class.forName(prop.getProperty("DB_CLASS_NAME"));

		} catch (IOException e) {
			System.out.println("���ݿ������ļ���ȡʧ�ܣ�");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	/**
	 * @���ܣ���ȡ���ݿ�����
	 * @return
	 */
	public Connection getConn() {
		if (con == null) {
			try {
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("�������ݿ�����ʧ�ܣ�");
				e.printStackTrace();
			}
		}
		return con;
	}

	/**
	 * @���ܣ������ݿ��������ɾ���ġ������ ?"ռλ����ֵ������
	 * @param sql
	 * @param params
	 */
	public void doPstm(String sql, Object[] params) {
		if (sql != null && !sql.equals("")) {
			if (params == null)
				params = new Object[0];
			getConn();
			if (con != null) {
				try {
					System.out.println(sql);
					pstm = con.prepareStatement(sql,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					for (int i = 0; i < params.length; i++) {
						pstm.setObject(i + 1, params[i]);
					}
					pstm.execute();
				} catch (SQLException e) {
					System.out.println("doPstm()����������");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @���ܣ���ȡ����doPstm()����ִ�в�ѯ�����󷵻ص�ResultSet�����
	 * @����ֵ��ResultSet
	 * @throws SQLException
	 */
	public ResultSet getRs() throws SQLException {
		return pstm.getResultSet();
	}

	/**
	 * @���ܣ���ȡ����doPstm()����ִ�и��²����󷵻�Ӱ��ļ�¼��
	 * @����ֵ��int
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {
		return pstm.getUpdateCount();
	}

	/**
	 * @���ܣ��ͷ�PrepareStatement������Connection����
	 */
	public void close() {
		try {
			if (pstm != null)
				pstm.close();
		} catch (SQLException e) {
			System.out.println("�ر�pstm����ʧ�ܣ�");
			e.printStackTrace();
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("�ر�con����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}