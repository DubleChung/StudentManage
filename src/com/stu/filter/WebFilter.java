package com.stu.filter;

import java.io.IOException;

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
	private FilterConfig filterConfig;

	/**
	 * 释放资源
	 */
	public void destroy() {
		this.filterConfig = null;
	}

	/**
	 * 执行过滤
	 */
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		// 转换成ServletRequest
		HttpServletRequest request = (HttpServletRequest) servletResponse;
		
		//转换成ServletResponse
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		//设置请求编码
		request.setCharacterEncoding("gbk");
		
		//设置响应编码
		response.setCharacterEncoding("");
		
		// 获取用户session
		HttpSession session = request.getSession();
		
		// 获取登录session中的值
		Object obj = session.getAttribute("LoginUser");
		
		//如果获取的session值不存在，重新登录
		if (obj == null) {
			// 跳转到登录界面
			request.getRequestDispatcher("/views/login.jsp").forward(request,response);
			return;
		}else{
			
			//转换成管理员bean
			AdminBean adminBean = (AdminBean)obj;
			
			//检查如果用户标识小于1，重新登录
			if(adminBean.getUid() < 1){
				// 跳转到登录界面
				request.getRequestDispatcher("/views/login.jsp").forward(request,response);
				return;
			}
		}
	}

	/**
	 * 初始化
	 */
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
	}

}
