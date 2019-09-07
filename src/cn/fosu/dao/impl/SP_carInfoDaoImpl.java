package cn.fosu.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.fosu.dao.SP_carInfoDao;
import cn.fosu.javabean.SP_car_info;
import cn.fosu.util.FosuJDBCUtil;

public class SP_carInfoDaoImpl implements SP_carInfoDao{
	public List<SP_car_info> findCarInfo(String username){
		//SP_carInfoDao sp_carInfoDao =new SP_carInfoDaoImpl;
		String sql="SELECT a.sp_img,a.sp_info,a.old_price,a.new_price,b.number,c.username FROM sp_info a,sp_car b,users c WHERE c.username=b.sp_car_user AND b.sp_car_id=a.id AND c.username=?;";
		String info[]={username};
		ResultSet rs=null;
		rs=FosuJDBCUtil.executeQuery(sql, info);
		List<SP_car_info> sp_car_info_list=new ArrayList<SP_car_info>();
		
		try {
			while(rs.next()){
				SP_car_info sp_car_info=new SP_car_info();
				sp_car_info.setSp_img(rs.getString("sp_img"));
				sp_car_info.setSp_info(rs.getString("sp_info"));
				sp_car_info.setOld_price(rs.getString("old_price"));
				sp_car_info.setNew_price(rs.getString("new_price"));
				sp_car_info.setNumber(rs.getString("number"));
				sp_car_info.setUsername(rs.getString("username"));
				sp_car_info_list.add(sp_car_info);
			}
			
			for(SP_car_info sp_car_info:sp_car_info_list){
				System.out.println(sp_car_info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			FosuJDBCUtil.close(FosuJDBCUtil.getCt(), FosuJDBCUtil.getPs(), rs);

		}
		return sp_car_info_list;
		
	}
	
	public int delete(String sp_car_id,String username ){
		String sql="DELETE  FROM sp_car WHERE sp_car_id =? AND sp_car_user=?;";
		String info[]={username,sp_car_id};
		 
		return FosuJDBCUtil.executeUpdate(sql, info);
	}
}
