<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value='/css/Style.css'/>" rel="stylesheet" type="text/css" />
		<script language="javascript" src="<c:url value='/js/public.js'/>"></script>
		<script type="text/javascript">
			function addUser(){
				alert("你不能从这儿添加商品，");
			}
			function ale(){ 
    
    alert("你不能删除此商品");
 
}
		</script>
	</HEAD>
	<body>
		<br>
	<s:form action="" namespace="/" theme="simple" id="Form1" name="Form1" >
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>查 询 条 件</strong>
						</td>
					</tr>
					<tr>
						<td>
							<table cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										商品名
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="productid" size="15" value="" id="Form1_username" cssClass="bg"/>
									</td>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										发布人：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										
										<s:textfield name="username"></s:textfield>
										

									</td>
								</tr>
								<tr>
									<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										类型：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:select name="type" cssClass="field" 
								 list="#{'书籍类':'书籍类','衣服类':'衣服类','电子产品':'电子产品','交通工具':'交通工具','运动器械':'运动器械','其他':'其他'}"/>
									
											</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
										价格：
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<s:textfield name="price"/>
											</td>
								</tr>
								<tr>
									<td width="100" height="22" align="center" bgColor="#f5fafe"
										class="ta_01">
									</td>
									<td class="ta_01" bgColor="#ffffff">
										<font face="宋体" color="red"> &nbsp;</font>
									</td>
									<td align="right" bgColor="#ffffff" class="ta_01"><br><br></td>
									<td align="right" bgColor="#ffffff" class="ta_01">
										<button type="submit" id="search" name="search" value="&#26597;&#35810;" class="button_view">
&#26597;&#35810;
</button>

										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="reset" name="reset" value="&#37325;&#32622;" class="button_view"/>

									</td>
								</tr>
							</table>
						</td>

					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商 品 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										商品编号
									</td>
									<td align="center" width="10%">
										发布人
									</td>
									<td align="center" width="8%">
										商品价格
									</td>
									<td align="center" width="47%">
										商品描述
									</td>
									<td width="11%" align="center">
										商品类型
									</td>
									
									<td width="7%" align="center">
										查看
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<s:iterator>
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<a href="productFindByProductid.action?productid=<s:property value="productid"/>">
												<s:property value="productid"/></a>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="username"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
											<s:property value="price"/>	
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="47%">
												<s:property value="description"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center">
												<s:property value="category"/>
											</td>
											
											<td align="center" style="HEIGHT: 22px">
												<a href="productFindByProductid.action?productid=<s:property value="productid"/>">
													<img src="<c:url value='/images/button_view.gif'/>" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="javascript:ale()">
													<img src="<c:url value='/images/i_del.gif'/>" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
								</s:iterator>		
										
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

