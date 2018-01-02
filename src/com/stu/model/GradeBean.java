package com.stu.model;

/**
 * 年级类
 * 
 * @author Administrator
 * 
 */
public class GradeBean {
	private int gid;
	private String gno;
	private String gName;

	/**
	 * 获取年级标识ID
	 * 
	 * @return
	 */
	public int getGid() {
		return gid;
	}

	/**
	 * 设置年级标识ID
	 * 
	 * @param gid
	 */
	public void setGid(int gid) {
		this.gid = gid;
	}

	/**
	 * 获取年级编号
	 * 
	 * @return
	 */
	public String getGno() {
		return gno;
	}

	/**
	 * 设置年级编号
	 * 
	 * @param gno
	 */
	public void setGno(String gno) {
		this.gno = gno;
	}

	/**
	 * 获取年级名称
	 * 
	 * @return
	 */
	public String getGName() {
		return gName;
	}

	/**
	 * 设置年级名称
	 * 
	 * @param name
	 */
	public void setGName(String name) {
		gName = name;
	}

}
