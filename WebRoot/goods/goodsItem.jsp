<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>商品目录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/goods.css"
	media="screen"/>
<link rel="stylesheet" type="text/css" href="style.css" media="screen"/>
<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="js/jquery-func.js" type="text/javascript"></script>
<style type="text/css">
.dd
{
 position:relative;
    line-height:1.4em;
    /* 3 times the line-height to show 3 lines */
    height:4.2em;
    overflow:hidden;
}
.dd::after {
    
    font-weight:bold;
    position:absolute;
    bottom:0;
    right:0;
    padding:0 20px 1px 45px;
   
}

</style>
</head>

<body>
	<div id="wrap">
		
		<div id="main_container">

		<jsp:include page="../common/top.jsp"></jsp:include>
		<!-- 加入页面 -->
		
				</div>
			</div>


			<!-- body主框架 -->


			<!-- Main -->
			<div id="main">
				<div class="cl">&nbsp;</div>


				<!-- Sidebar -->
				<div id="sidebar">
					<!-- Search -->
					<div class="box search">
						<h2>
							查找 <span></span>
						</h2>
						<div class="box-content">
							<s:form action="searchFind.action" namespace="/" theme="simple">

								<label>关键字</label> 
								<s:textfield name="keyword" cssClass="field" /> <label>分类</label>
								<s:select name="type" cssClass="field" 
								 list="#{'书籍类':'书籍类','衣服类':'衣服类','电子产品':'电子产品','交通工具':'交通工具','运动器械':'运动器械','其他':'其他'}"/>
									
						
								<div class="inline-field">
									<label>价格</label> 
									<s:select cssClass="field small-field" name="min"
									list="#{'1':'1','5':'5','10':'10','20':'20','40':'40','50':'50' }"></s:select>
									元
									<label>to:</label> 
									<s:select cssClass="field small-field" name="max"
									list="#{'10':'10','20':'20','30':'30','40':'40','50':'50','60':'60','70':'70','80':'80' }"></s:select>
									
								</div>

								<input type="submit" class="search-submit" value="Search" />

								<p>
									<a href="#" class="bul">搜索记录</a><br /> <a href="#"
										class="bul">联系客服</a>
								</p>

							</s:form>
						</div>
					</div>
					<!-- End Search -->
				</div>
				<!-- End Sidebar -->

				<!-- Content -->
				<div id="content">

					<!-- Content Slider -->
					<div id="slider" class="box">
						<div id="slider-holder">
							<ul>
							
							<c:forEach begin="1" end="6" step="1" var="product" items="${sessionScope.productlist }">
							<li>
							<a href="productFindByProductid.action?productid=${product.productid }">
							<img src="${product.photo1 }" alt="" width="725"/>
							</a>
							</li>
							</c:forEach>
							
							</ul>
						</div>
						<div id="slider-nav">
						<c:forEach begin="1" end="5" step="1" var="product" items="${sessionScope.productlist }">
					 <a  class="active" href="productFindByProductid.action?productid=${product.productid }"></a> 
						</c:forEach>
							
						</div>
					</div>
				</div>
				<!-- End Content Slider -->

				<!-- Products -->
				<div id="content1">
					<div class="products">
						<div class="cl">&nbsp;</div>
						<ul>
						<s:iterator>
						${sessionScope.photo2 }
							<li><a href="productFindByProductid.action?productid=<s:property value="productid"/>">
							<img src='<s:property value="photo1"/>' width="235ps" height="300ps"/>
							</a>
								<div class="product-info">
									<h3>类别：<s:property value="category"/></h3>
									<div class="product-desc">
										
										<div class="dd">
										<p>
										
											商品详情：<s:property value="description"/><br />
										
										</p>
										</div>
										
										<strong class="price">价格：<s:property value="price"/> 元</strong>
										上传时间：<s:property value="releasedate"/>
									</div>
								</div></li>
								</s:iterator>
							
							
						</ul>
						<div class="cl">&nbsp;</div>
					</div>
					<!-- End Products -->

				</div>
				<!-- End Content -->




				<div class="cl">&nbsp;</div>
			</div>
			<!-- End Main -->

			<!-- Side Full -->
			<div class="side-full">

				<!-- More Products -->
				<div class="more-products">
					<div class="more-products-holder">
						<ul>
						<c:forEach var="product" items="${sessionScope.productlist }">
							<li class="last"><a href="productFindByProductid.action?productid=${product.productid }">
							<img src="${product.photo1 }" alt="" width="111" height="121"/>
							</a>
							</li>
						</c:forEach>
						
						</ul>
					</div>
					<div class="more-nav">
						<a href="#" class="prev">previous</a> <a href="#" class="next">next</a>
					</div>
				</div>
				<!-- End More Products -->


				<!-- 底部框架 -->
<jsp:include page="../common/button.jsp"></jsp:include>
		</div>
	
</body>
</html>
