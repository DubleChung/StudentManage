package com.stu.model;

/**
 * 班级类
 * @author Administrator
 *
 */
public class ClassBean {
	private int cid;
	private String cno;
	private String cName;

	/**
	 * 获取班级标识ID
	 * 
	 * @return
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * 设置班级标识 ID
	 * 
	 * @param cid
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * 获取班级编号
	 * 
	 * @return
	 */
	public String getCno() {
		return cno;
	}

	/**
	 * 设置班级编号
	 * 
	 * @param cno
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}

	/**
	 * 获取班级名称
	 * 
	 * @return
	 */
	public String getCName() {
		return cName;
	}

	/**
	 * 设置班级名称
	 * 
	 * @param name
	 */
	public void setCName(String name) {
		cName = name;
	}

}
