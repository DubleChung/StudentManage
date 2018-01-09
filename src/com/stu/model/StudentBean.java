package com.stu.model;

/**
 * 学生类
 * @author 胡代鑫
 *
 */
public class StudentBean {
	private int stuid;
	private String stuName;
	private String stuNo;
	private String cno;
	private String gno;
	private int stuAge;
	private String stuAddr;
	private String stuSex;

	/**
	 * 获取学生标识ID
	 * 
	 * @return
	 */
	public int getStuid() {
		return stuid;
	}

	/**
	 * 设置学生标识ID
	 * 
	 * @param stuid
	 */
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	/**
	 * 获取学生姓名
	 * 
	 * @return
	 */
	public String getStuName() {
		return stuName;
	}

	/**
	 * 设置学生姓名
	 * 
	 * @param stuName
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	/**
	 * 获取学生学号
	 * 
	 * @return
	 */
	public String getStuNo() {
		return stuNo;
	}

	/**
	 * 设置学生学号
	 * 
	 * @param stuNo
	 */
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	/**
	 * 获取学生班级编号
	 * 
	 * @return
	 */
	public String getCno() {
		return cno;
	}

	/**
	 * 设置学生班级编号
	 * 
	 * @param cno
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}

	/**
	 * 获取学生年级编号
	 * 
	 * @return
	 */
	public String getGno() {
		return gno;
	}

	/**
	 * 设置学生年级编号
	 * 
	 * @param gno
	 */
	public void setGno(String gno) {
		this.gno = gno;
	}

	/**
	 * 获取学生年龄
	 * 
	 * @return
	 */
	public int getStuAge() {
		return stuAge;
	}

	/**
	 * 设置学生年龄
	 * 
	 * @param stuAge
	 */
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	/**
	 * 获取学生住址
	 * 
	 * @return
	 */
	public String getStuAddr() {
		return stuAddr;
	}

	/**
	 * 设置学生住址
	 * 
	 * @param stuAddr
	 */
	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}

	/**
	 * 获取学生性别
	 * 
	 * @return
	 */
	public String getStuSex() {
		return stuSex;
	}

	/**
	 * 设置学生性别
	 * 
	 * @param stuSex
	 */
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
}
