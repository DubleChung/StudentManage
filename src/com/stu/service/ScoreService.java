package com.stu.service;

import java.util.List;

import com.stu.model.PageBean;
import com.stu.model.ScoreBean;

/***
 * �ɼ���ϢService
 * 
 */
public interface ScoreService {
	/**
	 * ��ӳɼ���Ϣ
	 * @param stuNo ѧ��
	 * @param course �γ�
	 * @param score �ɼ�
	 * @return
	 */
	boolean addStudentScore(String stuNo, String course, float score);

	/**
	 * ɾ���ɼ���Ϣ
	 * @param sid �ɼ���ʶID
	 * @return
	 */
	boolean deleteStudentScore(int sid);
	
	/**
	 * ��ѯ�ɼ���Ϣ
	 * @param stuNo ѧ��
	 * @param currentPage ��ǰҳ��
	 * @param pageSize ҳ��С
	 * @return
	 */
	PageBean<ScoreBean> getStudentScore(String stuNo,String stuName,int currentPage,int pageSize);
}
