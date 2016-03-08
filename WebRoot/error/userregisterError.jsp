<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<link rel="stylesheet" type="text/css" href="css/userInfo.css">
<meta http-equiv="refresh" content="1.5;url=user/userInfo.jsp"/>
</head>
 <html>
 <body>
	<div id="wrap">

		<div id="content">
			<jsp:include page="../user/top.jsp"></jsp:include>

<h1 style="margin-top:10px; margin-left:260px">

<s:actionerror style="color:red"/>
</h1>

			<a  href="user/userInfo.jsp" style="margin-top:10px; margin-left:250px"><img src="images/error2.jpg"/></a>

          


			<jsp:include page="../user/button.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>
