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

		// 设置响应内容类型
		response.setContentType("text/html;charset=gbk");

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

		// 获取客户操作类型action
		// 根据不同的cmd执行不同的操作
		String cmd = request.getParameter("cmd");
		
		
		if ("login".equals(cmd)) {//管理用户登录

			// 实例化管理员类，取出登录表单中的参数值，并赋值给相应的属性
			AdminBean adminBean = new AdminBean();
			adminBean.setUAccounts(request.getParameter("uAccounts"));
			adminBean.setUPassword(Encrypt.encode(request.getParameter("uPassword")));

			// 执行数据库查询验证
			AdminDao adminDao = new AdminDao();
			AdminBean loginBean = adminDao.adminLogin(adminBean);
			if (loginBean != null && loginBean.getUid() > 0) {
				// 登录验证成功，把用户信息写入到Session
				HttpSession hs = request.getSession(true);  
	            hs.setMaxInactiveInterval(3600);//设置过期时间为3600秒（1个小时）
	            hs.setAttribute("LoginUser",loginBean);//账号信息保存到Session
	            
	            request.getRequestDispatcher("index.jsp").forward(request, response); //到首页
			}else{
				request.setAttribute("ErrMsg", "用户名或密码错误！");
	            request.getRequestDispatcher("/views/login.jsp").forward(request, response); //到首页
			}
		} else if("changpwd".equals(cmd))//修改管理员密码
		{
			// 实例化管理员类，取出登录表单中的参数值，并赋值给相应的属性
			AdminBean adminBean = new AdminBean();
			adminBean.setUPassword(request.getParameter("uName"));//姓名
			adminBean.setUAccounts(request.getParameter("uAccounts"));//账号
			adminBean.setUPassword(request.getParameter("uPassword"));//密码
			adminBean.setUPassword(request.getParameter("uRemark"));//备注
			
			AdminDao adminDao = new AdminDao();
			boolean result = adminDao.addAdmin(adminBean);
			
		}
	}

}