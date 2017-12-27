package com.stu.service;


import java.util.List;

import com.stu.model.Courses;

/**
 * �γ�Service
 * 
 */
public interface CoursesService {

	/**
	 * ��ӿγ���Ϣ
	 * 
	 * @param model
	 * @return
	 */
	boolean addCourses(Courses model);

	/**
	 * ��ѯ����γ���Ϣ
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List getCourses(String sql, Object[] parameters);

	/**
	 * ��ѯ�����γ���Ϣ
	 * 
	 * @param cs_no
	 * @return
	 */
	Courses getCoursesByNo(String cs_no);
}
