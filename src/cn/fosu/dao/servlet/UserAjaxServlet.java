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
		
		//���ajax�������������
		String username = request.getParameter("username");
		
		System.out.println("�û�����"+username);
		
		UserDao userdao = new UserDaoImpl();
		boolean reg = userdao.findByUsername(username);
		if(reg){
			out.write("true");
			System.out.println("����ע�ᣡ");
		}else{
			out.write("false");
			System.out.println("�û��Ѵ��ڣ�");
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	
	}


}
