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
		//注意：在作用户名登录的时候要考虑数据库注入漏洞：万能密码；不能讲用户名与密码去数据库查询
		//可以将用户名去数据库查询后返回得到的密码，再与用户输入的密码作比较
		String sql="select password from users where username=?";
		String info[]={username};
		rs=FosuJDBCUtil.executeQuery(sql,info);
		String password2=null;
		try {
			if(rs.next()){
				password2=rs.getString("password");
				if(password2.equals(password)){
					System.out.println("登陆成功");
					flag=true;
				}else{
					System.out.println("密码错误");
					flag=false;
				}
			}else{
				System.out.println("用户不存在");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
		
}
