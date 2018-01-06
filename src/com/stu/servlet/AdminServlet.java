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
import com.stu.model.MessageBean;

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
		response.setContentType("text/html");

		// ���ݲ�ͬ��cmdִ�в�ͬ�Ĳ���
		String cmd = request.getParameter("cmd");
		
		if("changpwd".equals(cmd)) {
			//�޸Ĺ���Ա����
			AdminPwdChange(request, response);
		}
	}
	
	/**
	 * �޸Ĺ���Ա����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AdminPwdChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ʵ��������Ա�࣬ȡ����¼���еĲ���ֵ������ֵ����Ӧ������
		AdminBean adminBean = new AdminBean();
		adminBean.setUName(request.getParameter("uName"));//����
		adminBean.setUAccounts(request.getParameter("uAccounts"));//�˺�
		adminBean.setUPassword(request.getParameter("uPassword"));//����
		adminBean.setURemark(request.getParameter("uRemark"));//��ע
		
		AdminDao adminDao = new AdminDao();
		//ִ�����ݿ���²���
		boolean result = adminDao.addAdmin(adminBean);
		
		//�ж�����ִ�н������������Ӧ��ҳ����ʾ��Ϣ
		if(result == true) {
			request.setAttribute("msg", new MessageBean(1,"�޸ĳɹ���"));
		}else{
			request.setAttribute("msg", new MessageBean(0,"�޸�ʧ�ܣ�"));
		}
		
		//��תҳ��
		request.getRequestDispatcher("/views/changepwd.jsp").forward(request, response);
	}


}