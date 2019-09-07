<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   
  <jsp:include page="public_head.jsp"></jsp:include>
  </head>
   <script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
  $(function(){
 	 //username失去焦点的事件
  	$("#username").blur(function(){
 	 //1.取得input中的数据
	var username =$("#username").val();
	//2.定义正则表达式的变量：邮箱正则
	var reg= /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	//3.定义一个标志位
	var flag=false;
	var messige="";
	if(reg.test(username)){
	messige="用户名格式正确！";
	flag=true;
	}
	else{
	messige="输入用户名不合法！";
}
 if(flag){
 $("#user_log").text(messige).css('color','#2a00ff').css('font','11px 宋体');
 }else{
 $("#user_log").text(messige).css('color','red').css('font','11px 宋体');
}
});
});
  </script>
  
  <body>
    
     <div style="position:absolute;margin-left:155px;background-image:url(./img/login_bg.jpg);width:455px;height:230px;padding-top:120px;padding-left:550px">
     <form action="./servlet/LoginServlet"method="post">
 <table >
 	<tr>
 		<td>*账号:</td>
 		<td><input type="text" id="username" name="username">
 		</td>
 	 	<td id="user_log"></td>
 	</tr>
 		
 	<tr>
 		<td>*密码:</td>
 		<td><input type="password" id="password" name="password"> 
 		</td>
 		 
 	</tr>
 	<tr>
 		<td></td>
		<td colspn='2'><input type="submit" id="submit"value="登录">
		</td>
  		</table>
     </form>
     </div>
  </body>
</html>
