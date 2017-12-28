package com.stu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员Servlet
 * 
 */
public class AdminServlet extends HttpServlet {

	public AdminServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取客户操作类型action
		// 根据不同的action执行不同的操作
		String action = request.getParameter("action");
		if ("listShow".equals(action)) {
			// TO DO
		}
	}

}
