<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
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

<title>My JSP 'tanchu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="http://www.5xsj.net/jquery/jquery/jquery-1.7.1.min.js"></script>
<style>
#pop-box {
	color: #333;
	position: absolute;
	z-index: 9000;
	display: none;
}

#pop-box .close {
	float: right;
	cursor: pointer;
	width: 18px;
	height: 18px;
	overflow: hidden;
	padding: 6px 6px 2px 2px;
}

#pop-box .close:hover {
	background: url(images/pop_box_img2.png) 5px 3px no-repeat;
}

#dialog-overlay {
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	left: -25px;
	background: #000;
	opacity: .20;
	filter: Alpha(Opacity = 20);
	top: 0;
	left: 0;
	z-index: 8000;
	display: none;
}

#pop-box .title {
	color: #FFF;
	margin-left: 5px;
}
</style>
<script type="text/javascript">
    	function _change() {
    		var imgEle = document.getElementById("vCode");
    		imgEle.src = "accountVcode.action?" + new Date().getTime();
    	}
    	
    </script>


</head>

<body>
	<!--pop box begin-->
	<div id="dialog-overlay"></div>
	<div id="pop-box">
	<s:fielderror></s:fielderror>
	
			<s:form action="accountLogin.action" namespace="/" theme="simple">
	
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="8" height="28"><img src="images/pop_box_img4.png"
					width="8" height="28" />
				</td>
				<td width="250" align="left" background="images/pop_box_img1.png"><div
						class="title">用户登录</div>
				</td>
				<td width="30" align="right" background="images/pop_box_img1.png"><a
					class="close" onClick="popBoxclose()" href="javascript:void(0);"><img
						src="images/pop_box_img3.png" width="12" height="12" />
				</a>
				</td>
				<td width="8"><img src="images/pop_box_img5.png" width="8"
					height="28" />
				</td>
			</tr>
			<tr>
				<td background="images/pop_box_img6.png"></td>
				<td colspan="2" style="background:#FFF; padding:20px 40px;">
					<!--pop content begin-->

					<table width="300" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th width="95" height="30" align="left">用户名 ：</th>
							<td width="205"><s:textfield name="username" size="24" id="lusername"/>
							<span style="color: red" id="lusernameError"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">密码 ：</th>
							<td><s:password name="password" showPassword="true" size="24" id="lpassword"/>
							<span style="color: red" id="lpasswordError"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">验证码 ：</th>
							<td><s:textfield name="vcode" size="12" id ="lcode"/>
							<span style="color: red" id="lcodeError"></span>
							</td>
						</tr>
						<tr>
							   <th> <img id="vCode" src="accountVcode.action"></img></th>
    							<td><a style="text-decoration: none" href="javascript:_change()" >看不清，换一张</a></td>
						</tr>

					</table>
					<table width="300" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="10"></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td width="82" height="40"></td>
							<td><input name="input" type="submit" value="登 录" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="input" type="reset" value="取 消" />&nbsp;&nbsp;&nbsp;&nbsp;
								
							 &nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
					</table> <!--pop content end--></td>
				<td background="images/pop_box_img7.png"></td>
			</tr>
			<tr>
				<td height="8"><img src="images/pop_box_img8.png" width="8"
					height="8" />
				</td>
				<td colspan="2" background="images/pop_box_img10.png"></td>
				<td><img src="images/pop_box_img9.png" width="8" height="8" />
				</td>
			</tr>
		</table>
	</s:form>
	</div>
	
</body>
</html>