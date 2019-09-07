package cn.fosu.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fosu.dao.SP_carDao;
import cn.fosu.dao.impl.SP_carDaoImpl;

public class SP_carServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String sp_car_id =request.getParameter("id");
			String sp_car_user=(String)request.getSession().getAttribute("username");
			String number=request.getParameter("number");
			SP_carDao sp_carDao=new SP_carDaoImpl();
			System.out.println("id is "+sp_car_id+" username is "+sp_car_user+" number is "+number);
			if(sp_car_user!=null){
			boolean flag=sp_carDao.findSP_car(sp_car_id, sp_car_user);
			if(flag){
				sp_carDao.updateSP_car( number, sp_car_id, sp_car_user);
			}else{
				sp_carDao.addSP_car(sp_car_id, number, sp_car_user);
			}
				response.sendRedirect("../servlet/SP_carInfoServlet");
			}else{
				response.sendRedirect("../Login.jsp");
			}
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	 
	}

	 

}
