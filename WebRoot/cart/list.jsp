<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	
<style type="text/css">
/*	* {
		font-size: 11pt;
	}
	*/
	#rows {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 190px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
  
<div id="content">
<jsp:include page="../user/top.jsp"></jsp:include>
   
   
   <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;购物车:</h1>

<table border="1" width="71%" cellspacing="0" background="black" align="center">
	<tr>
		<td colspan="8" align="right" style="font-size: 15pt; font-weight: 900">
		<a href="cartDeleteAllCart.action">清空购物车</a>
			<%--<a href="javascript:alert('已清空购物车！');">清空购物车</a>
		--%></td>
	</tr>
	<tr>
		<th>图片</th>
		<th>商品名</th>
		<th>出售人</th>
		<th>单价</th>		
		<th>操作</th>
	</tr>
<s:iterator>
	<tr>
		<td><div id="rows"><a href="productFindByProductid.action?productid=<s:property value="productid"/>">
		<img src='<s:property value="photo1"/>' width="170px" height="210px"/>
		</a></div></td>
		<td><s:property value="description"/></td>
		<td><s:property value="username"/></td>
		<td><s:property value="price"/> 元</td>
		<td><a href="cartDeleteCart.action?cartid=<s:property value="cartid"/>">删除</a>
		
		<%--<a href="javascript:alert('删除购物项成功！');">删除</a>
		--%></td>
	</tr>
</s:iterator>	
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
		总价：${sessionScope.totalmoney }元 
		<c:choose>
		<c:when test="${empty sessionScope.cart }">
			<a id="buy" href="productFindByType.action"><img src="images/buy.jpg"/></a>
			</c:when>
			<c:otherwise>
			<a id="buy" href="cartBuy.action"><img src="images/buy.jpg"/></a>
			</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>
   
   
   <jsp:include page="../user/button.jsp"></jsp:include>
   </div>
   </div>
  </body>
</html>

