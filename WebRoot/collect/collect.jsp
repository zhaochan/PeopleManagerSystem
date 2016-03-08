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

<title>收藏</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<style type="text/css">
body {
	background-image: url(../images/bg.gif);
}

#wrap {
	width: 977px;
	margin: 20px auto auto auto;
}

.top_corner {
	width: 976px;
	height: 15px;
	background: url(../images/top_bg.gif) no-repeat center bottom;
}

#main_container {
	width: 977px;
	background: url(../images/center_bg_repeat.gif) repeat-y center;
}

body table tr {
	background-color: #FFC;
}

.icon {
	margin: 10px;
	border: solid 2px gray;
	width: 160px;
	height: 180px;
	text-align: center;
	float: left;
}
</style>

<body>
	<div id="wrap">

		<div id="content">
			<jsp:include page="../user/top.jsp"></jsp:include>



			<h1>我的收藏：</h1>
			<table width="960" height="488"  align="center">
				<tr>
					<th width="250" height="35" scope="col">商品详情</th>
					<th width="280" scope="col">商品描述</th>
					<th width="103" scope="col">价格</th>
					<th width="104" scope="col">日期</th>
					<th width="80" scope="col">操作</th>
					
				</tr>
<s:iterator>
				<tr>
					<td><a href="productFindByProductid.action?productid=<s:property value="productid"/>">
					<img src='<s:property value="photo1"/>' width="298"
							height="200" />
					</a>
					</td>
					<td><s:property value="description"/></td>
					<td><s:property value="price"/></td>
					<td><s:property value="releasedate"/></td>
					<td><a href="cartDeleteColletion.action?productid=<s:property value="productid"/>">删除
					</a></td>
				</tr>
</s:iterator>
			
			</table>




			<jsp:include page="../user/button.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>
