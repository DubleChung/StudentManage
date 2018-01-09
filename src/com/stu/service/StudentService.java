package com.stu.service;

import java.util.List;

import com.stu.model.PageBean;
import com.stu.model.StudentBean;

/***
 * ѧ����ϢService
 * @author �����Ρ��޼һ�����ǿ������ΰ
 */
public interface StudentService {
	/***
	 * ���ѧ����Ϣ
	 * 
	 * @param model
	 * @return
	 */
	boolean addStudent(StudentBean model);

	/**
	 * ��ѯѧ����Ϣ
	 * 
	 * @author ��ǿ������ΰ
	 * 
	 * @param model ��ѯ����
	 * @param currentPage ����ҳ��
	 * @param pageCount ҳ��С
	 * @return
	 */
	PageBean<StudentBean> getStudents(StudentBean model,int currentPage,int pageCount);
	
	/**
	 * ����������ѯѧ����Ϣ��ֻѡ10��������
	 * 
	 * @author ������
	 * 
	 * @param stuName ����
	 * @return
	 */
	List getStudents(String stuName);
	
	/**
	 * ɾ��ѧ����Ϣ
	 * 
	 * @author �޼һ�
	 * 
	 * @param stuid
	 * @return
	 */
	boolean deleteStudent(int stuid);
	
	/**
	 * ���ѧ���Ƿ����
	 * 
	 * @author ������
	 * 
	 * @param stuNo
	 * @return
	 */
	boolean checkExists(String stuNo);
}
