package cn.fosu.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fosu.dao.SP_infoDao;
import cn.fosu.dao.impl.SP_infoDaoImpl;
import cn.fosu.javabean.SP_info;

public class IndexSevlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type =request.getParameter("type");
		String info_sous=request.getParameter("info_sous");
		String id=request.getParameter("id");
		SP_infoDao sp_info=new SP_infoDaoImpl();
		List<SP_info> sp_info_list;
		
		if(id!=null){
			sp_info_list=sp_info.getSP_infoList(null,null,id);
			request.setAttribute("sp_info_list", sp_info_list);
			request.getRequestDispatcher("../SP_xiangQing.jsp").forward(request,response);
			//System.out.println("type is : "+type+" info :"+info_sous+"id is "+id);
		}else{
			//request.getRequestDispatcher("../Welcome.jsp").forward(request,response);
		//}
		
	 
			sp_info_list=sp_info.getSP_infoList(type,info_sous,id);
		// System.out.println("type is : "+type+" info :"+info_sous+"id is "+id);
		
		request.setAttribute("sp_info_list", sp_info_list);
		//转发到jsp页面
		request.getRequestDispatcher("../index.jsp").forward(request,response);
		}
		}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	 
	}
  
	 
}
