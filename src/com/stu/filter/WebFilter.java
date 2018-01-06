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
	// ��������
	private String encoding;
	// jspҳ��������ʽ
	private Pattern jspRegexp;
	// ��¼���˳�ҳ��������ʽ
	private Pattern loginRegexp;
	// JS CSS ͼƬ���ļ�������ʽ
	private Pattern mediaRegexp;

	/**
	 * �ͷ���Դ
	 */
	public void destroy() {
	}

	/**
	 * ִ�й���
	 */
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		// ת����ServletRequest
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		// ת����ServletResponse
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// ��ȡ����ĵ�ַ
		String servletPath = request.getServletPath();

		// �������jspҳ������
		if (!this.mediaRegexp.matcher(servletPath).find()) {

			// �����������
			request.setCharacterEncoding(this.encoding);

			// ������Ӧ���ݱ���
			response.setCharacterEncoding(this.encoding);

			// �ǵ�¼���˳�ҳ��
			if (!this.loginRegexp.matcher(servletPath).find()) {

				// ��ȡ�û�session
				HttpSession session = request.getSession();

				// ��ȡ��¼session�е�ֵ
				Object obj = session.getAttribute("LoginUser");

				// �����ȡ��sessionֵ�����ڣ����µ�¼
				if (obj == null) {
					// ��ת����¼����
					request.getRequestDispatcher("/views/login.jsp").forward(
							request, response);
					return;
				} else {

					// ת���ɹ���Աbean
					AdminBean adminBean = (AdminBean) obj;

					// �������û���ʶС��1�����µ�¼
					if (adminBean.getUid() < 1) {
						// ��ת����¼����
						request.getRequestDispatcher("/views/login.jsp")
								.forward(request, response);
						return;
					}
				}
			}
		}
		// ִ����һ������
		chain.doFilter(request, response);
	}

	/**
	 * ��ʼ��
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// ���ñ�������
		this.encoding = filterConfig.getInitParameter("encoding");
		// jspҳ��������ʽ
		this.jspRegexp = Pattern.compile("\\.jsp($|\\?)");
		// ��¼���˳�ҳ��������ʽ
		this.loginRegexp = Pattern.compile("login");
		// JS CSS ͼƬ���ļ�������ʽ
		this.mediaRegexp = Pattern
				.compile("\\.(css|js|png|jpg|jpeg|jpe|gif|bmp|tga|ico|pns|pdf|woff|eot|ttf)($|\\?)");
	}

}
