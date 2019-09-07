<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/SP_car.css">

  </head>
  <jsp:include page="public_head.jsp" flush="true"></jsp:include>
  <script type="text/javascript">
  function sub(){
  var a=document.getElementById("input_number").value;//取得input中的value值
  
  if(a>1){//判断是否大于1
  a=parseInt(a)-1;//传过来的为字符串要改为整型
  document.getElementById("input_number").value=a;//修改input中value的值
  }
  }
  
  function add(){
  var a=document.getElementById("input_number").value;
  if(a<100){
  a=parseInt(a)+1;
  document.getElementById("input_number").value=a;
  }
  }
  </script>
 <body >
	<table class="sp_table" align="center" >

		
		<tr class="car_th">
			<td ><input type="checkbox"> 全选</td>
			<td >商品名称</td>
			<td >原价</td>
			<td >疯狂价</td>
			<td >小计</td>
			<td >数量</td>
			<td >操作</td>
		</tr>
	
		
		<tr >
			<c:forEach var="c" items="${sp_carinfoList }" varStatus="status">
				<td class="info_td" width="100px"><input type="checkbox"></input>
				</td>
				<td class="info_td" width="300px"><img alt="找不到图片"
					src="<%=basePath %>/img/${c.sp_img }" class="sp_img" width="50px">
					<a href="">${c.sp_info }</a></td>
				<td class="info_td">${c.old_price }</td>
				<td class="info_td" id="new_price">${c.new_price}</td>
				<td class="info_td">合计</td>
				<td class="info_td">
					<button id="but1" name="but1" onclick="javascript:sub();">-</button>
					<input type="text" name="input_number" value="${c.number}"
					id="input_number" disabled="disabled"
					style="width: 30px;text-align: center;">
					<button id="but2" name="but2" onclick="javascript:add()">+</button>
				</td>
				<td class="info_td"><a href="">加入收藏</a><br> <br><a href="<%=basePath %>/servlet/JieSuangServlet">
						移除</a></td>
				<c:if test="${status.count%1==0 }">
					<tr>
				</c:if>

			</c:forEach>



		</tr>

	</table>
	<div id="number_total">
	<div id=""><b>总计量数：
	<span id="price">10</span>
	件</b>
	</div>
	<div id="price_t"><b>金额总计：￥
	<span id="price">124.34</span>折后价
	</b>
	</div>
	<div id="price_t" >
	<a href=""><img alt="" src="<%=basePath %>/img/jieshuan.png"></a>
	</div>
	</div>
	
	<form action="./jiesuang.jsp">
					<input type="submit"id="sb" name="sb" value="结算" />
					
					</form>
					
					
					<form action="./Welcome.jsp">
					<input type="submit"id="sb" name="sb" value="继续逛逛" />
					</form>
</body>

</html>
