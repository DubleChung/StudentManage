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
 * 学生信息Servlet
 * 
 * @author Administrator
 * 
 */
public class StudentServlet extends HttpServlet {

	public StudentServlet() {
		super();
	}

	/**
	 * 处理GET请求
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
	 * 处理POST请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 设置响应内容类型
		response.setContentType("text/html;charset=gbk");

		String cmd = request.getParameter("cmd");
		if ("add".equals(cmd)) {
			// 添加学生信息
			AddStudent(request, response);
		} else if ("stulist".equals(cmd)) {
			// 查询学生信息
			QueryStudents(request, response);
		}
	}
	
	/**
	 * 查询学生信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void QueryStudents(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 页码，默认页码是1
		int currentPage = Integer.parseInt(request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1");
		// 页大小，默认页大小是10
		int pageCount = Integer.parseInt(request.getParameter("pageCount") != null ? request.getParameter("pageCount") : "10");

		// 对不合法的页码和页大小重新赋值
		if (currentPage < 1) {
			currentPage = 1;// 默认页码是1
		}
		if (pageCount < 10) {
			pageCount = 10;// 默认页大小是10
		}

		//取出查询参数,如果没有提交查询参数,则值为空字符串
		String stuName = (request.getParameter("stuName") != null ? request.getParameter("stuName") : "");
		String stuNo = (request.getParameter("stuNo") != null ? request.getParameter("stuNo") : "");
		// 初始化查询参数类
		StudentBean studentBean = new StudentBean();
		studentBean.setStuName(stuName);// 姓名
		studentBean.setStuNo(stuNo);// 学号

		// 实例化学生数据库操作类
		StudentDao studentDao = new StudentDao();
		// 执行数据查询
		PageBean<StudentBean> pageBean = studentDao.getStudents(studentBean, currentPage,pageCount);

		// 向页面传递数据
		request.setAttribute("pageBean", pageBean);//分页数据对象
		request.setAttribute("stuName", stuName);//姓名查询条件
		request.setAttribute("stuNo", stuNo);//学号查询条件

		// 请求回发
		request.getRequestDispatcher("/views/search_student.jsp").forward(request, response);
	}

	/**
	 * 添加学生
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AddStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		// 获取页面提交的参数
		String stuName = request.getParameter("stuName");
		String stuNo = request.getParameter("stuNo");
		String cno = request.getParameter("cno");
		String gno = request.getParameter("gno");
		String stuAge = request.getParameter("stuAge");
		String stuAddr = request.getParameter("stuAddr");
		String stuSex = request.getParameter("stuSex");

		// 参数检查
		// 空或空字符判断,不合法姓名
		if (stuName == null || "".equals(stuName)) {
			request.setAttribute("msg", new MessageBean(0, "输入的姓名不合法，添加失败！"));
			request.getRequestDispatcher("/views/add_student.jsp").forward(
					request, response);
			return;
		}
		// 空或字符判断,不合法学号
		if (stuNo == null || "".equals(stuNo)) {
			request.setAttribute("msg", new MessageBean(0, "输入的学号不合法，添加失败！"));
			request.getRequestDispatcher("/views/add_student.jsp").forward(
					request, response);
			return;
		}
		// 空或正则判断非数字,不合法年龄值
		if (stuAge == null || Pattern.matches("[^\\d]*", stuAge)) {
			request.setAttribute("msg", new MessageBean(0, "输入的年龄不合法，添加失败！"));
			request.getRequestDispatcher("/views/add_student.jsp").forward(
					request, response);
			return;
		}
		// 空或空字符判断,不合法性别
		if (stuSex == null || "".equals(stuSex)) {
			request.setAttribute("msg", new MessageBean(0, "输入的性别不合法，添加失败！"));
			request.getRequestDispatcher("/views/add_student.jsp").forward(
					request, response);
			return;
		}

		// 实例化学生信息类,并从请求中获取对应参数值
		StudentBean studentBean = new StudentBean();
		studentBean.setStuName(StringUtils.toChinese(stuName));// 姓名,转换了参数的编码为GBK，不转会是乱码。
		studentBean.setStuNo(stuNo);// 学号
		studentBean.setCno(StringUtils.toChinese(cno));// 班级编号,转换了参数的编码为GBK，不转会是乱码。
		studentBean.setGno(StringUtils.toChinese(gno));// 年级编号,转换了参数的编码为GBK，不转会是乱码。
		studentBean.setStuAge(Integer.parseInt(stuAge));// 年龄
		studentBean.setStuAddr(StringUtils.toChinese(stuAddr));// 住址,转换了参数的编码为GBK，不转会是乱码。
		studentBean.setStuSex(StringUtils.toChinese(stuSex));// 性别,转换了参数的编码为GBK，不转会是乱码。

		// 添加学生
		// 实例化学生数据库操作类
		StudentDao stuDao = new StudentDao();
		// 执行数据库添加
		boolean result = stuDao.addStudent(studentBean);
		// 根据数据库返回结果，组装消息
		if (result == true) {
			request.setAttribute("msg", new MessageBean(1, "添加成功！"));
		} else {
			request.setAttribute("msg", new MessageBean(0, "添加失败！"));
		}
		// 执行页面跳转
		request.getRequestDispatcher("/views/add_student.jsp").forward(request,response);
	}

}
