package cn.fosu.dao;

public interface  SP_carDao {
     //创建购物车信息修改更新进sp_car库
	public int addSP_car(String sp_car_id,String number,String sp_car_user);
	//查询用户名和购物车货物id是否存在
	boolean findSP_car(String sp_car_id,String sp_car_user);
	//修改购物车信息
	int updateSP_car(String sp_car_id,String number, String sp_car_user);
}
