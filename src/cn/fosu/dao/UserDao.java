package cn.fosu.dao;

public interface UserDao {
	//1.����һ��save Username�ķ���
	void save(String username,String password);
	//2.����һ����������boolean�ж��û��Ƿ��Ѿ���ע��
	boolean findByUsername(String username);
	//3������һ����������һ��booleanֵ�ж��Ƿ��¼�ɹ�
	boolean LoginUsername(String username,String password);
}
