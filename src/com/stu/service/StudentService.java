package com.stu.service;

import java.util.List;

import com.stu.model.Student;

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
	boolean addStudent(Student model);

	/***
	 * ��ѯѧ����Ϣ
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List getStudents(String sql, Object[] parameters);

	/***
	 * ��ȡ����ѧ����Ϣ
	 * 
	 * @param stu_no
	 * @return
	 */
	Student getStudentByStuNo(String stu_no);

}
