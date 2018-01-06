package com.stu.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.model.AdminBean;

public class WebFilter implements Filter {
	// 编码名称
	private String encoding;
	// jsp页面正则表达式
	private Pattern jspRegexp;
	// 登录、退出页面正则表达式
	private Pattern loginRegexp;
	// JS CSS 图片等文件正则表达式
	private Pattern mediaRegexp;

	/**
	 * 释放资源
	 */
	public void destroy() {
	}

	/**
	 * 执行过滤
	 */
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		// 转换成ServletRequest
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		// 转换成ServletResponse
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 获取请求的地址
		String servletPath = request.getServletPath();

		// 正则过滤jsp页面请求
		if (!this.mediaRegexp.matcher(servletPath).find()) {

			// 设置请求编码
			request.setCharacterEncoding(this.encoding);

			// 设置响应内容编码
			response.setCharacterEncoding(this.encoding);

			// 非登录、退出页面
			if (!this.loginRegexp.matcher(servletPath).find()) {

				// 获取用户session
				HttpSession session = request.getSession();

				// 获取登录session中的值
				Object obj = session.getAttribute("LoginUser");

				// 如果获取的session值不存在，重新登录
				if (obj == null) {
					// 跳转到登录界面
					request.getRequestDispatcher("/views/login.jsp").forward(
							request, response);
					return;
				} else {

					// 转换成管理员bean
					AdminBean adminBean = (AdminBean) obj;

					// 检查如果用户标识小于1，重新登录
					if (adminBean.getUid() < 1) {
						// 跳转到登录界面
						request.getRequestDispatcher("/views/login.jsp")
								.forward(request, response);
						return;
					}
				}
			}
		}
		// 执行下一过滤器
		chain.doFilter(request, response);
	}

	/**
	 * 初始化
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// 设置编码配置
		this.encoding = filterConfig.getInitParameter("encoding");
		// jsp页面正则表达式
		this.jspRegexp = Pattern.compile("\\.jsp($|\\?)");
		// 登录、退出页面正则表达式
		this.loginRegexp = Pattern.compile("login");
		// JS CSS 图片等文件正则表达式
		this.mediaRegexp = Pattern
				.compile("\\.(css|js|png|jpg|jpeg|jpe|gif|bmp|tga|ico|pns|pdf|woff|eot|ttf)($|\\?)");
	}

}
