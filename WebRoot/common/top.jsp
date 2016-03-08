<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>跳蚤市场</title>
    
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  
   <link rel="stylesheet" type="text/css" href="style.css" media="screen" />
   
  
  </head>
  
  <body>
   <div id="wrap">
    <div class="top_corner"></div>
    
    <div id="main_container">
    
     <div id="header">
				<div id="logo">
					<a href="index.jsp"><img src="images/logo.gif" alt="" title=""
						border="0" />
					</a>
				</div>

				<a href="make-a-donation.html" class="make_donation"></a>

				<div id="menu">
				<%--
				class="current"
					--%>
					<ul>
						<li><a  href="index.jsp" title="">首页</a>
						</li>
						<li><a href="productFindByType.action?category=书籍类" title="">书籍类</a>
						</li>
						<li><a href="productFindByType.action?category=衣服类" title="">衣服类</a>
						</li>
						<li><a href="productFindByType.action?category=电子产品" title="">电子产品</a>
						</li>
						<li><a href="productFindByType.action?category=交通工具" title="">交通工具</a>
						</li>
						<li><a href="productFindByType.action?category=运动器械" title="">运动器械</a>
						</li>
						
						<li><a href="productFindByType.action?category=其他" title="">其他</a>
						</li>
						<li><a href="user/userInfo.jsp" target="_black" title="">个人中心</a>
						</li>
					</ul>
				</div>
			</div>
                  
       
  </body>
</html>
