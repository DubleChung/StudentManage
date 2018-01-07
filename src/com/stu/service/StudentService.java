package com.stu.service;

import java.util.List;

import com.stu.model.PageBean;
import com.stu.model.StudentBean;

/***
 * ѧ����ϢService
 * 
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
	 * @param model ��ѯ����
	 * @param currentPage ����ҳ��
	 * @param pageCount ҳ��С
	 * @return
	 */
	PageBean<StudentBean> getStudents(StudentBean model,int currentPage,int pageCount);
	
	/**
	 * ����������ѯѧ����Ϣ��ֻѡ10��������
	 * @param stuName ����
	 * @return
	 */
	List getStudents(String stuName);
	
	/**
	 * ɾ��ѧ����Ϣ
	 * @param stuid
	 * @return
	 */
	boolean deleteStudent(int stuid);
	
	/**
	 * ���ѧ���Ƿ����
	 * @param stuNo
	 * @return
	 */
	boolean checkExists(String stuNo);
}
