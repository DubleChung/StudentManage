package com.stu.model;

/**
 * �꼶��
 * 
 * @author Administrator
 * 
 */
public class GradeBean {
	private int gid;
	private String gno;
	private String gName;

	/**
	 * ��ȡ�꼶��ʶID
	 * 
	 * @return
	 */
	public int getGid() {
		return gid;
	}

	/**
	 * �����꼶��ʶID
	 * 
	 * @param gid
	 */
	public void setGid(int gid) {
		this.gid = gid;
	}

	/**
	 * ��ȡ�꼶���
	 * 
	 * @return
	 */
	public String getGno() {
		return gno;
	}

	/**
	 * �����꼶���
	 * 
	 * @param gno
	 */
	public void setGno(String gno) {
		this.gno = gno;
	}

	/**
	 * ��ȡ�꼶����
	 * 
	 * @return
	 */
	public String getGName() {
		return gName;
	}

	/**
	 * �����꼶����
	 * 
	 * @param name
	 */
	public void setGName(String name) {
		gName = name;
	}

}
