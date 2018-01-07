package com.stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stu.core.DB;
import com.stu.model.PageBean;
import com.stu.model.ScoreBean;
import com.stu.service.ScoreService;

public class ScoreDao implements ScoreService {

	// 实例化数据操作类
	DB db = new DB();

	/**
	 * 添加学生成绩
	 * 
	 */
	public boolean addStudentScore(String stuNo, String course, float score) {

		// 待执行SQL语句
		String sql = "insert into t_score(`stuNo`,`course`,`score`) values(?,?,?)";

		// SQL语句参数
		Object[] params = { stuNo, course, score };

		try {
			// 执行SQL语句
			db.doPstm(sql, params);

			// 获取执行SQL影响的数据行数
			int rowCount = db.getCount();

			// 结果>0表示成功
			return (rowCount > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 释放数据库链接
			db.close();
		}

		return false;
	}

	/**
	 * 查询成绩信息
	 */
	public PageBean<ScoreBean> getStudentScore(String stuNo, String stuName,
			int currentPage, int pageSize) {

		// 设置分页数据
		PageBean<ScoreBean> pageBean = new PageBean<ScoreBean>();
		pageBean.setCurrentPage(currentPage);// 设置当前页码
		pageBean.setPageSize(pageSize);// 设置总大小

		// 初始化数据结果
		ArrayList returnList = new ArrayList();

		// SQL语句参数
		ArrayList params = new ArrayList();

		// 拼接SQL语句
		String sql = "select tb1.*,tb2.stuName " + "from t_score as tb1 "
				+ "inner join t_student as tb2 on tb1.stuNo = tb2.stuNo "
				+ "where 1=1 ";

		// 学号查询条件
		if (!("".equals(stuNo))) {
			sql += " and tb1.stuNo = ? ";
			params.add(stuNo);// 学号
		}
		// 学生姓名查询条件
		if (!("".equals(stuName))) {
			sql += " and tb2.stuName = ? ";
			params.add(stuName);// 学生姓名
		}

		// 分页参数
		sql += " limit ?,? ";
		params.add((currentPage - 1) * pageSize);// 设置取数据索引
		params.add(pageSize);// 页大小

		try {
			// 执行SQL语句
			db.doPstm(sql, params.toArray());

			// 获取执行的结果
			ResultSet rs = db.getRs();

			// 检验数据是否有效
			if (rs != null) {
				while (rs.next()) {
					// 实例化成绩信息类
					ScoreBean scoreBean = new ScoreBean();

					// 分别取对应的字段值
					scoreBean.setSid(rs.getInt("sid"));// 成绩标识ID
					scoreBean.setStuNo(rs.getString("stuNo"));// 学号
					scoreBean.setStuName(rs.getString("stuName"));// 学生姓名
					scoreBean.setCourse(rs.getString("course"));// 课程
					scoreBean.setScore(rs.getFloat("score"));// 成绩

					// 添加到返回的结果列表中
					returnList.add(scoreBean);
				}

				// 在数据库中统计数据总条数
				int totalCount = getStudentScoreCount(stuNo, stuName);

				// 设置分页Bean中的总数据条数
				pageBean.setTotalCount(totalCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放数据库链接
			db.close();
		}
		// 设置当前页数据
		pageBean.setPageData(returnList);

		return pageBean;
	}

	/**
	 * 在数据库中统计数据总条数
	 * 
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	public int getStudentScoreCount(String stuNo, String stuName) {
		// 数据总条数
		int totalCount = 0;

		// SQL语句参数
		ArrayList params = new ArrayList();

		// 拼接SQL语句
		String sql = "select count(tb1.sid) as totalCount "
				+ "from t_score as tb1 "
				+ "inner join t_student as tb2 on tb1.stuNo = tb2.stuNo "
				+ "where 1=1 ";

		// 学号查询条件
		if (!("".equals(stuNo))) {
			sql += " and tb1.stuNo = ? ";
			params.add(stuNo);// 学号
		}
		// 学生姓名查询条件
		if (!("".equals(stuName))) {
			sql += " and tb2.stuName = ? ";
			params.add(stuName);// 学生姓名
		}

		try {

			// 执行SQL语句
			db.doPstm(sql, params.toArray());

			// 从结果集中取出数据条数
			ResultSet rs = db.getRs();

			// 取出统计的数量
			if (rs != null) {
				if (rs.next()) {
					totalCount = rs.getInt("totalCount");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 返回结果
		return totalCount;
	}

	/**
	 * 删除学生成绩信息
	 */
	public boolean deleteStudentScore(int sid) {

		// 拼接SQL语句
		String sql = "delete from t_score where sid = ? ";

		// SQL参数
		Object[] params = { sid };

		try {

			// 执行SQL语句
			db.doPstm(sql, params);

			// 获取执行SQL语句影响的行数
			int rowCount = db.getCount();

			// 判断结果>0表示 成功。
			return (rowCount > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放数库链接
			db.close();
		}

		return false;
	}

}
