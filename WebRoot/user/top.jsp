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
    
    <title>个人中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	<link rel="stylesheet" type="text/css" href="css/userInfo.css"/>
	
  </head>

  <body>
  
  <script type="text/javascript"> 
function popupBox() { 
var maskHeight = $(document).height(); 
var maskWidth = $(window).width(); 
var ordertop = 50; 
var orderLeft =600; 
$('#dialog-overlay').css({height:maskHeight, width:maskWidth}).show(); 
$('#pop-box').css({top:ordertop, left:orderLeft}).show(); 
}
$(window).resize(function () { 
if (!$('#pop-box').is(':hidden')) popupBox(); 
});

 function popBoxclose(){
$('#dialog-overlay, #pop-box').hide(); 
return false; 
}
</script>
  <script type="text/javascript"> 
function popupBox1() { 
var maskHeight = $(document).height(); 
var maskWidth = $(window).width(); 
var ordertop = 80; 
var orderLeft =450; 
$('#dialog-overlay1').css({height:maskHeight, width:maskWidth}).show(); 
$('#pop-box1').css({top:ordertop, left:orderLeft}).show(); 
}
$(window).resize(function () { 
if (!$('#pop-box1').is(':hidden')) popupBox1(); 
});

 function popBox1close(){
$('#dialog-overlay1, #pop-box1').hide(); 
return false; 
}
</script>

  
     <!-- Shell -->	
    
<div class="shell">
	
	<!-- Header -->	
	<div id="header">
		<h1 id="logo"><a href=""><img src="images/logo.gif"/></a></h1>	
		
		<!-- Cart -->
		<div id="cart">
			
			<c:choose>
			<c:when test="${empty sessionScope.username }">
			<a href="javascript:popupBox();"  style="color: #fff;text-decoration: none;">登录&nbsp;&nbsp;&nbsp;&nbsp;</a>
			<a href="javascript:popupBox1();" style="color: #fff;text-decoration: none;">&nbsp;&nbsp;&nbsp;&nbsp;注册</a>
			</c:when>
			<c:otherwise>
			<a href="cartMyCart.action" class="cart-link" >购物车</a>
			<a href="userinfoFind.action" style="color: #fff;text-decoration: none;">用户：${sessionScope.username }</a>
			<a href="accountQuit.action" style="color: #fff;text-decoration: none;">&nbsp;&ndash;退出</a>
			</c:otherwise>
			</c:choose>
			<div class="cl">&nbsp;
			
			</div>
			
			<span>商品数: <strong>${sessionScope.size } 件</strong></span>
			&nbsp;&nbsp;
			<span>总额: <strong>${sessionScope.cost } 元</strong></span>
		</div>
		<!-- End Cart -->
		
		<!-- Navigation -->
		<div id="navigation">
			<ul>
			    
			    <c:choose>
			    <c:when test="${empty sessionScope.username }">
			    <li>
			    <a href="javascript:popupBox();">个人信息</a>
			    </li>
			     <li>
			    <a href="javascript:popupBox();">我的订单</a>
			    </li>
			    <li>
			    <a href="javascript:popupBox();">我的收藏</a>
			    </li>
			    <li>
			    <a href="javascript:popupBox();">发布商品</a>
			    </li>
			    <li>
			    <a href="index.jsp">商城</a>
			    </li>
			    </c:when>
			    <c:otherwise>
			    <li>
			    <a href="userinfoFind.action" >个人信息</a>
			    </li>
			     <li>
			    <a href="cartMyOrder.action">我的订单</a>
			    </li>
			    <li>
			    <a href="cartMyCollection.action">我的收藏</a>
			    </li>
			    <li>
			    <a href="publish/upload.jsp">发布商品</a>
			    </li>
			    <li>
			    <a href="index.jsp">商城</a>
			    </li>
			    </c:otherwise>
			    </c:choose>
			    
			   
			</ul>
		</div>
		<!-- End Navigation -->
	</div>
	<!-- End Header -->
	</div>
	
  </body>
  
</html>
