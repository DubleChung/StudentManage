package com.stu.service;

import java.util.List;

import com.stu.model.PageBean;
import com.stu.model.ScoreBean;

/***
 * 成绩信息Service
 * 
 * @author 胡代鑫、邹家华、梁钊伟、曹强
 * 
 */
public interface ScoreService {
	/**
	 * 添加成绩信息
	 * 
	 * @author 胡代鑫
	 * 
	 * @param stuNo 学号
	 * @param course 课程
	 * @param score 成绩
	 * @return
	 */
	boolean addStudentScore(String stuNo, String course, float score);

	/**
	 * 删除成绩信息
	 * 
	 * @author 邹家华
	 * 
	 * @param sid 成绩标识ID
	 * @return
	 */
	boolean deleteStudentScore(int sid);
	
	/**
	 * 查询成绩信息
	 * 
	 * @author 梁钊伟、曹强
	 * 
	 * @param stuNo 学号
	 * @param currentPage 当前页码
	 * @param pageSize 页大小
	 * @return
	 */
	PageBean<ScoreBean> getStudentScore(String stuNo,String stuName,int currentPage,int pageSize);
}
