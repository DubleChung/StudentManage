package com.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;
import com.stu.core.Encrypt;
import com.stu.dao.AdminDao;
import com.stu.model.AdminBean;
import com.stu.model.MessageBean;

/**
 * ����Ա�û�����Servlet
 * 
 * @author ���
 */
public class AdminServlet extends HttpServlet {

	public AdminServlet() {
		super();
	}

	/**
	 * ����GET����
	 * 
	 * @author ���
	 * 
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
	 * 
	 * @author ���
	 * 
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
	 * 
	 * @author ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AdminPwdChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//������
		String newPwd = request.getParameter("newUPassword");
		String reNewPwd = request.getParameter("reNewUPassword");
		//��ȡԭ����
		String uPwd = request.getParameter("uPassword");
		
		//��������Ƿ�Ϊ��ֵ 
		if(newPwd.isEmpty() || reNewPwd.isEmpty())
		{
			//����ҳ����ʾ��Ϣ
			request.setAttribute("msg", new MessageBean(0,"�����벻��Ϊ�գ�"));
			//��תҳ��
			request.getRequestDispatcher("/views/changpwd.jsp").forward(request, response);
			return;
		}
		
		//�����������������Ƿ�һ��
		if(!newPwd.equals(reNewPwd))
		{
			//����ҳ����ʾ��Ϣ
			request.setAttribute("msg", new MessageBean(0,"����������벻һ�£�"));
			//��תҳ��
			request.getRequestDispatcher("/views/changpwd.jsp").forward(request, response);
			return;
		}
		
		//��ȡ��¼��Ϣ
		AdminBean loginUser = (AdminBean)request.getSession().getAttribute("LoginUser");
		
		//ִ�����ݿ���²���
		AdminDao adminDao = new AdminDao();
		boolean result = adminDao.changePassword(loginUser.getUid(),Encrypt.encode(uPwd),Encrypt.encode(newPwd));
		
		//�ж�����ִ�н������������Ӧ��ҳ����ʾ��Ϣ
		if(result == true) {
			request.setAttribute("msg", new MessageBean(1,"�޸ĳɹ���"));
		} else {
			request.setAttribute("msg", new MessageBean(0,"�޸�ʧ�ܣ�"));
		}
		
		//��תҳ��
		request.getRequestDispatcher("/views/changpwd.jsp").forward(request, response);
	}


}