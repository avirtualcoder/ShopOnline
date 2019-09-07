package cn.fosu.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import cn.fosu.dao.UserDao;
import cn.fosu.util.FosuJDBCUtil;

public class UserDaoImpl implements UserDao{
	public void save(String username,String password){
		String sql="insert ignore into users(username,password)values(?,?)";
		String info[]={username,password};
		FosuJDBCUtil.executeUpdate(sql, info);
	}

public boolean findByUsername(String username) {
		
		ResultSet rs =null;
		try {
		String sql = "SELECT * FROM users WHERE username=?";
		String info[]={username};
		rs = FosuJDBCUtil.executeQuery(sql, info);
		
			if(rs.next()){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			FosuJDBCUtil.close(FosuJDBCUtil.getCt(), FosuJDBCUtil.getPs(), rs);
		}
		return false;
	}

	public boolean LoginUsername(String username,String password){
		boolean flag=false;
		ResultSet rs=null;
		//ע�⣺�����û�����¼��ʱ��Ҫ�������ݿ�ע��©�����������룻���ܽ��û���������ȥ���ݿ��ѯ
		//���Խ��û���ȥ���ݿ��ѯ�󷵻صõ������룬�����û�������������Ƚ�
		String sql="select password from users where username=?";
		String info[]={username};
		rs=FosuJDBCUtil.executeQuery(sql,info);
		String password2=null;
		try {
			if(rs.next()){
				password2=rs.getString("password");
				if(password2.equals(password)){
					System.out.println("��½�ɹ�");
					flag=true;
				}else{
					System.out.println("�������");
					flag=false;
				}
			}else{
				System.out.println("�û�������");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
		
}
