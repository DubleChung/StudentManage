package com.stu.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.core.StringUtils;
import com.stu.dao.StudentDao;
import com.stu.model.MessageBean;
import com.stu.model.PageBean;
import com.stu.model.StudentBean;

/**
 * ѧ����ϢServlet
 * 
 * @author Administrator
 * 
 */
public class StudentServlet extends HttpServlet {

	public StudentServlet() {
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
		response.setContentType("text/html;charset=gbk");

		String cmd = request.getParameter("cmd");
		if ("add".equals(cmd)) {
			// ���ѧ����Ϣ
			AddStudent(request, response);
		} else if ("stulist".equals(cmd)) {
			// ��ѯѧ����Ϣ
			QueryStudents(request, response);
		}
	}
	
	/**
	 * ��ѯѧ����Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void QueryStudents(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ҳ�룬Ĭ��ҳ����1
		int currentPage = Integer.parseInt(request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1");
		// ҳ��С��Ĭ��ҳ��С��10
		int pageCount = Integer.parseInt(request.getParameter("pageCount") != null ? request.getParameter("pageCount") : "10");

		// �Բ��Ϸ���ҳ���ҳ��С���¸�ֵ
		if (currentPage < 1) {
			currentPage = 1;// Ĭ��ҳ����1
		}
		if (pageCount < 10) {
			pageCount = 10;// Ĭ��ҳ��С��10
		}

		//ȡ����ѯ����,���û���ύ��ѯ����,��ֵΪ���ַ���
		String stuName = (request.getParameter("stuName") != null ? request.getParameter("stuName") : "");
		String stuNo = (request.getParameter("stuNo") != null ? request.getParameter("stuNo") : "");
		// ��ʼ����ѯ������
		StudentBean studentBean = new StudentBean();
		studentBean.setStuName(stuName);// ����
		studentBean.setStuNo(stuNo);// ѧ��

		// ʵ����ѧ�����ݿ������
		StudentDao studentDao = new StudentDao();
		// ִ�����ݲ�ѯ
		PageBean<StudentBean> pageBean = studentDao.getStudents(studentBean, currentPage,pageCount);

		// ��ҳ�洫������
		request.setAttribute("pageBean", pageBean);//��ҳ���ݶ���
		request.setAttribute("stuName", stuName);//������ѯ����
		request.setAttribute("stuNo", stuNo);//ѧ�Ų�ѯ����

		// ����ط�
		request.getRequestDispatcher("/views/search_student.jsp").forward(request, response);
	}

	/**
	 * ���ѧ��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AddStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		// ��ȡҳ���ύ�Ĳ���
		String stuName = request.getParameter("stuName");
		String stuNo = request.getParameter("stuNo");
		String cno = request.getParameter("cno");
		String gno = request.getParameter("gno");
		String stuAge = request.getParameter("stuAge");
		String stuAddr = request.getParameter("stuAddr");
		String stuSex = request.getParameter("stuSex");

		// �������
		// �ջ���ַ��ж�,���Ϸ�����
		if (stuName == null || "".equals(stuName)) {
			request.setAttribute("msg", new MessageBean(0, "������������Ϸ������ʧ�ܣ�"));
			request.getRequestDispatcher("/views/add_student.jsp").forward(
					request, response);
			return;
		}
		// �ջ��ַ��ж�,���Ϸ�ѧ��
		if (stuNo == null || "".equals(stuNo)) {
			request.setAttribute("msg", new MessageBean(0, "�����ѧ�Ų��Ϸ������ʧ�ܣ�"));
			request.getRequestDispatcher("/views/add_student.jsp").forward(
					request, response);
			return;
		}
		// �ջ������жϷ�����,���Ϸ�����ֵ
		if (stuAge == null || Pattern.matches("[^\\d]*", stuAge)) {
			request.setAttribute("msg", new MessageBean(0, "��������䲻�Ϸ������ʧ�ܣ�"));
			request.getRequestDispatcher("/views/add_student.jsp").forward(
					request, response);
			return;
		}
		// �ջ���ַ��ж�,���Ϸ��Ա�
		if (stuSex == null || "".equals(stuSex)) {
			request.setAttribute("msg", new MessageBean(0, "������Ա𲻺Ϸ������ʧ�ܣ�"));
			request.getRequestDispatcher("/views/add_student.jsp").forward(
					request, response);
			return;
		}

		// ʵ����ѧ����Ϣ��,���������л�ȡ��Ӧ����ֵ
		StudentBean studentBean = new StudentBean();
		studentBean.setStuName(StringUtils.toChinese(stuName));// ����,ת���˲����ı���ΪGBK����ת�������롣
		studentBean.setStuNo(stuNo);// ѧ��
		studentBean.setCno(StringUtils.toChinese(cno));// �༶���,ת���˲����ı���ΪGBK����ת�������롣
		studentBean.setGno(StringUtils.toChinese(gno));// �꼶���,ת���˲����ı���ΪGBK����ת�������롣
		studentBean.setStuAge(Integer.parseInt(stuAge));// ����
		studentBean.setStuAddr(StringUtils.toChinese(stuAddr));// סַ,ת���˲����ı���ΪGBK����ת�������롣
		studentBean.setStuSex(StringUtils.toChinese(stuSex));// �Ա�,ת���˲����ı���ΪGBK����ת�������롣

		// ���ѧ��
		// ʵ����ѧ�����ݿ������
		StudentDao stuDao = new StudentDao();
		// ִ�����ݿ����
		boolean result = stuDao.addStudent(studentBean);
		// �������ݿⷵ�ؽ������װ��Ϣ
		if (result == true) {
			request.setAttribute("msg", new MessageBean(1, "��ӳɹ���"));
		} else {
			request.setAttribute("msg", new MessageBean(0, "���ʧ�ܣ�"));
		}
		// ִ��ҳ����ת
		request.getRequestDispatcher("/views/add_student.jsp").forward(request,response);
	}

}
