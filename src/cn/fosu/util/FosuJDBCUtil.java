package cn.fosu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FosuJDBCUtil {
	//�������ݿ�Ļ�����Ϣ����
	private static final String DRIVER ="com.mysql.jdbc.Driver";//��������λ��
	private static final String URL="jdbc:mysql://localhost:3306/sp_db?useUnicode=true&characterEncoding=utf-8";
	private static final String USER="root";//�û������ݿ�
	private static final String PASSWORD="";//�û����ݿ����룬���򡰡�
	private static Connection ct=null;//������ӵĶ���
	private static PreparedStatement ps=null;//����sql���Ķ���
	private static ResultSet rs=null;//���صĽ��
//1.������������Ϊ���ݿ��������ֻ��һ�Σ�˵�Կɽ����������Ĵ���ŵ���̬�������
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//2.�������
	public static Connection getConnection(){
		try {
			ct =DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}
	
	
	//3���õ�����sql������statement
	//��дһ����ѯ���ݿ�ķ���������ֵ��ResultSet
	//sql��sql��䣬info��ռλ���õ���������
	public static ResultSet executeQuery(String sql,String[] info){
	    //�õ�����
		ct=getConnection();
			try {
				
				//�õ�ps����
				ps=ct.prepareStatement(sql);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   
			
			//����ռλ��������
		if(info!=null){
			//�п����ж��ռλ������forѭ������
			for(int i=0;i<info.length;i++){
				 
					
				try {
						//��ռλ�����õ�sql�����
						ps.setString(1+i,info[i]);
					
					
				} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
		 
		try {
			
			//4.����sql���,���Ƿ��Ͳ�ѯ��sql���
			rs=ps.executeQuery();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5.���ز��������ResultSet��
		return rs;

	}//��ѯ��������Դ�����ڴ˹رգ�����Բ�ѯ������в���
	
	
	//6.�Է��ؽ�����в���
	
	//��дһ�������������һ����ɾ��
	public static int executeUpdate(String sql,String[] info){
	 //�õ�����
	ct=getConnection();
		try {
			
			//�õ�ps����
			ps=ct.prepareStatement(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
		
		//����ռλ��������
	if(info!=null){
		//�п����ж��ռλ������forѭ������
		for(int i=0;i<info.length;i++){
			 
				
			try {
					//��ռλ�����õ�sql�����
					ps.setString(1+i,info[i]);
				
				
			} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	 
	try {
		
		//4.����sql���,���Ƿ��Ͳ�ѯ��sql���
		int row=ps.executeUpdate();
		if(row>0){
			System.out.println("�����ɹ���������"+row+"����¼��");
		}else{
			System.out.println("����ʧ�ܣ�");
		}
		return row;
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{//�����Ƿ����쳣finally�еĴ��붼��ִ��
	close(ct,ps,rs);
	}
	//5.���ز��������ResultSet��
	return 0;

	}
	
	//7.�ر���Դ,��װһ���ر���Դ�ķ���
	public static  void close(Connection ct,PreparedStatement ps,ResultSet rs){
	//��򿪺�ر�
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
	//��д�����������Է���ps��ct
	public  static Connection getCt(){
		return ct;
	}
	public static PreparedStatement getPs(){
		return ps;
	}
}
