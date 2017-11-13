<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改商品信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	
  	<c:if test="${allErrors!=null }">
  		<c:forEach	items="${allErrors }" var="error">
  			${error.defaultMessage }<br>
  		</c:forEach>
  	</c:if>
  
    <form action="${pageContext.request.contextPath }/items/editItemsSubmit.action" method="post"
    enctype="multipart/form-data">
    	<input type="hidden" name="id" value="${items.id }">
		修改商品：
    	<table width="100%" border=1>
    		<tr>
    			<td>商品名称
    			<td><input type="text" name="name" value="${items.name}"/>
    		<tr>
    			<td>商品价格
    			<td><input type="text" name="price" value="${items.price }"/>
    		<tr>
    			<td>生产日期
    			<td><input type="text" name="createtime" value="<fmt:formatDate value="${items.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/>" />
    		<tr>
    			<td>商品图片
    			<td>
    				<c:if test="${items.pic !=null }">
    					<img src="/pic/${items.pic }" width="100" height="100" /><br>
    				</c:if>
    				<input type="file" name="items_pic"/>
    		<tr>
    			<td>商品简介
    			<td><textarea rows="3" cols="30" name="detail">${items.detail }</textarea>
    		<tr>
    			<td><input type="submit" value="提交"/>
    	</table>
    	
    </form>
  </body>
</html>
