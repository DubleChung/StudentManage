package com.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stu.core.Encrypt;
import com.stu.dao.AdminDao;
import com.stu.model.AdminBean;

/**
 * ����ԱServlet
 * 
 */
public class AdminServlet extends HttpServlet {

	public AdminServlet() {
		super();
	}

	/**
	 * ����GET����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ������Ӧ��������
		response.setContentType("text/html;charset=gbk");

		doPost(request, response);
	}

	/**
	 * ����POST����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ������Ӧ��������
		response.setContentType("text/html;charset=gbk");

		// ��ȡ�ͻ���������action
		// ���ݲ�ͬ��cmdִ�в�ͬ�Ĳ���
		String cmd = request.getParameter("cmd");
		
		
		if ("login".equals(cmd)) {//�����û���¼

			// ʵ��������Ա�࣬ȡ����¼���еĲ���ֵ������ֵ����Ӧ������
			AdminBean adminBean = new AdminBean();
			adminBean.setUAccounts(request.getParameter("uAccounts"));
			adminBean.setUPassword(Encrypt.encode(request.getParameter("uPassword")));

			// ִ�����ݿ��ѯ��֤
			AdminDao adminDao = new AdminDao();
			AdminBean loginBean = adminDao.adminLogin(adminBean);
			if (loginBean != null && loginBean.getUid() > 0) {
				// ��¼��֤�ɹ������û���Ϣд�뵽Session
				HttpSession hs = request.getSession(true);  
	            hs.setMaxInactiveInterval(3600);//���ù���ʱ��Ϊ3600�루1��Сʱ��
	            hs.setAttribute("LoginUser",loginBean);//�˺���Ϣ���浽Session
	            
	            request.getRequestDispatcher("index.jsp").forward(request, response); //����ҳ
			}else{
				request.setAttribute("ErrMsg", "�û������������");
	            request.getRequestDispatcher("/views/login.jsp").forward(request, response); //����ҳ
			}
		} else if("changpwd".equals(cmd))//�޸Ĺ���Ա����
		{
			// ʵ��������Ա�࣬ȡ����¼���еĲ���ֵ������ֵ����Ӧ������
			AdminBean adminBean = new AdminBean();
			adminBean.setUPassword(request.getParameter("uName"));//����
			adminBean.setUAccounts(request.getParameter("uAccounts"));//�˺�
			adminBean.setUPassword(request.getParameter("uPassword"));//����
			adminBean.setUPassword(request.getParameter("uRemark"));//��ע
			
			AdminDao adminDao = new AdminDao();
			boolean result = adminDao.addAdmin(adminBean);
			
		}
	}

}