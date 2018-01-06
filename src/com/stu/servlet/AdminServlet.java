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
 * 管理员Servlet
 * 
 */
public class AdminServlet extends HttpServlet {

	public AdminServlet() {
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
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AdminPwdChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 实例化管理员类，取出登录表单中的参数值，并赋值给相应的属性
		AdminBean adminBean = new AdminBean();
		adminBean.setUName(request.getParameter("uName"));//姓名
		adminBean.setUAccounts(request.getParameter("uAccounts"));//账号
		adminBean.setUPassword(request.getParameter("uPassword"));//密码
		adminBean.setURemark(request.getParameter("uRemark"));//备注
		
		AdminDao adminDao = new AdminDao();
		//执行数据库更新操作
		boolean result = adminDao.addAdmin(adminBean);
		
		//判断数据执行结果，并设置相应的页面提示消息
		if(result == true) {
			request.setAttribute("msg", new MessageBean(1,"修改成功！"));
		}else{
			request.setAttribute("msg", new MessageBean(0,"修改失败！"));
		}
		
		//跳转页面
		request.getRequestDispatcher("/views/changepwd.jsp").forward(request, response);
	}


}