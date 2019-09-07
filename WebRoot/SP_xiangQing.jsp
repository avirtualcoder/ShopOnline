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
    
    <title>商品详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 
	<link rel="stylesheet" type="text/css" href="css/SP_xiangQing.css">
	 

  </head>
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
  
  function go_sp_car(){
  var uri="http://localhost:8080/shopline/servlet/SP_carServlet?id=";
  var id=<%=request.getParameter("id")%>
  var number=document.getElementById("input_number").value;
  location=uri+id+"&number="+number;
  }
  
  </script>
  
  
  <jsp:include page="public_head.jsp" flush="true"></jsp:include>
  <body>
  
  <div class="xiangqing">
    <c:forEach var="c" items="${sp_info_list }" varStatus="status">
    <div class="sp_info">${c.sp_info }</div>
							<div class="info_td">
							<img alt="找不到图片" 
							     src="<%=basePath %>/img/${c.sp_img }" class="sp_img">
							</div>
							<table>
							<tr>
							<td class='td_info'>供应商： Cetaphil丝塔芙洗面奶</td>
			</tr>
			<tr>
			<td class='td_info'>出产地： 法国</td>
			</tr>
			<tr>
			<td class='td_info'>定      价：￥${c.old_price }</td>
			</tr>
			<tr>
			<td class='red_info'>疯  狂  价：￥${c.new_price }（0.7折）</td>
			</tr>
			<tr>
			<td class='td_info'>库      存：100  下单后立即发货</td></tr>
			<tr>
			<td class='red_info'>
促销信息：	该商品参加满减活动，购买活动商品每满300元，可减100元现金</td>
			</tr>
			<tr>
			<td  class='bom_info'>
我要买：<button id="but1" name="but1" onclick="javascript:sub();">-</button>
	<input type="text" name="input_number" id="input_number" value="1" disabled="disabled" style="width: 60px;text-align: center;">
	<button id="but2"  name="but2"  onclick="javascript:add();">+</button>
</td>
			</tr>
			<tr >
			<td class='bom_info'>
			<a href="javascript:go_sp_car();"><img alt="找不到图片" src="<%=basePath%>img/add_car.png"></img></a>	
			</td>
			<td><form action="./Welcome"><input type="submit"id="sb" name="sb" value="返回"/>
					</form>
		
			</td>
			</tr>
			
			</table>
							
							</c:forEach>
							</div>
	 
  </body>
</html>