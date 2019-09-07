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
				//�õ��û���������
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				
				UserDao u_dao=new UserDaoImpl();
				boolean login =u_dao.LoginUsername(username, password);
				
				
				
				//jsp�Ĵ�������
				/*
				 * 1��page����ǰҳ�桪���������ݽ����ڵ�ǰҳ����Է���
				 * 2��request�����μ�¼
				 * 3��session�����ζԻ�������������û�йرգ������Է��ʵ����ݣ������ڷ�������
				 * 4��application��������Ŀ
				 * 
				 * */
				
				if(login){
					response.sendRedirect("../Welcome.jsp");
					//����½�ɹ����û������浽Session��
					HttpSession session=request.getSession();//ʵ����һ��Session����
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
