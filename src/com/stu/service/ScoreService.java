package com.stu.service;

import java.util.List;

import com.stu.model.Score;

/***
 * �ɼ���ϢService
 * 
 */
public interface ScoreService {
	/***
	 * ��ӳɼ���Ϣ
	 * 
	 * @param model
	 * @return
	 */
	boolean addStudent(Score model);

	/***
	 * ��ѯ�ɼ���Ϣ
	 * 
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List getStudentsScore(String sql, Object[] parameters);

	/***
	 * ��ȡ����ѧ���ɼ���Ϣ
	 * 
	 * @param stu_no
	 * @return
	 */
	Score getStudentScoreByStuNo(String stu_no);

}
