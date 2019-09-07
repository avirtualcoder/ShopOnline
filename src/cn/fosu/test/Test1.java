package cn.fosu.test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.fosu.javabean.Users;
import cn.fosu.util.FosuJDBCUtil;

public class Test1 {
	public static void main(String[] args){
	test1();
	//text2,3,4
	
	}
	public static void test1(){
		ResultSet rs=null;
		try {
			
			String sql="select *from users ";
			rs=FosuJDBCUtil.executeQuery(sql, null);
			List<Users>list_users=new ArrayList<Users>();
			//对返回的结果进行操作	 
				while(rs.next()){
					//将数据库获得的内容映射到users对象中
					Users user=new Users();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					list_users.add(user);
		
					System.out.println(rs.getInt("id")+","+rs.getString("username")+","+rs.getString("password"));
				}
				for(Users users:list_users){
					System.out.println(users);
				}
			} catch (Exception e) {
				// TODO :handle exception
				e.printStackTrace();
			}finally{
				FosuJDBCUtil.close(FosuJDBCUtil.getCt(),FosuJDBCUtil.getPs(),rs);
			}
	}
	public static void test2(){
		try {
			
			String sql="select *from users where id=?";
			String info[]={"48"};
			ResultSet rs=FosuJDBCUtil.executeQuery(sql, info);
			List<Users>list_users=new ArrayList<Users>();
			//对返回的结果进行操作	 
				while(rs.next()){
					//将数据库获得的内容映射到users对象中
					Users user=new Users();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					list_users.add(user);
						}
				for(Users users:list_users){
					System.out.println(users);
				}
			} catch (Exception e) {
				// TODO :handle exception
				e.printStackTrace();
			}
	}
	public static void test3(){
		String sql="insert into users(username,password)values(?,?)";
		String info[]={"牛五","hhhhhh"};
		FosuJDBCUtil.executeUpdate(sql,info);
	}
	public static void test4(){
		String sql="update users set password=? where id=?;";
		String info[]={"222211","48"};
		FosuJDBCUtil.executeUpdate(sql,info);
	}
	public static void test5(){
		String sql="delete from users where id=?";
		String info[]={"48"};
		FosuJDBCUtil.executeUpdate(sql,info);
}
}
