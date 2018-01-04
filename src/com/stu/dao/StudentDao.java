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
 * ѧ�������ݿ������
 * 
 * @author Administrator
 * 
 */
public class StudentDao implements StudentService {

	// ʵ�������ݲ�����
	DB db = new DB();

	/**
	 * ����ѧ����Ϣ
	 */
	public boolean addStudent(StudentBean model) {

		// ����Ϊ�շ���ʧ��
		if (model == null)
			return false;

		try {

			// ��ִ��SQL���
			String sql = "insert into t_student(`stuName`,`stuNo`,`cno`,`gno`,`stuAge`,`stuAddr`,`stuSex`) values(?,?,?,?,?,?,?)";

			// SQL����
			Object[] params = { model.getStuName(), model.getStuNo(),
					model.getCno(), model.getGno(), model.getStuAge(),
					model.getStuAddr(), model.getStuSex() };

			// ִ��SQL���
			db.doPstm(sql, params);

			// ��ȡִ��SQL���Ӱ������
			int rowCount = db.getCount();

			// ���Ӱ����������0����ִ�гɹ�������ʧ�ܡ�
			return (rowCount > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			db.close();
		}
		
		// Ĭ��ִ��ʧ��
		return false;
	}

	/**
	 * ��ѯѧ����Ϣ
	 * @param model
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<StudentBean> getStudents(StudentBean model,int currentPage,int pageSize) {

		// ���÷�ҳ����
		PageBean<StudentBean> pageBean = new PageBean<StudentBean>();
		pageBean.setCurrentPage(currentPage);//���õ�ǰҳ��
		pageBean.setPageSize(pageSize);//�����ܴ�С
		
		//��ʼ�����ݽ��
		ArrayList returnList = new ArrayList();

		//SQL������
		ArrayList params = new ArrayList();
		
		// ƴ��SQL���
		String sql = "select * from t_student where 1=1 ";
		if (model != null) {
			//������ѯ����
			if (!("".equals(model.getStuName()))) {
				sql += " and stuName like ? ";
				params.add("%" + model.getStuName() + "%");// ������ģ����ѯ,������ǰ�����%����
			}
			//ѧ�Ų�ѯ����
			if (!("".equals(model.getStuNo()))) {
				sql += " and stuNo = ? ";
				params.add(model.getStuNo());
			}
		}
		
		//��ҳ����
		sql += " limit ?,? ";
		params.add((currentPage - 1) * pageSize);//����ȡ��������
		params.add(pageSize);//ҳ��С

		try {
			// ִ��SQL���
			db.doPstm(sql, params.toArray());

			//��ȡִ�еĽ��
			java.sql.ResultSet rs = db.getRs();
			
			//���������Ƿ���Ч
			if (rs != null) {
				while(rs.next())
				{
					//ʵ����ѧ����Ϣ��
					StudentBean studentBean = new StudentBean();
					
					//�ֱ�ȡ��Ӧ���ֶ�ֵ
					studentBean.setStuid(rs.getInt("stuid"));//ѧ����ʶID
					studentBean.setStuName(rs.getString("stuName"));//����
					studentBean.setStuNo(rs.getString("stuNo"));//ѧ��
					studentBean.setCno(rs.getString("cno"));//�༶��
					studentBean.setGno(rs.getString("gno"));//�꼶��
					studentBean.setStuAge(rs.getInt("stuAge"));//����
					studentBean.setStuAddr(rs.getString("stuAddr"));//סַ
					studentBean.setStuSex(rs.getString("stuSex"));//�Ա�
					
					//���ӵ����صĽ���б���
					returnList.add(studentBean);
				}
				
				//�����ݿ���ͳ������������
				int totalCount = getStudentCount(model);
				
				//���÷�ҳBean�е����������� 
				pageBean.setTotalCount(totalCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			db.close();
		}
		pageBean.setPageData(returnList);//���õ�ǰҳ����
		
		return pageBean;
	}
	
	/**
	 * �����ݿ���ͳ������������
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	private int getStudentCount(StudentBean model) throws SQLException
	{
		//����������
		int totalCount = 0;

		//SQL������
		ArrayList params = new ArrayList();
		
		// ƴ��SQL���
		String sql = "select count(stuid) as totalCount from t_student where 1=1 ";
		if (model != null) {
			//������ѯ����
			if (!("".equals(model.getStuName()))) {
				sql += " and stuName like ? ";
				params.add("%" + model.getStuName() + "%");// ������ģ����ѯ,������ǰ�����%����
			}
			//ѧ�Ų�ѯ����
			if (!("".equals(model.getStuNo()))) {
				sql += " and stuNo = ? ";
				params.add(model.getStuNo());
			}
		}
		
		//ִ��SQL���
		db.doPstm(sql, params.toArray());
		
		//�ӽ������ȡ����������
		ResultSet rs = db.getRs();
		if(rs != null)
		{
			if(rs.next())
			{
				totalCount = rs.getInt("totalCount");//ȡ��ͳ�Ƶ����� 
			}
		}
		
		//���ؽ�� 
		return totalCount;
	}

	/**
	 * ����������ѯѧ����Ϣ��ֻѡ10��������
	 * @param stuName
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List getStudents(String stuName) {
		
		//����б�
		List stuList = new ArrayList<StudentBean>();
		
		//��ִ�е�SQL���
		String sql = "select stuid,stuNo,stuName from t_student ";

		//SQL������
		List params = new ArrayList();
		
		//ƴ��SQL����SQL����
		if(!stuName.isEmpty())
		{
			sql += " where stuName like ?";
			params.add("%" + stuName + "%");//��Ϊ��ģ����ѯ,���԰�ֵ��ǰ�����%
		}
		
		//ֻȡ10������
		sql += " limit 0,10";
		
		try {
			
			//ִ��SQL���
			db.doPstm(sql, params.toArray());
			
			//��ȡִ��SQL��Ľ����
			ResultSet rs = db.getRs();
			
			if(rs != null)
			{
				while(rs.next())
				{
					//ʵ����ѧ����
					StudentBean studentBean = new StudentBean();
					studentBean.setStuid(rs.getInt("stuid"));//ѧ����ʶID 
					studentBean.setStuName(rs.getString("stuName"));//ѧ������
					studentBean.setStuNo(rs.getString("stuNo"));//ѧ��
					
					//���ӵ�����б�
					stuList.add(studentBean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stuList;
	}
}