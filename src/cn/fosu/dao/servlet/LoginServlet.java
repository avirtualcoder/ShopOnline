package cn.fosu.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.fosu.dao.UserDao;
import cn.fosu.dao.impl.UserDaoImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				PrintWriter outPrintWriter=response.getWriter();
				outPrintWriter.write("111111");
				//得到用户名和密码
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				
				UserDao u_dao=new UserDaoImpl();
				boolean login =u_dao.LoginUsername(username, password);
				
				
				
				//jsp四大作用域
				/*
				 * 1、page：当前页面————数据仅仅在当前页面可以访问
				 * 2、request：当次记录
				 * 3、session：当次对话，如果对浏览器没有关闭，都可以访问到数据，保存在服务器端
				 * 4、application：整个项目
				 * 
				 * */
				
				if(login){
					response.sendRedirect("../Welcome.jsp");
					//将登陆成功的用户名保存到Session中
					HttpSession session=request.getSession();//实例化一个Session对象
					session.setAttribute("username",username);
				}else{
					response.sendRedirect("../Login.jsp");
		
				}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
		
	}


}
