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
	private Connection conn;
	private PreparedStatement pstm;
	private String url;
	private String user;
	private String password;

	/**
	 * @功能：构造方法，该方法中加载数据库配置、驱动等
	 */
	public DB() {
		try {

			// 通过输入流对象加载数据库配置文件
			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream("/DB.properties");
			prop.load(in);

			// 获取数据库用户名
			user = prop.getProperty("DB_USER");

			// 获取数据库密码
			password = prop.getProperty("DB_PASSWORD");

			// 获取数据库连接地址
			url = prop.getProperty("DB_URL");

			// 获取数据库驱动
			Class.forName(prop.getProperty("DB_CLASS_NAME"));

		} catch (IOException e) {
			System.out.println("数据库配置文件读取失败！");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
		}
	}

	/**
	 * @功能：获取数据库连接
	 * @return
	 */
	private Connection getConn() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("创建数据库连接失败！");
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * @功能：对数据库进行增、删、改、查操作 ?"占位符赋值的数据
	 * @param sql
	 *            待执行的SQL语句
	 * @param params
	 *            如果没有参数就填null
	 */
	public void doPstm(String sql, Object[] params) {
		if (sql != null && !sql.equals("")) {
			if (params == null)
				params = new Object[0];
			getConn();
			if (conn != null) {
				try {
					System.out.println(sql);
					pstm = conn.prepareStatement(sql,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					for (int i = 0; i < params.length; i++) {
						pstm.setObject(i + 1, params[i]);
						System.out.print(params[i].toString() + ",");
					}
					pstm.execute();
				} catch (SQLException e) {
					System.out.println("doPstm()方法出错！");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @功能：获取调用doPstm()方法执行查询操作后返回的ResultSet结果集
	 * @返回值：ResultSet 结果集
	 * @throws SQLException
	 */
	public ResultSet getRs() throws SQLException {
		return pstm.getResultSet();
	}

	/**
	 * @功能：获取调用doPstm()方法执行更新操作后返回影响的记录数
	 * @返回值：int 执行SQL语句影响的记录数
	 * @throws SQLException
	 */
	public int getCount() throws SQLException {
		return pstm.getUpdateCount();
	}

	/**
	 * @功能：释放PrepareStatement对象与Connection对象
	 */
	public void close() {
		try {
			if (pstm != null)
				pstm.close();
		} catch (SQLException e) {
			System.out.println("关闭pstm对象失败！");
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("关闭con对象失败！");
			e.printStackTrace();
		}
	}
}
