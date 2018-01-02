package com.stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stu.core.DB;
import com.stu.model.PageBean;
import com.stu.model.ScoreBean;
import com.stu.service.ScoreService;

public class ScoreDao implements ScoreService {

	// ʵ�������ݲ�����
	DB db = new DB();

	/**
	 * ���ѧ���ɼ�
	 * 
	 */
	public boolean addStudentScore(String stuNo, String course, float score) {

		// ������
		if (stuNo.isEmpty() || course.isEmpty()) {
			return false;
		}

		// ��ִ��SQL���
		String sql = "insert into t_student(`stuno`,`course`,`score`) values(?,?,?)";

		// SQL������
		Object[] params = { stuNo, course, score };

		try {
			// ִ��SQL���
			db.doPstm(sql, params);

			// ��ȡִ��SQLӰ�����������
			int rowCount = db.getCount();

			return (rowCount > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * ��ѯ�ɼ���Ϣ
	 */
	public PageBean<ScoreBean> getStudentScore(String stuNo, int currentPage,
			int pageSize) {

		// ���÷�ҳ����
		PageBean<ScoreBean> pageBean = new PageBean<ScoreBean>();
		pageBean.setCurrentPage(currentPage);// ���õ�ǰҳ��
		pageBean.setPageSize(pageSize);// �����ܴ�С

		// ��ʼ�����ݽ��
		ArrayList returnList = new ArrayList();

		// SQL������
		ArrayList params = new ArrayList();

		// ƴ��SQL���
		String sql = "select * from t_score where 1=1 ";

		// ѧ�Ų�ѯ����
		if (!("".equals(stuNo))) {
			sql += " and stuName = ? ";
			params.add(stuNo);// ѧ��
		}

		// ��ҳ����
		sql += " limit ?,? ";
		params.add((currentPage - 1) * pageSize);// ����ȡ��������
		params.add(pageSize);// ҳ��С

		try {
			// ִ��SQL���
			db.doPstm(sql, params.toArray());

			// ��ȡִ�еĽ��
			java.sql.ResultSet rs = db.getRs();

			// ���������Ƿ���Ч
			if (rs != null) {
				while (rs.next()) {
					// ʵ�����ɼ���Ϣ��
					ScoreBean scoreBean = new ScoreBean();

					// �ֱ�ȡ��Ӧ���ֶ�ֵ
					scoreBean.setSid(rs.getInt("sid"));// �ɼ���ʶID
					scoreBean.setStuno(rs.getString("stuNo"));// ѧ��
					scoreBean.setCourse(rs.getString("course"));// �γ�
					scoreBean.setScore(rs.getFloat("score"));// �ɼ�

					// ��ӵ����صĽ���б���
					returnList.add(scoreBean);
				}

				// �����ݿ���ͳ������������
				int totalCount = getStudentScoreCount(stuNo);

				// ���÷�ҳBean�е�����������
				pageBean.setTotalCount(totalCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		pageBean.setPageData(returnList);// ���õ�ǰҳ����

		return pageBean;
	}

	/**
	 * �����ݿ���ͳ������������
	 * 
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	private int getStudentScoreCount(String stuNo) throws SQLException {
		// ����������
		int totalCount = 0;

		// SQL������
		ArrayList params = new ArrayList();

		// ƴ��SQL���
		String sql = "select count(stuid) as totalCount from t_score where 1=1 ";

		// ѧ�Ų�ѯ����
		if (!("".equals(stuNo))) {
			sql += " and stuNo = ? ";
			params.add(stuNo);
		}

		// ִ��SQL���
		db.doPstm(sql, params.toArray());

		// �ӽ������ȡ����������
		ResultSet rs = db.getRs();
		if (rs != null) {
			if (rs.next()) {
				totalCount = rs.getInt("totalCount");// ȡ��ͳ�Ƶ�����
			}
		}

		// ���ؽ��
		return totalCount;
	}

	/**
	 * ɾ��ѧ���ɼ���Ϣ
	 */
	public boolean deleteStudentScore(int sid) {
		// SQL������
		ArrayList params = new ArrayList();

		// ƴ��SQL���
		String sql = "delete t_score where sid = ? ";

		// ѧ�Ų�ѯ����
		params.add(sid);

		try {
			// ִ��SQL���
			db.doPstm(sql, params.toArray());

			//��ȡִ��SQL���Ӱ�������
			int rowCount = db.getCount();
			
			return (rowCount > 0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
