package cn.fosu.dao;

public interface  SP_carDao {
     //�������ﳵ��Ϣ�޸ĸ��½�sp_car��
	public int addSP_car(String sp_car_id,String number,String sp_car_user);
	//��ѯ�û����͹��ﳵ����id�Ƿ����
	boolean findSP_car(String sp_car_id,String sp_car_user);
	//�޸Ĺ��ﳵ��Ϣ
	int updateSP_car(String sp_car_id,String number, String sp_car_user);
}
