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
	 * �ͷ���Դ
	 */
	public void destroy() {
		this.filterConfig = null;
	}

	/**
	 * ִ�й���
	 */
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		// ת����ServletRequest
		HttpServletRequest request = (HttpServletRequest) servletResponse;
		
		//ת����ServletResponse
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		//�����������
		request.setCharacterEncoding("gbk");
		
		//������Ӧ����
		response.setCharacterEncoding("");
		
		// ��ȡ�û�session
		HttpSession session = request.getSession();
		
		// ��ȡ��¼session�е�ֵ
		Object obj = session.getAttribute("LoginUser");
		
		//�����ȡ��sessionֵ�����ڣ����µ�¼
		if (obj == null) {
			// ��ת����¼����
			request.getRequestDispatcher("/views/login.jsp").forward(request,response);
			return;
		}else{
			
			//ת���ɹ���Աbean
			AdminBean adminBean = (AdminBean)obj;
			
			//�������û���ʶС��1�����µ�¼
			if(adminBean.getUid() < 1){
				// ��ת����¼����
				request.getRequestDispatcher("/views/login.jsp").forward(request,response);
				return;
			}
		}
	}

	/**
	 * ��ʼ��
	 */
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
	}

}
