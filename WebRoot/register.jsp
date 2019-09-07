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

<title>注册界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/register.css">


</head>

<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		//username失去焦点的事件
		$("#username").blur(
				function() {
					//1.取得input中的数据
					var username = $("#username").val();
					//2.定义正则表达式的变量：邮箱正则
					var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
					//3.定义一个标志位
					var flag = false;
					var messige = "";
					if (reg.test(username)) {
						messige = "恭喜，可以正常注册！";
						flag = true;
					} else {
						messige = "输入邮箱不合法！";
					}
					if (flag) {
						//做ajax操作，异步加载局部刷新，xml与javascript的集合
						//用JavaScript操作一般用.ajax,load,get(快但是是明文转发max  4kb),post(安全大小无限制)方法
						//用post，准备传输的数据，都用json数据
						//$post(url,data,founction(返回的数据，状态){});

						var json = {
							username : $("#username").val()
						};//从input得到数据

						$.post("./servlet/UserAjaxServlet", json, function(
								data, textstatus) {
							if (data == "true") {
								$("#user_reg").text("可以正常注册！！").css('color',
										'#2a00ff').css('font', '12px 宋体');
							} else {
								$("#user_reg").text("用户已被注册！！").css('color',
										'red').css('font', '12px 宋体');
							}
						});
					} else {
						$("#user_reg").text(messige).css('color', 'red').css(
								'font', '11px 宋体');
					}
				});

		//密码监听
		$("#password").blur(
				function() {
					var password = $("#password").val();
					var reg = /^[a-zA-Z]\w{5,17}$/;
					var flag = false;
					var messige = "";
					if (reg.test(password)) {
						messige = "密码设置正确";
						flag = true;
					} else {
						messige = "密码必须以字母开头，长度在6~18之间，只能包含字母、数字和下划线！";
					}

					if (flag) {
						$("#user_mima").text(messige).css('color', '#2a00ff')
								.css('font', '11px 宋体');
					} else {
						$("#user_mima").text(messige).css('color', 'red').css(
								'font', '11px 宋体');
					}
				});

		//确认密码监听
		$("#password1").blur(
				function() {
					var password = $("#password").val();
					var password1 = $("#password1").val();
					if (password != password1) {
						$("#sure_secr").text("密码不一致").css('color', 'red').css(
								'font', '11px 宋体');
					} else {
						$("#sure_secr").text("密码一致").css('color', '#2a00ff')
								.css('font', '11px 宋体');
					}
				});

	});
</script>
<jsp:include page="public_head.jsp" flush="true"></jsp:include>
<body>

	<div id="text1">个人用户信息</div>

	<div id="form1">
		<form action="./servlet/UserServlet" method="post">
			<table>
				<tr class="table_input">
					<td>*账号:</td>
					<td><input type="text" id="username" name="username">
					</td>
					<td id="user_reg"></td>
				</tr>
				<tr class="table_input">
					<td>&nbsp;</td>
				</tr>
				<tr class="table_input">
					<td>*密码:</td>
					<td><input type="password" id="password" name="password">
					</td>
					<td id="user_mima"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr class="table_input">
					<td>*确认密码:</td>
					<td><input type="password" id="password1" name="password1">
					</td>
					<td id="sure_secr"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr class="table_input">
					<td>&nbsp;</td>
					<td colspan='2'><input type="submit" id="submit"
						value="我同意并注册"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
