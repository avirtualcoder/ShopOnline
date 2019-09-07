package cn.fosu.dao;

import java.util.ArrayList;
import java.util.List;

import cn.fosu.javabean.SP_info;

public interface SP_infoDao {
	//查询首页要显示的商品信息
	List<SP_info> getSP_infoList(String type,String sous_info,String id); 
	List<SP_info> deletcSP_infoList(String type,String sous_info,String id); 
}
