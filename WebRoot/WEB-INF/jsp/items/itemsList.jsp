<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <script type="text/javascript">
  	function queryItems(){
  		document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems.action";
		document.itemsForm.submit();
  	}
  	
  	function deleteItems(){
  		document.itemsForm.action="${pageContext.request.contextPath }/items/deleteItems.action";
		document.itemsForm.submit();
  	}
  </script>
  
  <body>
	<form name="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td>商品名称：<input name="itemsCustom.name" />
					类型：
					<select name="itemtype">
						<c:forEach items="${itemtypes }" var="itemtype">
							<option value="${itemtype.key }">${itemtype.value }</option>		
						</c:forEach>
					</select>
				<td><input type="button" value="查询" onclick="queryItems()"/>
					
		</table>
		商品列表：
		<table width="100%" border=1>
			<tr>
				<td>
				<td>商品名称
				<td>价格
				<td>生产日期
				<td>商品描述
				<td>操作
			<c:forEach items="${itemsList}" var="item">
				<tr>
					<td><input type="checkbox" name="items_id" value="${item.id }"/>
					<td>${item.name }
					<td>${item.price }
					<td><fmt:formatDate value="${item.createtime }"
					                    pattern="yyyy-MM-dd HH:mm:ss" />
					<td>${item.detail }
					<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a>
					
			</c:forEach>	
		</table>
		<tr><input type="button" value="删除选中" onclick="deleteItems()"/></tr>	
	</form>
  </body>
</html>
