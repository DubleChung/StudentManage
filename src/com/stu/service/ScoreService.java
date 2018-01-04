package com.stu.service;

import java.util.List;

import com.stu.model.PageBean;
import com.stu.model.ScoreBean;

/***
 * 成绩信息Service
 * 
 */
public interface ScoreService {
	/**
	 * 添加成绩信息
	 * @param stuNo 学号
	 * @param course 课程
	 * @param score 成绩
	 * @return
	 */
	boolean addStudentScore(String stuNo, String course, float score);

	/**
	 * 删除成绩信息
	 * @param sid 成绩标识ID
	 * @return
	 */
	boolean deleteStudentScore(int sid);
	
	/**
	 * 查询成绩信息
	 * @param stuNo 学号
	 * @param currentPage 当前页码
	 * @param pageSize 页大小
	 * @return
	 */
	PageBean<ScoreBean> getStudentScore(String stuNo,String stuName,int currentPage,int pageSize);
}
