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
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="http://www.5xsj.net/jquery/jquery/jquery-1.7.1.min.js"></script>
<style>
#pop-box1 {
	color: #333;
	position: absolute;
	z-index: 9000;
	display: none;
}

#pop-box1 .close {
	float: right;
	cursor: pointer;
	width: 18px;
	height: 18px;
	overflow: hidden;
	padding: 6px 6px 2px 2px;
}

#pop-box1 .close:hover {
	background: url(images/pop_box_img2.png) 5px 3px no-repeat;
}

#dialog-overlay1 {
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

#pop-box1 .title {
	color: #FFF;
	margin-left: 5px;
}
</style>

    <script type="text/javascript">
    	function changes() {
    		var imgEle = document.getElementById("rCode");
    		imgEle.src = "accountVcode.action?" + new Date().getTime();
    	}
    </script>
    
    <script type="text/javascript">
    	
    	 window.onload = function() {
    	var username = document.getElementById("username");
    	username.onblur = function(){
    	 if(username.value.length<3){
    	 var span = document.getElementById("usernameError");
    	 span.innerHTML="用户名不能小于3位";
    	 }else{
    	 var span = document.getElementById("usernameError");
    	 span.innerHTML="";
    	 }    	
    	}
    	
    	var password = document.getElementById("password");
    	var repassword = document.getElementById("repassword");
    	password.onblur = function(){
    	if(password.value.length<3){
    	 var span = document.getElementById("passwordError1");
    	 span.innerHTML="密码不能小于3位";
    	 }else{
    	 var span = document.getElementById("passwordError1");
    	 span.innerHTML="";
    	 }    	
    	}
    	repassword.onblur = function(){
    	if(password.value != repassword.value){
    	var span = document.getElementById("passwordError");
          span.innerHTML = "两次输入的用户密码不正确，请重新数输入！";
    	}else{
    	  var span = document.getElementById("passwordError");
          span.innerHTML = "";
    	}
    	}
    	//邮箱验证
    	var email = document.getElementById("email");
    	email.onblur = function(){
    		var flag = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
    	if(flag.test(email.value)){
    	var span = document.getElementById("emailError");
          span.innerHTML = "";
    	}else{
    	  var span = document.getElementById("emailError");
          span.innerHTML = "邮箱格式不正确，请重新输入！";
    	}
    	}
    	
    	function isEmail(str){ 
var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
return reg.test(str); 
} 
	 function CheckMail(mail) {
	 var filter  = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
	 if (filter.test(mail)) return true;
	 else{
	  alert('您的电子邮件格式不正确');
	 return false;
	 }
		}
		
		//电话号码验证
		var phone = document.getElementById("phone");
		phone.onblur = function(){
		 var mobile = /^1\d{10}$/;
		 if(mobile.test(phone.value)){
		 var span = document.getElementById("phoneError");
          span.innerHTML = "";
    	}else{
    	  var span = document.getElementById("phoneError");
          span.innerHTML = "电话号码格式不正确，请重新数输入！";
    	}
		}
		
		var address = document.getElementById("address");
		address.onblur = function(){
		if(address.value.length<2){
		 var span = document.getElementById("addressError");
          span.innerHTML = "地址不能为空！";
    	}else{
    	  var span = document.getElementById("addressError");
          span.innerHTML = "";
    	}
		}
		
		var code = document.getElementById("code");
		code.onblur = function(){
		if(code.value.length!=4){
		 var span = document.getElementById("codeError");
          span.innerHTML = "验证码格式不正确！";
    	}else{
    	  var span = document.getElementById("codeError");
          span.innerHTML = "";
    	}
		}
		
		
		
			var lusername = document.getElementById("lusername");
    	lusername.onblur = function(){
    	 if(lusername.value.length<3){
    	 var span = document.getElementById("lusernameError");
    	 span.innerHTML="用户名不能小于3位";
    	 }else{
    	 var span = document.getElementById("lusernameError");
    	 span.innerHTML="";
    	 }    	
    	}
    	
    	var lpassword = document.getElementById("lpassword");
    	lpassword.onblur = function(){
    	if(lpassword.value.length<3){
    	 var span = document.getElementById("lpasswordError");
    	 span.innerHTML="密码不能小于3位";
    	 }else{
    	 var span = document.getElementById("lpasswordError");
    	 span.innerHTML="";
    	 }    	
    	}
    	
    		var lcode = document.getElementById("lcode");
		lcode.onblur = function(){
		if(lcode.value.length!=4){
		 var span = document.getElementById("lcodeError");
          span.innerHTML = "验证码格式不正确！";
    	}else{
    	  var span = document.getElementById("lcodeError");
          span.innerHTML = "";
    	}
		}
    	}
    </script>
  </head>
  
  <body>
   <div id="dialog-overlay1"></div>
	<div id="pop-box1">
	<s:form action="userinfoRegister" namespace="/" theme="simple">
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="8" height="28"><img src="images/pop_box_img4.png"
					width="8" height="28" />
				</td>
				<td width="250" align="left" background="images/pop_box_img1.png"><div
						class="title">用户注册</div>
				</td>
				<td width="30" align="right" background="images/pop_box_img1.png"><a
					class="close" onClick="popBox1close()" href="javascript:void(0);"><img
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
							<td width="205"><s:textfield name="username"  size="24" id="username" />
							
							<span style="color: red" id="usernameError"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">密码 ：</th>
							<td><s:password name="password" showPassword="true" size="24" id="password"/>
							<span style="color: red" id="passwordError1"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">确认密码 ：</th>
							<td><s:password name="" showPassword="true" size="24" id="repassword"/>
							<span style="color: red" id="passwordError"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">性别 ：</th>
							<td><s:radio  list="#{'男':'男','女':'女'}" name="sex" value="'女'"></s:radio>
							<span style="color: red" id="sexError"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">邮箱账号 ：</th>
							<td><s:textfield name="email"  size="24" id="email"/>
							<span style="color: red" id="emailError"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">联系电话 ：</th>
							<td><s:textfield name="phonenumber"  size="24" id="phone" />
							<span style="color: red" id="phoneError"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">住址 ：</th>
							<td><s:textfield name="address"  size="24" id="address"/>
							<span style="color: red" id="addressError"></span>
							</td>
						</tr>
						<tr>
							<th height="30" align="left">验证码 ：</th>
							<td><s:textfield name="vcode"  size="12" id="code"/>
							<span style="color: red" id="codeError"></span>
							
							</td>
						</tr>
						<tr>
							    <th> <img id="rCode" src="accountVcode.action"></img></th>
    							<td><a style="text-decoration: none" href="javascript:changes()" >看不清，换一张</a></td>
						</tr>

					</table>
					<table width="300" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="10"></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td width="82" height="40"></td>
							<td><input name="input" type="submit" value="注 册" />&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="input" type="reset" value="重 置" />&nbsp;&nbsp;&nbsp;&nbsp;
								
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
