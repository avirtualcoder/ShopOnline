<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div align="center">
  <div style="margin-left :200px">
  		 
  	 
  		注册成功
  
    <form action="./Login.jsp">
					<input type="submit"id="sb" name="sb" value="登录" />
					
					</form>
					
					
					<form action="./Welcome.jsp">
					<input type="submit"id="sb" name="sb" value="先逛逛" />
					</form>
 <br>
 </table>
 </div>
 </div>
  </body>
</html>
