<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	background-image: url(../images/bg.gif);
}
#wrap{
width:977px;
margin:20px auto auto auto;
}
.top_corner{
width:976px;
height:15px;
background:url(../images/top_bg.gif) no-repeat center bottom;
}
#main_container{
width:977px;
background:url(../images/center_bg_repeat.gif) repeat-y center;
}
.tablecolor {
	background-color: #FFC;
	width:970px;
}
</style>
  </head>
  
  <body >
  <div id="wrap">
		
		<div id="content">
<!-- 个人中心的页面的头部 -->
<jsp:include page="../user/top.jsp"></jsp:include>
		
		
		
		<h1>    订单表：	          </h1>
		<div class="tablecolor">
		<table width="960" height="378" border="1" align="center">
  <tr>
    <th width="300" height="39" scope="col">商品图片</th>
    <th width="300" scope="col">商品名称及描述</th>
    
    <th width="68" scope="col">价格</th>
    <th width="80" scope="col">操作</th>
  </tr>
 <s:iterator>
  <tr>
    <td><a href="productFindByProductid.action?productid=<s:property value="productid"/>">
    <img src='<s:property value="photo1"/>' width="250" height="300" align="middle"/>
    </a></td>
    <td><s:property value="description"/></td>
    <td><s:property value="price"/> 元</td>
    <td><a href="cartDeleteOrder.action?productid=<s:property value="productid"/>">删除</a></td>
  </tr>
 </s:iterator> 
 <tr><th></th>
 <th></th>
 <th></th>
 <th>总计： ${sessionScope.cost }</th></tr>
</table>
</div>
		
		
		
		
		
		
		
	<jsp:include page="../user/button.jsp"></jsp:include>
	</div>
	</div>
	
  </body>
</html>
