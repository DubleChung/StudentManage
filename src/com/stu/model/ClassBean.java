package com.stu.model;

/**
 * �༶��
 * @author Administrator
 *
 */
public class ClassBean {
	private int cid;
	private String cno;
	private String cName;

	/**
	 * ��ȡ�༶��ʶID
	 * 
	 * @return
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * ���ð༶��ʶ ID
	 * 
	 * @param cid
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * ��ȡ�༶���
	 * 
	 * @return
	 */
	public String getCno() {
		return cno;
	}

	/**
	 * ���ð༶���
	 * 
	 * @param cno
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}

	/**
	 * ��ȡ�༶����
	 * 
	 * @return
	 */
	public String getCName() {
		return cName;
	}

	/**
	 * ���ð༶����
	 * 
	 * @param name
	 */
	public void setCName(String name) {
		cName = name;
	}

}
