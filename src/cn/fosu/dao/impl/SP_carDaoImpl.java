package cn.fosu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.fosu.dao.SP_carDao;
import cn.fosu.util.FosuJDBCUtil;

public class SP_carDaoImpl implements SP_carDao{
	
	public int addSP_car(String sp_car_id,String number,String sp_car_user){
		String sql="INSERT INTO sp_car (sp_car_id,number,sp_car_user) VALUES(?,?,?);";
		String info[]={sp_car_id,number,sp_car_user};
		
		return FosuJDBCUtil.executeUpdate(sql, info);
	}
	
	public boolean findSP_car(String sp_car_id,String sp_car_user){
		ResultSet rs=null;
		String sql="select *from sp_car where sp_car_id=? and sp_car_user=?;";
		String info[]={sp_car_id,sp_car_user};
		rs=FosuJDBCUtil.executeQuery(sql, info);
		boolean flag=false;
		try {
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		return flag;
	}
	
	public int updateSP_car(String number,String sp_car_id , String sp_car_user){
		
		String sql="update sp_car set number=number+? where sp_car_id=? and sp_car_user=?;";
		String info[]={number,sp_car_id,sp_car_user};
		
		return FosuJDBCUtil.executeUpdate(sql, info);
	}
}
		
		
		
		
		
		
		
		
		
		/*public boolean findSP_car(String sp_car_id,String sp_car_user){//判断user存在否后id存在否执行不同操作
		ResultSet rs1=null;
		ResultSet rs2=null;
		String sql1="select *from sp_car where sp_car_user=?;";
		String info1[]={sp_car_user};
		String sql2="select *from sp_car where sp_car_id=?;";
		String info2[]={sp_car_id};
		rs1=FosuJDBCUtil.executeQuery(sql1, info1);
		rs2=FosuJDBCUtil.executeQuery(sql2, info2);
		if(rs1.next()){
			if(rs2.next()){
				//number+
			}else{
				//insert into sp_car(sp_car_id,number,sp_car_user)values('sp_car_id','1','sp_car_user');
			}
		}else{
			//跳到login.jsp
		}
	
		
		
		return false;
	}*/



