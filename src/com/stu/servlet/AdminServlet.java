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
 * 管理员用户操作Servlet
 * 
 * @author 夏宇航
 */
public class AdminServlet extends HttpServlet {

	public AdminServlet() {
		super();
	}

	/**
	 * 处理GET请求
	 * 
	 * @author 夏宇航
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
	 * @author 夏宇航
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置响应内容类型
		response.setContentType("text/html");

		// 根据不同的cmd执行不同的操作
		String cmd = request.getParameter("cmd");
		
		if("changpwd".equals(cmd)) {
			//修改管理员密码
			AdminPwdChange(request, response);
		}
	}
	
	/**
	 * 修改管理员密码
	 * 
	 * @author 夏宇航
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AdminPwdChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//新密码
		String newPwd = request.getParameter("newUPassword");
		String reNewPwd = request.getParameter("reNewUPassword");
		//获取原密码
		String uPwd = request.getParameter("uPassword");
		
		//检查密码是否为空值 
		if(newPwd.isEmpty() || reNewPwd.isEmpty())
		{
			//设置页面提示消息
			request.setAttribute("msg", new MessageBean(0,"新密码不能为空！"));
			//跳转页面
			request.getRequestDispatcher("/views/changpwd.jsp").forward(request, response);
			return;
		}
		
		//检查两次输入的密码是否一致
		if(!newPwd.equals(reNewPwd))
		{
			//设置页面提示消息
			request.setAttribute("msg", new MessageBean(0,"两输入的密码不一致！"));
			//跳转页面
			request.getRequestDispatcher("/views/changpwd.jsp").forward(request, response);
			return;
		}
		
		//获取登录信息
		AdminBean loginUser = (AdminBean)request.getSession().getAttribute("LoginUser");
		
		//执行数据库更新操作
		AdminDao adminDao = new AdminDao();
		boolean result = adminDao.changePassword(loginUser.getUid(),Encrypt.encode(uPwd),Encrypt.encode(newPwd));
		
		//判断数据执行结果，并设置相应的页面提示消息
		if(result == true) {
			request.setAttribute("msg", new MessageBean(1,"修改成功！"));
		} else {
			request.setAttribute("msg", new MessageBean(0,"修改失败！"));
		}
		
		//跳转页面
		request.getRequestDispatcher("/views/changpwd.jsp").forward(request, response);
	}


}