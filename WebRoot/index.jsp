<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>线上赌场</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/index.css">
<jsp:include page="public_head.jsp" flush="true"></jsp:include>
<body>

<div >
	<div id="booksort"  align="center">
		<div id="left">
			<div class="mt">
				<strong>物品分类</strong>
			</div>
			<div class="mc">

				<table class="table1">
					<tr>
						<td class="type_info"><a href="">&gt;&nbsp;&nbsp;护肤</a>
						</td>
					</tr>
					<tr>
						<td class="type_info"><a href="">&gt;&nbsp;&nbsp;彩妆</a>
					</tr>
					<tr>
						<td class="type_info"><a href="">&gt;&nbsp;&nbsp;香气</a>
					</tr>
					<tr>
						<td class="type_info"><a href="">&gt;&nbsp;&nbsp;男士专区</a>
					</tr>
					<tr>
						<td class="type_info"><a href="">&gt;&nbsp;&nbsp;美容类</a>
					</tr>
					<tr>
						<td class="type_info"><a href="">&gt;&nbsp;&nbsp;减肥类</a>
					</tr>
					<tr>
						<td class="type_info"><a href="">&gt;&nbsp;&nbsp;家用电品</a>
					</tr>
					<tr>
						<td class="type_info"><a href="">&gt;&nbsp;&nbsp;生活类</a>
					</tr>

				</table>

			</div>

		</div>
		<div class="right">
			<div>
				<form action="./servlet/IndexSevlet">
					商品类型： <select name="type">
						<option value="1">护肤</option>
						<option value="2">彩妆</option>
						<option value="3">香氛</option>
						<option value="4">男士专区</option>
						<option value="5">美容类</option>
						<option value="6">减肥类</option>
						<option value="7">家用电器</option>
						<option value="8">生活类</option>
					</select><input type="text" id="info_sous" name="info_sous" /><input type="submit"
						id="sb" name="sb" value="搜索" />


				</form>
			</div>
			<div id="sp_list">
				<div id="sp_one">
					<b>护肤</b>
				</div>
			 
				<div>
					<table class="sp_table">
						<tr> 
						<c:forEach var="c" items="${sp_info_list}" varStatus="status">
							<td class="info_td"><a href="<%=basePath%>/servlet/IndexSevlet?id=${c.id}"> <img alt="找不到图片"
									src="img/${c.sp_img }" class="sp_img"> </a> <br> <span
								class="sp_old"><b>￥${c.old_price }&nbsp;&nbsp;</b>
							</span><span class="sp_new"><b>￥${c.new_price}&nbsp;&nbsp;</b>
							</span> <br>
								<div class="sp_info">
									<a href="">${c.sp_info}</a>
								</div></td>

							 	 	<c:if test="${status.count%4==0}">
									<tr>
									</c:if>
						</c:forEach>
						</tr>
					

					</table>

				</div>



			</div>

		</div>
	</div>
	</div>
	<div style="margin-left:105px"><jsp:include
			page="public_bottom.jsp" flush="true"></jsp:include></div>

	<div cc>
		<h1>打工是没有前途的，只有赌博才能赢得一切</h1>
		<a href="./gambling_house.jsp">the gate for new word </a>
	</div>
	<div style="text-align:center;color:red; margin-top:200px">
		<h1>澳门赌场测试版1.0</h1>	//items从request域中取出对象
		<br>
		<form action="">
			支付方式<input type="text" id="username" name="username"> <br>
			<br> 支付金额<input type="text" id="text" name="text"> <br>
			<br> <input type="submit" id="sb" name="sb" value="捐款">
		</form>
	</div>
</body>

</html>
