package cn.fosu.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ע���û���ʵ���Ǵ���һ��ͬ����session����ֵ����Ϊ��	
		HttpSession session=request.getSession();//ʵ����һ��session��username
			session.setAttribute("username",null);
			
			 response.sendRedirect("../Welcome.jsp");//������ҳ
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		 
	}

	 
}
