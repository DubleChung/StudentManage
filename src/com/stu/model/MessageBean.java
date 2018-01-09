package com.stu.model;

/**
 * ��Ϣ��
 * @author �޼һ�
 *
 */
public class MessageBean {
	private int code;
	private String content;
	
	/**
	 * �޲ι��캯��
	 */
	public MessageBean()
	{
		this.setCode(0);
		this.setContent("");
	}
	/**
	 * �вι��캯��
	 * @param _code ��Ϣ����
	 * @param _content ��Ϣ����
	 */
	public MessageBean(int _code,String _content)
	{
		this.setCode(_code);
		this.setContent(_content);
	}
	
	/**
	 * ��ȡ��Ϣ����
	 * @return
	 */
	public int getCode() {
		return code;
	}
	/**
	 * ������Ϣ����
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * ��ȡ��Ϣ����
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * ������Ϣ����
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
