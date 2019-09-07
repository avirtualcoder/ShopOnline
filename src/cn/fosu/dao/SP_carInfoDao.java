package cn.fosu.dao;
import java.util.List;
import cn.fosu.javabean.SP_car_info;

public interface SP_carInfoDao {
	List<SP_car_info> findCarInfo(String username);
	int delete(String id,String username);
}
