package com.stu.service;


import java.util.List;

import com.stu.model.CourseBean;

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
	boolean addCourses(CourseBean model);

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
	CourseBean getCoursesByNo(String cs_no);
}
