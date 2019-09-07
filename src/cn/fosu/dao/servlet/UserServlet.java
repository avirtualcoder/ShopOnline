package cn.fosu.dao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fosu.dao.UserDao;
import cn.fosu.dao.impl.UserDaoImpl;



public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//以utf-8编码接受数据
		request.setCharacterEncoding("utf-8");
		//以utf-8编码响应
		response.setCharacterEncoding("utf-8");
		//通知浏览器，以utf-8编码打开数据
		response.setContentType("text/html;charset=utf-8");
		//获得从浏览器客户端提交过来的数据
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("用户名是："+username+"  密码："+password);
		
		UserDao userDao=new UserDaoImpl();
		//完成保存用户的动作
		userDao.save(username,password);
	
		//转发
		//request.getRequestDispatcher("../index.jsp").forward(request,response);
		//重定向
		response.sendRedirect("../Success.jsp");
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 有两种提交方式：get，post；
		//如果是get方式在doget执行在post中再dopost
		//下方无论何法皆在doget
		doGet(request,response);
	}
}