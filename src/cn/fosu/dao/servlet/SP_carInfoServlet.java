package cn.fosu.dao.servlet;

import java.io.IOException;
import cn.fosu.dao.SP_carInfoDao;
import cn.fosu.javabean.SP_car_info;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fosu.dao.SP_carInfoDao;
import cn.fosu.dao.impl.SP_carInfoDaoImpl;
import cn.fosu.dao.SP_carInfoDao;
import cn.fosu.javabean.SP_car_info;
public class SP_carInfoServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username=(String)request.getSession().getAttribute("username");
			
			SP_carInfoDao sp_carInfoDao=new SP_carInfoDaoImpl();
			List<SP_car_info>sp_carinfoList =sp_carInfoDao.findCarInfo(username);
			request.setAttribute("sp_carinfoList", sp_carinfoList);
			
			request.getRequestDispatcher("../SP_car.jsp").forward(request, response);
			
			
			
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	 
	}

 
}
