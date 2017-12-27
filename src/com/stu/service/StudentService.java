package com.stu.service;

import java.util.List;

import com.stu.model.Student;

/***
 * 学生信息Service
 * 
 */
public interface StudentService {
	/***
	 * 添加学生信息
	 * 
	 * @param model
	 * @return
	 */
	boolean addStudent(Student model);

	/***
	 * 查询学生信息
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List getStudents(String sql, Object[] parameters);

	/***
	 * 获取单个学生信息
	 * 
	 * @param stu_no
	 * @return
	 */
	Student getStudentByStuNo(String stu_no);

}
