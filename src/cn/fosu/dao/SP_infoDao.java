package cn.fosu.dao;

import java.util.ArrayList;
import java.util.List;

import cn.fosu.javabean.SP_info;

public interface SP_infoDao {
	//��ѯ��ҳҪ��ʾ����Ʒ��Ϣ
	List<SP_info> getSP_infoList(String type,String sous_info,String id); 
	List<SP_info> deletcSP_infoList(String type,String sous_info,String id); 
}
