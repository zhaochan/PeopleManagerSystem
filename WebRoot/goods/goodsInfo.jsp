<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<link rel="stylesheet" type="text/css" href="css/goodsInfo.css">
<link rel="stylesheet" type="text/css" href="style.css">



</head>

<body>
	<div id="wrap">

		<div id="main_container">
<!-- 加入页面头部 -->
<jsp:include page="../common/top.jsp"></jsp:include>



<!-- 页面部分
用于展示商品
 -->
			<div id="main">
				<div id="left">
					<a href="<s:property value="photo1"/>">
					<img src='<s:property value="photo1"/>' width="454ps" height="600ps" /> 
					</a>
					<a href="<s:property value="photo2"/>">
					<img src='<s:property value="photo2"/>' width="454ps" height="600ps"/>
					</a>
				</div>
				<div id="right"></div>
				<div id="decribe">
				
					<h2>商品详情及描述：</h2>
					<font  style="line-height:1.5; font-size: 140%">
					发布人：${sessionScope.userinfomation.username } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 联系电话：${sessionScope.userinfomation.phonenumber }<br>
					地址：${sessionScope.userinfomation.address } <br>
					<hr/>
					<s:property value="description"/></font>
					<br />
					<h2>商品类型：</h2>
					<font  style="line-height:1.5; font-size: 140%">
					<s:property value="category"/></font>
					<br />
					<h2>商品介绍：</h2>
					<font  style="line-height:1.5; font-size: 140%">
					<s:property value="category"/>
					</font>
					<h2>价格：</h2>
					<font  style="line-height:1.5; font-size: 140%">
					<s:property value="price"/>元
					</font>
					<%--<p>联系方式</p>
					<p>14156156</p>
					<p>15645</p>
					--%><div id="info">
					<!-- 收藏   加入到购物车 -->
					<dir id="describe1">
					<c:choose>
					<c:when test="${sessionScope.reusername eq sessionScope.username}">
				</c:when>
						<c:otherwise>
						<c:choose>
							<c:when test="${empty sessionScope.username }">
								<a href="error/userInfoError.jsp"><img alt="" src="images/collection.jpg" />
								</a>
								<a href="error/userInfoError.jsp"><img alt="" src="images/addcart.jpg" />
								</a>
							</c:when>
							<c:otherwise>
								<a
									href="cartCollection.action?productid=<s:property value="productid"/>">
									<img alt="" src="images/collection.jpg" />
								</a>
								<a
									href="cartAddCart.action?productid=<s:property value="productid"/>">
									<img alt="" src="images/addcart.jpg" />
								</a>
							</c:otherwise>
						</c:choose>
						
						</c:otherwise>
					</c:choose>
						</dir>

					</div>
				</div>


			</div>






			

				
<!-- 加入底部页面部分 -->				
	<jsp:include page="../common/button.jsp"></jsp:include>

	</div>
	</div>
</body>
</html>
