package com.stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.core.DB;
import com.stu.model.PageBean;
import com.stu.model.StudentBean;
import com.stu.service.StudentService;

/**
 * 学生类数据库操作类
 * 
 * @author 梁钊伟、曹强、胡代鑫、邹家华
 * 
 */
public class StudentDao implements StudentService {

	// 实例化数据操作类
	DB db = new DB();

	/**
	 * 添加学生信息
	 * 
	 * @author 胡代鑫
	 * 
	 */
	public boolean addStudent(StudentBean model) {

		// 待执行SQL语句
		String sql = "insert into t_student(`stuName`,`stuNo`,`cno`,`gno`,`stuAge`,`stuAddr`,`stuSex`) values(?,?,?,?,?,?,?)";

		// SQL参数
		Object[] params = { model.getStuName(), model.getStuNo(),
				model.getCno(), model.getGno(), model.getStuAge(),
				model.getStuAddr(), model.getStuSex() };

		try {

			// 执行SQL语句
			db.doPstm(sql, params);

			// 获取执行SQL语句影响行数
			int rowCount = db.getCount();

			// 如果影响行数大于0，则执行成功，否则失败。
			return (rowCount > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放数据库链接
			db.close();
		}

		// 默认执行失败
		return false;
	}

	/**
	 * 查询学生信息
	 * 
	 * @author 曹强、梁钊伟
	 * 
	 * @param model
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<StudentBean> getStudents(StudentBean model,
			int currentPage, int pageSize) {

		// 设置分页数据
		PageBean<StudentBean> pageBean = new PageBean<StudentBean>();
		pageBean.setCurrentPage(currentPage);// 设置当前页码
		pageBean.setPageSize(pageSize);// 设置总大小

		// 初始化数据结果
		ArrayList returnList = new ArrayList();

		// SQL语句参数
		ArrayList params = new ArrayList();

		// 拼接SQL语句
		String sql = "select * from t_student where 1=1 ";
		if (model != null) {
			// 姓名查询条件
			if (!("".equals(model.getStuName()))) {
				sql += " and stuName like ? ";
				params.add("%" + model.getStuName() + "%");// 姓名用模糊查询,所以在前后加了%符号
			}
			// 学号查询条件
			if (!("".equals(model.getStuNo()))) {
				sql += " and stuNo = ? ";
				params.add(model.getStuNo());
			}
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
					// 实例化学生信息类
					StudentBean studentBean = new StudentBean();

					// 分别取对应的字段值
					studentBean.setStuid(rs.getInt("stuid"));// 学生标识ID
					studentBean.setStuName(rs.getString("stuName"));// 姓名
					studentBean.setStuNo(rs.getString("stuNo"));// 学号
					studentBean.setCno(rs.getString("cno"));// 班级号
					studentBean.setGno(rs.getString("gno"));// 年级号
					studentBean.setStuAge(rs.getInt("stuAge"));// 年龄
					studentBean.setStuAddr(rs.getString("stuAddr"));// 住址
					studentBean.setStuSex(rs.getString("stuSex"));// 性别

					// 添加到返回的结果列表中
					returnList.add(studentBean);
				}

				// 在数据库中统计数据总条数
				int totalCount = getStudentCount(model);

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
	 * @author 梁钊伟、曹强
	 * 
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	private int getStudentCount(StudentBean model) {
		// 数据总条数
		int totalCount = 0;

		// SQL语句参数
		ArrayList params = new ArrayList();

		// 拼接SQL语句
		String sql = "select count(stuid) as totalCount from t_student where 1=1 ";
		if (model != null) {
			// 姓名查询条件
			if (!("".equals(model.getStuName()))) {
				sql += " and stuName like ? ";
				params.add("%" + model.getStuName() + "%");// 姓名用模糊查询,所以在前后加了%符号
			}
			// 学号查询条件
			if (!("".equals(model.getStuNo()))) {
				sql += " and stuNo = ? ";
				params.add(model.getStuNo());
			}
		}

		try {

			// 执行SQL语句
			db.doPstm(sql, params.toArray());

			// 从结果集中取出数据条数
			ResultSet rs = db.getRs();
			if (rs != null) {
				if (rs.next()) {
					totalCount = rs.getInt("totalCount");// 取出统计的数量
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放数据库链接
			db.close();
		}
		// 返回结果
		return totalCount;
	}

	/**
	 * 根据姓名查询学生信息，添加成绩的时候用
	 * 【只选10个出来】
	 * 
	 * @author 胡代鑫
	 * 
	 * @param stuName
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List getStudents(String stuName) {

		// 结果列表
		List stuList = new ArrayList<StudentBean>();

		// 待执行的SQL语句
		String sql = "select stuid,stuNo,stuName from t_student ";

		// SQL语句参数
		List params = new ArrayList();

		// 拼接SQL语句和SQL参数
		if (!stuName.isEmpty()) {
			sql += " where stuName like ?";
			params.add("%" + stuName + "%");// 因为是模糊查询,所以把值的前后加了%
		}

		// 只取10条数据
		sql += " limit 0,10";

		try {

			// 执行SQL语句
			db.doPstm(sql, params.toArray());

			// 获取执行SQL后的结果集
			ResultSet rs = db.getRs();

			if (rs != null) {
				while (rs.next()) {
					// 实例化学生类
					StudentBean studentBean = new StudentBean();
					studentBean.setStuid(rs.getInt("stuid"));// 学生标识ID
					studentBean.setStuName(rs.getString("stuName"));// 学生姓名
					studentBean.setStuNo(rs.getString("stuNo"));// 学号

					// 添加到结果列表
					stuList.add(studentBean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放数据库链接
			db.close();
		}

		return stuList;
	}

	/**
	 * 删除学生信息
	 * 
	 * @author 邹家华
	 * 
	 * @param stuid
	 * @return
	 */
	public boolean deleteStudent(int stuid) {

		// SQL参数
		Object[] params = { stuid };

		try {
			// 执行数据删除操作
			db.doPstm("delete from t_score where stuNo = (select stuNo from t_student where stuid = ?)",params);

			db.doPstm("delete from t_student where stuid = ?", params);

			// 获取影响数据行数
			int rowCount = db.getCount();

			// 结果> 0表示成功
			return (rowCount > 0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放数据库链接
			db.close();
		}
		return false;
	}

	/**
	 * 检查学号是否存在
	 * 
	 * @author 胡代鑫
	 * 
	 */
	public boolean checkExists(String stuNo) {

		// 待执行SQL语句
		String sql = "select stuid from t_student where stuNo = ?";

		// SQL参数
		Object[] params = { stuNo };

		try {
			//执行数据查询 
			db.doPstm(sql, params);
			
			//获取查询结果集
			ResultSet rs = db.getRs();
			
			//如果存在有则学生标识 ID大于0
			if(rs != null && rs.next()){
				int stuid = rs.getInt("stuid");
				
				return (stuid > 0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放数据库链接
			db.close();
		}

		return false;
	}
}
