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
    
    <title>发布商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<%--<link rel="stylesheet" type="text/css" href="css/upload.css">
	--%>
	<style type="text/css">
body tr {
	background-color: #FFC;
}
.form_content{
width:575px;
margin:30px auto;
padding:10px;
background:url(images/form_top_bg.gif) repeat-x top #fff;
}
.form-row {
clear: both;
float:left;
padding:5px 5px 5px 5px;
}
.field-label {
width:150px;
float:left;
line-height:25px;
}
.field-widget {
float:left;
}
input.required{
width:300px;
height:22px;
border: 1px solid #95E0EF;
background-color:#f3fcfe;
border-left-width:2px;
padding:5px 0 0 2px;
float:left;
}
</style>
  </head>
  
  <body>
  <div id="content">
     <jsp:include page="../user/top.jsp"></jsp:include>
  <div class="form_content">
  <s:form action="productUpload.action" namespace="/" theme="simple" enctype="multipart/form-data">
    <fieldset>
        <legend>发布商品</legend>
    
      <div class="form-row">
            <div class="field-label"><label for="field1">商品名称：</label>:</div>
            <div class="field-widget"><s:textfield name="field1" id="field1" cssClass="required" title="Enter your name" /></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">商品描述：</label>:</div>
            <div class="field-widget"><s:textarea name="description"  cssClass="required"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field3">商品价格：</label>:</div>
            <div class="field-widget"><s:textfield name="price" cssClass="required"/></div>
        </div>
        
         <div class="form-row">
            <div class="field-label"><label for="field3">商品类型：</label>:</div>
            <div class="field-widget"><s:select list="#{'书籍类':'书籍类','衣服类':'衣服类','电子产品':'电子产品','交通工具':'交通工具','运动器械':'运动器械','其他':'其他' }" name="category"></s:select></div>
        </div>
        
          <div class="form-row">
            <div class="field-label"><label for="field3">商品照片1：</label>:</div>
            <div class="field-widget"><s:file name="resume" cssClass="required"/></div>
        </div>
        
          <div class="form-row">
            <div class="field-label"><label for="field3">商品照片2：</label>:</div>
            <div class="field-widget"><s:file name="resume" cssClass="required"/></div>
        </div>
        
        
         
    
    </fieldset>
    <input type="submit" class="submit" value="提  交" /> 
         <input class="reset" type="reset" value="重 置" onclick="valid.reset(); return false" />
         </s:form>
    </div>
    
    
    <jsp:include page="../user/button.jsp"></jsp:include>
    </div>
 
  </body>
</html>
