package com.stu.model;

/**
 * ѧ����
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
	 * ��ȡѧ��
	 * @return
	 */
	public String getStu_no() {
		return stu_no;
	}
	/**
	 * ����ѧ��
	 * @param stu_no
	 */
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	
	/**
	 * ��ȡѧ������
	 * @return
	 */
	public String getStu_name() {
		return stu_name;
	}
	/**
	 * ����ѧ������
	 * @param stu_name
	 */
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	
	/**
	 * ��ȡ�Ա�
	 * @return
	 */
	public String getStu_sex() {
		return stu_sex;
	}
	/**
	 * �����Ա�
	 * @param stu_sex
	 */
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	
	/**
	 * ��ȡ����
	 * @return
	 */
	public int getStu_age() {
		return stu_age;
	}
	/**
	 * ��������
	 * @param stu_age
	 */
	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}
	
	/**
	 * ��ȡ�༶
	 * @return
	 */
	public String getStu_class() {
		return stu_class;
	}
	/**
	 * ���ð༶
	 * @param stu_class
	 */
	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}
	
	/**
	 * ��ȡ�꼶
	 * @return
	 */
	public String getStu_grade() {
		return stu_grade;
	}
	/**
	 * �����꼶
	 * @param stu_grade
	 */
	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}
	
	/**
	 * ��ȡ��ע
	 * @return
	 */
	public String getStu_remark() {
		return stu_remark;
	}
	/**
	 * ���ñ�ע
	 * @param stu_remark
	 */
	public void setStu_remark(String stu_remark) {
		this.stu_remark = stu_remark;
	}
	
}
