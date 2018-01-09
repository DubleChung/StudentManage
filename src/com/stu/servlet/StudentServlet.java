package com.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.core.StringUtils;
import com.stu.dao.ScoreDao;
import com.stu.dao.StudentDao;
import com.stu.model.MessageBean;
import com.stu.model.PageBean;
import com.stu.model.StudentBean;
import com.stu.service.StudentService;

/**
 * ѧ����ϢServlet
 * 
 * @author ����ΰ����ǿ�������Ρ��޼һ�
 * 
 */
public class StudentServlet extends HttpServlet {

	public StudentServlet() {
		super();
	}

	/**
	 * ����GET����
	 * 
	 * @author �޼һ�
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
	 * @author �޼һ�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		if ("add".equals(cmd)) {
			// ���ѧ����Ϣ
			AddStudent(request, response);
		} else if ("stulist".equals(cmd)) {
			// ��ѯѧ����Ϣ
			QueryStudents(request, response);
		} else if("json_stulist".equals(cmd)) {
			//����������ѯѧ����Ϣ
			QueryStudentToJson(request,response);
		} else if("deletestudent".equals(cmd)){
			// ɾ��ѧ����Ϣ
			DeleteStudent(request, response);
		}
	}
	
	/**
	 * ɾ��ѧ����Ϣ
	 * 
	 * @author �޼һ�
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void DeleteStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ������Ӧ��������
        response.setContentType("application/json");
        
		// ѧ����ʶID
		int stuid = Integer.parseInt(request.getParameter("stuid") != null ? request.getParameter("stuid") : "0");

		//json �����ַ���
		StringBuffer sb = new StringBuffer();

		// ʵ����ѧ�����ݿ������
		StudentService studentService = new StudentDao();
		
		// ִ������ɾ��
		boolean result = studentService.deleteStudent(stuid);
		
		//�ж�ѧ��ɾ�����
		if(result == true){
			sb.append("{\"code\":1,\"msg\":\"ɾ���ɹ���\"}");
		}else {
			sb.append("{\"code\":0,\"msg\":\"ɾ��ʧ�ܣ�\"}");
		}
		
        //����json
        PrintWriter out = response.getWriter();
        out.write(sb.toString());
        out.flush();
        out.close();
	}
		
	/**
	 * ��ѯѧ����Ϣ
	 * 
	 * @author ��ǿ������ΰ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void QueryStudents(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// ������Ӧ��������
		response.setContentType("text/html");

		// ҳ�룬Ĭ��ҳ����1
		int currentPage = Integer.parseInt(request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1");
		// ҳ��С��Ĭ��ҳ��С��10
		int pageSize = Integer.parseInt(request.getParameter("pageSize") != null ? request.getParameter("pageSize") : "10");

		// �Բ��Ϸ���ҳ���ҳ��С���¸�ֵ
		if (currentPage < 1) {
			currentPage = 1;// Ĭ��ҳ����1
		}
		if (pageSize < 10) {
			pageSize = 10;// Ĭ��ҳ��С��10
		}

		//ȡ����ѯ����,���û���ύ��ѯ����,��ֵΪ���ַ���
		String stuName = (request.getParameter("stuName") != null ? request.getParameter("stuName") : "").trim();
		String stuNo = (request.getParameter("stuNo") != null ? request.getParameter("stuNo") : "").trim();
		
		if(!stuName.isEmpty()){
			stuName = StringUtils.toChinese(stuName);
		}
		if(!stuNo.isEmpty()){
			stuNo = StringUtils.toChinese(stuNo);
		}
		
		// ��ʼ����ѯ������
		StudentBean studentBean = new StudentBean();
		studentBean.setStuName(stuName);// ����
		studentBean.setStuNo(stuNo);// ѧ��

		// ʵ����ѧ�����ݿ������
		StudentService studentService = new StudentDao();
		
		// ִ�����ݲ�ѯ
		PageBean<StudentBean> pageBean = studentService.getStudents(studentBean, currentPage,pageSize);

		// ��ҳ�洫������
		request.setAttribute("pageBean", pageBean);//��ҳ���ݶ���
		request.setAttribute("stuName", stuName);//������ѯ����
		request.setAttribute("stuNo", stuNo);//ѧ�Ų�ѯ����

		// ����ط�
		request.getRequestDispatcher("/views/search_student.jsp").forward(request, response);
	}

	/**
	 * ����������ѯѧ����Ϣ����ӳɼ���ʱ����
	 * ��ֻѡ10��������
	 * 
	 * @author ������
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void QueryStudentToJson(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// ������Ӧ��������
        response.setContentType("application/json");

		//ȡ����ѯ����,���û���ύ��ѯ����,��ֵΪ���ַ���
		String stuName = (request.getParameter("query") != null ? request.getParameter("query") : "").trim();

		// ʵ����ѧ�����ݿ������
		StudentService studentService = new StudentDao();
		
		// ִ�����ݲ�ѯ
		List stuList = studentService.getStudents(StringUtils.toUTF8(stuName));//ajax post �ύ��������utf8���룬��
		
		//json �����ַ���
		StringBuffer sb = new StringBuffer();

		//��������jquery autocomplete����õ�json�ַ���
		sb.append("{\"query\": \"" + stuName + "\",\"suggestions\":[");
		try {
			if(stuList != null)
			{
				for (int i = 0; i < stuList.size(); i++) {

					//ת����ѧ��ʵ��
					StudentBean studentBean = (StudentBean)stuList.get(i);
					
					//ȡ��ѧ��ʵ���е��ֶ�ֵ
					sb.append("{");//json�ַ�����ͷ
					sb.append(String.format("\"value\":\"%s\"," , studentBean.getStuName()));//����
					sb.append(String.format("\"data\":\"%s\"" , studentBean.getStuNo()));//ѧ��
					sb.append(String.format("%s%s" ,"}" , (i < stuList.size() -1 ? "," : "")));//json �ַ�����βƴ��
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sb.append("]}");
		
        //����json
        PrintWriter out = response.getWriter();
        out.write(sb.toString());
        out.flush();
        out.close();
	}
	
	/**
	 * ���ѧ��
	 * 
	 * @author ������
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AddStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ������Ӧ��������
		response.setContentType("text/html");

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
			
			//����ҳ����ʾ��Ϣ
			request.setAttribute("msg", new MessageBean(0, "������������Ϸ������ʧ�ܣ�"));
			//����ط�
			request.getRequestDispatcher("/views/add_student.jsp").forward(request, response);
			
			return;
		}
		// �ջ��ַ��ж�,���Ϸ�ѧ��
		if (stuNo == null || "".equals(stuNo)) {
			
			//����ҳ����ʾ��Ϣ
			request.setAttribute("msg", new MessageBean(0, "�����ѧ�Ų��Ϸ������ʧ�ܣ�"));
			//����ط�
			request.getRequestDispatcher("/views/add_student.jsp").forward(request, response);
			
			return;
		}
		// �ջ������жϷ�����,���Ϸ�����ֵ
		if (stuAge == null || Pattern.matches("[^\\d]*", stuAge)) {
			
			//����ҳ����ʾ��Ϣ
			request.setAttribute("msg", new MessageBean(0, "��������䲻�Ϸ������ʧ�ܣ�"));
			//����ط�
			request.getRequestDispatcher("/views/add_student.jsp").forward(request, response);
			
			return;
		}
		// �ջ���ַ��ж�,���Ϸ��Ա�
		if (stuSex == null || "".equals(stuSex)) {
			
			//����ҳ����ʾ��Ϣ
			request.setAttribute("msg", new MessageBean(0, "������Ա𲻺Ϸ������ʧ�ܣ�"));
			//����ط�
			request.getRequestDispatcher("/views/add_student.jsp").forward(request, response);
			
			return;
		}

		// ʵ����ѧ����Ϣ��,���������л�ȡ��Ӧ����ֵ
		StudentBean studentBean = new StudentBean();
		studentBean.setStuName(stuName);// ����,ת���˲����ı���ΪGBK����ת�������롣
		studentBean.setStuNo(stuNo);// ѧ��
		studentBean.setCno(cno);// �༶���,ת���˲����ı���ΪGBK����ת�������롣
		studentBean.setGno(gno);// �꼶���,ת���˲����ı���ΪGBK����ת�������롣
		studentBean.setStuAge(Integer.parseInt(stuAge));// ����
		studentBean.setStuAddr(stuAddr);// סַ,ת���˲����ı���ΪGBK����ת�������롣
		studentBean.setStuSex(stuSex);// �Ա�,ת���˲����ı���ΪGBK����ת�������롣
		
		//���ѧ���Ƿ����ظ�
		boolean stuNoExists = new StudentDao().checkExists(stuNo);
		if(stuNoExists == true){
			request.setAttribute("msg", new MessageBean(1, "���ʧ�ܣ�ѧ���ظ���"));
		} else {
			// ִ�����ݿ����
			boolean result = new StudentDao().addStudent(studentBean);
			
			// �������ݿⷵ�ؽ������ҳ����ʾ��Ϣ
			if (result == true) {
				request.setAttribute("msg", new MessageBean(1, "��ӳɹ���"));
			} else {
				request.setAttribute("msg", new MessageBean(0, "���ʧ�ܣ�"));
			}
		}
		// ����ط�
		request.getRequestDispatcher("/views/add_student.jsp").forward(request,response);
	}

}
