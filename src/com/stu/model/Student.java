package com.stu.model;

/**
 * 学生类
 * @author 
 *
 */
public class Student {
	private String stu_no;
	private String stu_name;
	private String stu_sex;
	private int stu_age;
	private String stu_class;
	private String stu_grade;
	private String stu_remark;
	
	/**
	 * 获取学号
	 * @return
	 */
	public String getStu_no() {
		return stu_no;
	}
	/**
	 * 设置学号
	 * @param stu_no
	 */
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	
	/**
	 * 获取学生姓名
	 * @return
	 */
	public String getStu_name() {
		return stu_name;
	}
	/**
	 * 设置学生姓名
	 * @param stu_name
	 */
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	
	/**
	 * 获取性别
	 * @return
	 */
	public String getStu_sex() {
		return stu_sex;
	}
	/**
	 * 设置性别
	 * @param stu_sex
	 */
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	
	/**
	 * 获取年龄
	 * @return
	 */
	public int getStu_age() {
		return stu_age;
	}
	/**
	 * 设置年龄
	 * @param stu_age
	 */
	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}
	
	/**
	 * 获取班级
	 * @return
	 */
	public String getStu_class() {
		return stu_class;
	}
	/**
	 * 设置班级
	 * @param stu_class
	 */
	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}
	
	/**
	 * 获取年级
	 * @return
	 */
	public String getStu_grade() {
		return stu_grade;
	}
	/**
	 * 设置年级
	 * @param stu_grade
	 */
	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}
	
	/**
	 * 获取备注
	 * @return
	 */
	public String getStu_remark() {
		return stu_remark;
	}
	/**
	 * 设置备注
	 * @param stu_remark
	 */
	public void setStu_remark(String stu_remark) {
		this.stu_remark = stu_remark;
	}
	
}
