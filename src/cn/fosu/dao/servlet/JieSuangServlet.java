package cn.fosu.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fosu.dao.SP_carInfoDao;
import cn.fosu.dao.impl.SP_carInfoDaoImpl;

public class JieSuangServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=(String)request.getSession().getAttribute("username");
		String sp_car_id =request.getParameter("id");
		SP_carInfoDao sp_carInfoDao=new SP_carInfoDaoImpl();
		sp_carInfoDao.delete(sp_car_id,username );
		System.out.println("username "+username+"  id is "+sp_car_id);
		request.getRequestDispatcher("../SP_car.jsp").forward(request, response);
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	 
	}
 
}
