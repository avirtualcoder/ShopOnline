package cn.fosu.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fosu.dao.UserDao;
import cn.fosu.dao.impl.UserDaoImpl;

public class UserAjaxServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//获得ajax传输过来的数据
		String username = request.getParameter("username");
		
		System.out.println("用户名："+username);
		
		UserDao userdao = new UserDaoImpl();
		boolean reg = userdao.findByUsername(username);
		if(reg){
			out.write("true");
			System.out.println("可以注册！");
		}else{
			out.write("false");
			System.out.println("用户已存在！");
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	
	}


}
