package com.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.dao.ScoreDao;
import com.stu.model.MessageBean;
import com.stu.model.PageBean;
import com.stu.model.ScoreBean;

/**
 * ѧ���ɼ�Servlet
 * 
 * @author Administrator
 * 
 */
public class ScoreServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ScoreServlet() {
		super();
	}

	/**
	 * ����GET����
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
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		if ("addscore".equals(cmd)) {

			// ������Ӧ��������
			response.setContentType("text/html");
			
			// ���ѧ���ɼ�
			AddStudentScore(request, response);
			
		} else if ("scorelist".equals(cmd)) {

			// ������Ӧ��������
			response.setContentType("text/html");
			
			// ��ѯѧ���ɼ�
			QueryStudentScore(request, response);
			
		} else if ("deletescore".equals(cmd)) {

			// ������Ӧ��������
	        response.setContentType("application/json");
			
			// ɾ��ѧ���ɼ�
			DeleteStudentScore(request, response);
			
		}
	}

	/**
	 * ɾ��ѧ���ɼ�
	 * 
	 * @param request
	 * @param response
	 */
	private void DeleteStudentScore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// �ɼ���ʶID
		int sid = Integer.parseInt(request.getParameter("sid") != null ? request.getParameter("sid") : "0");

		// ʵ����ѧ�����ݿ������
		ScoreDao scoreDao = new ScoreDao();

		// ִ������ɾ��
		boolean result = scoreDao.deleteStudentScore(sid);
	
		//json �����ַ���
		StringBuffer sb = new StringBuffer();
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
	 * ��ѯѧ���ɼ�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void QueryStudentScore(HttpServletRequest request,
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

		// ȡ����ѯ����,���û���ύ��ѯ����,��ֵΪ���ַ���
		//ѧ��
		String stuNo = (request.getParameter("stuNo") != null ? request.getParameter("stuNo") : "");
		//ѧ������
		String stuName = (request.getParameter("stuName") != null ? request.getParameter("stuName") : "");

		// ʵ����ѧ�����ݿ������
		ScoreDao scoreDao = new ScoreDao();
		// ִ�����ݲ�ѯ
		PageBean<ScoreBean> pageBean = scoreDao.getStudentScore(stuNo,stuName,currentPage, pageCount);

		// ��ҳ�洫������
		request.setAttribute("pageBean", pageBean);// ��ҳ���ݶ���
		request.setAttribute("stuName", stuName);// ������ѯ����
		request.setAttribute("stuNo", stuNo);// ѧ�Ų�ѯ����

		// ����ط�
		request.getRequestDispatcher("/views/search_student_score.jsp").forward(request, response);
	}

	/**
	 * ������ɳɼ�
	 * 
	 * @param request
	 * @param response
	 */
	private void AddStudentScore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ѧ��
		String stuNo = (request.getParameter("stuNo") != null ? request.getParameter("stuNo") : "");
		// �γ�
		String course = (request.getParameter("Course") != null ? request.getParameter("Course") : "");
		// �ɼ�
		String scoreStr = request.getParameter("Score") != null ? request.getParameter("Score") : "0";
		if(!Pattern.matches("^\\d+(\\.\\d+)?$", scoreStr))//������ʽ����Ƿ��Ǹ���ֵ
		{
			//����ҳ����ʾ��Ϣ
			request.setAttribute("msg", new MessageBean(0,"����д��ȷ�ĳɼ���ֵ��"));
			// ����ط�
			request.getRequestDispatcher("/views/add_student_score.jsp").forward(request, response);
			return;
		}
		float score = Float.parseFloat(scoreStr);

		// ���ѧ��
		// ʵ����ѧ�����ݿ������
		ScoreDao scoreDao = new ScoreDao();

		// ִ�����ݿ����
		boolean result = scoreDao.addStudentScore(stuNo, course, score);

		// �������ݿⷵ�ؽ��������ҳ����ʾ��Ϣ
		if (result == true) {
			request.setAttribute("msg", new MessageBean(1, "��ӳɹ���"));
		} else {
			request.setAttribute("msg", new MessageBean(0, "���ʧ�ܣ�"));
		}

		// ����ط�
		request.getRequestDispatcher("/views/add_student_score.jsp").forward(request, response);
	}

}
