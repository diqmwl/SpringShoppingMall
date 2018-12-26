<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" ; charset=utf-8">
<title>Product Insert</title>
</head>
<body>
	<%@include file="main_top.jsp"%>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/admin/productinsert/docreate"
		modelAttribute="product">
		<table class="formtable">
			<tr>
				<td class="label">상품명:</td>
				<td><sf:input class="control" type="text" path="product_name" /><br />
					<sf:errors path="product_name" class="error" /></td>
			</tr>
			<tr>
				<td class="label">상품가격:</td>
				<td><sf:input class="control" type="text" path="product_price" /><br />
					<sf:errors path="product_price" class="error" /></td>
			</tr>
			<tr>
				<td class="label">상품설명:</td>
				<td><sf:textarea class="control" rows="5" cols="30" path="product_desc" /><br />
					<sf:errors path="product_desc" class="error" /></td>
			</tr>
			<tr>
				<td class="label">사진 url:</td>
				<td><sf:input class="control" type="text" path="product_url" /><br />
					<sf:errors path="product_url" class="error" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="submit" /></td>
			</tr>
		</table>
	</sf:form>

	<%@include file="main_bottom.jsp"%>
</body>
</html>
