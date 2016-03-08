<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<link rel="stylesheet" type="text/css" href="css/userInfo.css">

<script type="text/javascript">
function ale()
{ 
        //这个基本没有什么说的，就是弹出一个提醒的对话框
 
    alert("你不能删除你的商品");
 
}
</script>
</head>
 <html>
 <body>
	<div id="wrap">

		<div id="content"><br>&nbsp; 
			<jsp:include page="../user/top.jsp"></jsp:include>



			<h1 align="center">个人信息：</h1>
			<s:form action="userinfoRevamp.action" namespace="/" theme="simple">
			<table width="400" height="100"  align="center">
			<tr>
			<td>用户名：</td>
			<td><s:textfield name="username" value="%{#session.username}" /></td>
			</tr>
			<tr>
			<td>密&nbsp;&nbsp;码：</td>
			<td><s:textfield name="password" value="%{#session.password}"/></td>
			</tr>
			<tr>
			<td>性 &nbsp;&nbsp;别：</td>
			<td><s:textfield name="sex" value="%{#session.userinfo.sex}"/></td>
			</tr>
				<tr>
		 	<td>电 &nbsp;&nbsp;话：</td>
			<td><s:textfield name="phonenumber" value="%{#session.userinfo.phonenumber}"/></td>
			</tr>
			<tr>
		 	<td>邮 &nbsp;&nbsp;箱：</td>
			<td><s:textfield name="email" value="%{#session.userinfo.email}"/></td>
			</tr>
			<tr>
			<td>地  &nbsp;&nbsp;址：</td>
			<td><s:textfield name="address" value="%{#session.userinfo.address}"/></td>
			</tr>
			<tr>
		<tr>
			<td></td>
			<td><input type="submit" value="确认修改" /></td>
			</tr>

			</table>
			</s:form>

<h1 align="center">我的商品：</h1>
<table width="900" align="center" border="1" cellpadding="20" cellspacing="0.5"  style="table-layout:fixed;">
<tr>
<th>商品编号</th>
<th width="400">商品描述</th>
<th>价格</th>
<th>发布日期</th>
<th>操作</th>
</tr>
<s:iterator>
			<tr>
			<td><a href="productFindByProductid.action?productid=<s:property value="productid"/>">
			<s:property value="productid"/>
			</a></td>
			<td width="400" style="word-wrap:break-word;">
			商品类型：<s:property value="category"/><br>
			<s:property value="description"/></td>
			<td><s:property value="price"/> 元</td>
			<td><s:property value="releasedate"/></td>
			<td>
			<a href="javascript:ale()">删除</a>
			</td>
			</tr>
</s:iterator>		

			</table>


			<jsp:include page="../user/button.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>
