package cn.fosu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FosuJDBCUtil {
	//定义数据库的基本信息常量
	private static final String DRIVER ="com.mysql.jdbc.Driver";//驱动包的位置
	private static final String URL="jdbc:mysql://localhost:3306/sp_db?useUnicode=true&characterEncoding=utf-8";
	private static final String USER="root";//用户名数据库
	private static final String PASSWORD="";//用户数据库密码，无则“”
	private static Connection ct=null;//获得连接的对象
	private static PreparedStatement ps=null;//发送sql语句的对象
	private static ResultSet rs=null;//返回的结果
//1.加载驱动，以为数据库加载驱动只用一次，说以可将加载驱动的代码放到静态代码块中
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//2.获得连接
	public static Connection getConnection(){
		try {
			ct =DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}
	
	
	//3。得到发送sql语句对象statement
	//编写一个查询数据库的方法，返回值是ResultSet
	//sql：sql语句，info：占位符得到具体内容
	public static ResultSet executeQuery(String sql,String[] info){
	    //得到链接
		ct=getConnection();
			try {
				
				//得到ps对象
				ps=ct.prepareStatement(sql);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   
			
			//处理占位符的问题
		if(info!=null){
			//有可能有多个占位符，用for循环处理
			for(int i=0;i<info.length;i++){
				 
					
				try {
						//将占位符设置到sql语句中
						ps.setString(1+i,info[i]);
					
					
				} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		 
		try {
			
			//4.发送sql语句,这是发送查询的sql语句
			rs=ps.executeQuery();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5.返回操作结果（ResultSet）
		return rs;

	}//查询方法的资源不可在此关闭，因还需对查询结果进行操作
	
	
	//6.对返回结果进行操作
	
	//编写一个方法可以完成一个增删改
	public static int executeUpdate(String sql,String[] info){
	 //得到链接
	ct=getConnection();
		try {
			
			//得到ps对象
			ps=ct.prepareStatement(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
		
		//处理占位符的问题
	if(info!=null){
		//有可能有多个占位符，用for循环处理
		for(int i=0;i<info.length;i++){
			 
				
			try {
					//将占位符设置到sql语句中
					ps.setString(1+i,info[i]);
				
				
			} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	 
	try {
		
		//4.发送sql语句,这是发送查询的sql语句
		int row=ps.executeUpdate();
		if(row>0){
			System.out.println("操作成功，作用了"+row+"条记录！");
		}else{
			System.out.println("操作失败：");
		}
		return row;
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{//无论是否有异常finally中的代码都会执行
	close(ct,ps,rs);
	}
	//5.返回操作结果（ResultSet）
	return 0;

	}
	
	//7.关闭资源,封装一个关闭资源的方法
	public static  void close(Connection ct,PreparedStatement ps,ResultSet rs){
	//想打开后关闭
		try{
			if(rs!=null){
				rs.close();
			}
			rs=null;
			if(ps!=null){
				ps.close();
			}
			ps=null;
			if(ct!=null){
				ct.close();
			}
			ct=null;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	//编写两个方法可以返回ps，ct
	public  static Connection getCt(){
		return ct;
	}
	public static PreparedStatement getPs(){
		return ps;
	}
}
