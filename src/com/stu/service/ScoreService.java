package com.stu.service;

import java.util.List;

import com.stu.model.Score;

/***
 * 成绩信息Service
 * 
 */
public interface ScoreService {
	/***
	 * 添加成绩信息
	 * 
	 * @param model
	 * @return
	 */
	boolean addStudent(Score model);

	/***
	 * 查询成绩信息
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List getStudentsScore(String sql, Object[] parameters);

	/***
	 * 获取单个学生成绩信息
	 * 
	 * @param stu_no
	 * @return
	 */
	Score getStudentScoreByStuNo(String stu_no);

}
