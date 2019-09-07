<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<title>My JSP 'public_head.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/public_head.css">
</head>
<script type="text/javascript">
	//编写一个方法，getMyname()
	   function getMyName(){
	   //1.用js变量用来保存从Session得到的用户名
	   var myName="<%=session.getAttribute("username")%>";
		if (myName == "null") {
			document.getElementById("login").innerHTML = "<a href='http://localhost:8080/shopline/Login.jsp'>【请登录】</a>";
		} else {
			document.getElementById("login").innerHTML = "欢迎"
					+ myName
					+ "<a href='http://localhost:8080/shopline/servlet/LogoutServlet'>注销</a>";
		}
	};
</script>
<body onload="getMyName()">
	<div align="center" >
	    <div style="width:960px;">
	    <div align="center">
		<div id="head_div1">
			官方网站： <a href="<%=basePath%>/Login.jsp" id="head_login">联系我们</a> <span id="login">【请登录】</span>
			<a href="<%=basePath%>/register.jsp">【免费注册】</a> 
			<a href="<%=basePath%>/servlet/SP_carServlet">【我的购物车】</a>
			<a href=""id="head_dind">【我的订单】</a>
		</div>
		</div>
		<div id="head_div3">
			<img alt="cannot find the resource" src="img/logo.gif"> <img
				alt="cannot find the resource" src="img/banner.gif">
		</div>
		<div id="head_div2">
			<a href="<%=basePath%>/servlet/IndexSevlet" class="head_a2">首页</a> 
			<a href="<%=basePath%>/servlet/IndexSevlet?type=1&info_sous=" class="head_a2">护肤</a> 
			<a href=" <%=basePath%>/servlet/IndexSevlet?type=2&info_sous=" class="head_a2">彩妆</a> 
			<a href=" <%=basePath%>/servlet/IndexSevlet?type=3&info_sous=" class="head_a2">香气</a> 
			<a href=" <%=basePath%>/servlet/IndexSevlet?type=4&info_sous=" class="head_a2">男士专区</a> 
			<a href="<%=basePath%>/servlet/IndexSevlet?type=5&info_sous=" class="head_a2">美容类</a>
			<a href="<%=basePath%>/servlet/IndexSevlet?type=6&info_sous=" class="head_a2">减肥类</a> 
			<a href="<%=basePath%>/servlet/IndexSevlet?type=7&info_sous=" class="head_a2">家用电品</a>
			<a href="<%=basePath%>/servlet/IndexSevlet?type=8&info_sous=" class="head_a2">生活类</a>

		</div>
	</div>
	</div>
	<br>
</body>
</html>
