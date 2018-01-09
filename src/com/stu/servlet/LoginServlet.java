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
import com.stu.service.AdminService;

/**
 * 用户登录、退出操作Servlet
 * 
 * @author 夏宇航
 *
 */
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 用户退出
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

		// 根据不同的cmd执行不同的操作
		String cmd = request.getParameter("cmd");
		
		if ("login".equals(cmd)) {
			//管理员用户登录
			AdminLogin(request, response);
		} else if("login_out".equals(cmd)) {
			//用户退出
            AdminLoginOut(request, response); 
		}
	}

	/**
	 * 用户登录
	 * 
	 * @author 夏宇航
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AdminLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置响应内容类型
		response.setContentType("text/html");
		
		// 实例化管理员类，取出登录表单中的参数值，并赋值给相应的属性
		AdminBean adminBean = new AdminBean();
		adminBean.setUAccounts(request.getParameter("uAccounts"));
		adminBean.setUPassword(Encrypt.encode(request.getParameter("uPassword")));

		AdminService adminService = new AdminDao();
		// 执行数据库查询验证
		AdminBean loginBean = adminService.adminLogin(adminBean);
		if (loginBean != null && loginBean.getUid() > 0) {
			
			// 登录验证成功，把用户信息写入到Session
			HttpSession session = request.getSession(true);  
		    
			//设置过期时间为3600秒（1个小时）
			session.setMaxInactiveInterval(3600);
		    
			//账号信息保存到Session
		    session.setAttribute("LoginUser",loginBean);
		    
		    //跳转到首页
		    request.getRequestDispatcher("/views/index.jsp").forward(request, response); 
		    
		}else{
			
			//设置页面提示消息
			request.setAttribute("msg", new MessageBean(0,"用户名或密码错误！"));
			
			//跳转到首页
		    request.getRequestDispatcher("/views/login.jsp").forward(request, response); 
		}
	}

	/**
	 * 用户退出
	 * 
	 * @author 夏宇航
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void AdminLoginOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置响应内容类型
		response.setContentType("text/html");
		
		//清除登录信息
		request.getSession().removeAttribute("LoginUser");
		
		//跳转到首页
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}
}
