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
 * 学生成绩Servlet
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
	 * 处理GET请求
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
	 * 处理POST请求
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

			// 设置响应内容类型
			response.setContentType("text/html");
			
			// 添加学生成绩
			AddStudentScore(request, response);
			
		} else if ("scorelist".equals(cmd)) {

			// 设置响应内容类型
			response.setContentType("text/html");
			
			// 查询学生成绩
			QueryStudentScore(request, response);
			
		} else if ("deletescore".equals(cmd)) {

			// 设置响应内容类型
	        response.setContentType("application/json");
			
			// 删除学生成绩
			DeleteStudentScore(request, response);
			
		}
	}

	/**
	 * 删除学生成绩
	 * 
	 * @param request
	 * @param response
	 */
	private void DeleteStudentScore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 成绩标识ID
		int sid = Integer.parseInt(request.getParameter("sid") != null ? request.getParameter("sid") : "0");

		// 实例化学生数据库操作类
		ScoreDao scoreDao = new ScoreDao();

		// 执行数据删除
		boolean result = scoreDao.deleteStudentScore(sid);
	
		//json 数据字符串
		StringBuffer sb = new StringBuffer();
		if(result == true){
			sb.append("{\"code\":1,\"msg\":\"删除成功！\"}");
		}else {
			sb.append("{\"code\":0,\"msg\":\"删除失败！\"}");
		}
		
        //返回json
        PrintWriter out = response.getWriter();
        out.write(sb.toString());
        out.flush();
        out.close();
	}

	/**
	 * 查询学生成绩
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void QueryStudentScore(HttpServletRequest request,
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

		// 取出查询参数,如果没有提交查询参数,则值为空字符串
		//学号
		String stuNo = (request.getParameter("stuNo") != null ? request.getParameter("stuNo") : "");
		//学生姓名
		String stuName = (request.getParameter("stuName") != null ? request.getParameter("stuName") : "");

		// 实例化学生数据库操作类
		ScoreDao scoreDao = new ScoreDao();
		// 执行数据查询
		PageBean<ScoreBean> pageBean = scoreDao.getStudentScore(stuNo,stuName,currentPage, pageCount);

		// 向页面传递数据
		request.setAttribute("pageBean", pageBean);// 分页数据对象
		request.setAttribute("stuName", stuName);// 姓名查询条件
		request.setAttribute("stuNo", stuNo);// 学号查询条件

		// 请求回发
		request.getRequestDispatcher("/views/search_student_score.jsp").forward(request, response);
	}

	/**
	 * 添加生成成绩
	 * 
	 * @param request
	 * @param response
	 */
	private void AddStudentScore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 学号
		String stuNo = (request.getParameter("stuNo") != null ? request.getParameter("stuNo") : "");
		// 课程
		String course = (request.getParameter("Course") != null ? request.getParameter("Course") : "");
		// 成绩
		String scoreStr = request.getParameter("Score") != null ? request.getParameter("Score") : "0";
		if(!Pattern.matches("^\\d+(\\.\\d+)?$", scoreStr))//正则表达式检查是否是浮点值
		{
			//设置页面提示消息
			request.setAttribute("msg", new MessageBean(0,"请填写正确的成绩数值！"));
			// 请求回发
			request.getRequestDispatcher("/views/add_student_score.jsp").forward(request, response);
			return;
		}
		float score = Float.parseFloat(scoreStr);

		// 添加学生
		// 实例化学生数据库操作类
		ScoreDao scoreDao = new ScoreDao();

		// 执行数据库添加
		boolean result = scoreDao.addStudentScore(stuNo, course, score);

		// 根据数据库返回结果，设置页面提示消息
		if (result == true) {
			request.setAttribute("msg", new MessageBean(1, "添加成功！"));
		} else {
			request.setAttribute("msg", new MessageBean(0, "添加失败！"));
		}

		// 请求回发
		request.getRequestDispatcher("/views/add_student_score.jsp").forward(request, response);
	}

}
