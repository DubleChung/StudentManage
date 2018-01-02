package com.stu.service;


import java.util.List;

import com.stu.model.CourseBean;

/**
 * 课程Service
 * 
 */
public interface CoursesService {

	/**
	 * 添加课程信息
	 * 
	 * @param model
	 * @return
	 */
	boolean addCourses(CourseBean model);

	/**
	 * 查询多个课程信息
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List getCourses(String sql, Object[] parameters);

	/**
	 * 查询单个课程信息
	 * 
	 * @param cs_no
	 * @return
	 */
	CourseBean getCoursesByNo(String cs_no);
}
