package com.stu.model;

/**
 * 消息类
 * @author 邹家华
 *
 */
public class MessageBean {
	private int code;
	private String content;
	
	/**
	 * 无参构造函数
	 */
	public MessageBean()
	{
		this.setCode(0);
		this.setContent("");
	}
	/**
	 * 有参构造函数
	 * @param _code 消息代码
	 * @param _content 消息内容
	 */
	public MessageBean(int _code,String _content)
	{
		this.setCode(_code);
		this.setContent(_content);
	}
	
	/**
	 * 获取消息代码
	 * @return
	 */
	public int getCode() {
		return code;
	}
	/**
	 * 设置消息代码
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * 获取消息内容
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置消息内容
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
