package cn.fosu.dao;

public interface UserDao {
	//1.定义一个save Username的方法
	void save(String username,String password);
	//2.定义一个方法返回boolean判断用户是否已经被注册
	boolean findByUsername(String username);
	//3。定义一个方法返回一个boolean值判断是否登录成功
	boolean LoginUsername(String username,String password);
}
