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
		//��utf-8�����������
		request.setCharacterEncoding("utf-8");
		//��utf-8������Ӧ
		response.setCharacterEncoding("utf-8");
		//֪ͨ���������utf-8���������
		response.setContentType("text/html;charset=utf-8");
		//��ô�������ͻ����ύ����������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("�û����ǣ�"+username+"  ���룺"+password);
		
		UserDao userDao=new UserDaoImpl();
		//��ɱ����û��Ķ���
		userDao.save(username,password);
	
		//ת��
		//request.getRequestDispatcher("../index.jsp").forward(request,response);
		//�ض���
		response.sendRedirect("../Success.jsp");
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������ύ��ʽ��get��post��
		//�����get��ʽ��dogetִ����post����dopost
		//�·����ۺη�����doget
		doGet(request,response);
	}
}