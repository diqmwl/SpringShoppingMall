<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Spring Shopping Mall!!!!  
</h1>
<%@include file="main_top.jsp" %>
<table>
		<tr>
			<td>상품명</td>
			<td>가격</td>
			<td>상품 설명</td>
			<td>사진</td>
		</tr>
			<tr onclick="location.href='${pageContext.request.contextPath}/main/productlist/detail?productname=${product.product_name}'">	
			<td><p><c:out value="${product.product_name}"></c:out></p></td>
			<td><p><c:out value="${product.product_price}"></c:out></p></td>
			<td><p><c:out value="${product.product_desc}"></c:out></p></td>
			<td><p><c:out value="${product.product_url}"></c:out></p></td>
			</tr>		
	</table>
	<br>
	<h1>리뷰</h1>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/auth/review"
		modelAttribute="review">
		<table class="formtable">
			<tr style="display:none">
				<td><sf:input class="control" type="text" value ="${product.product_name}" path="product_name" /><br />
			</tr>
			<tr>
				<td class="label">리뷰내용:</td>
				<td><sf:textarea class="control" rows="5" cols="30" path="review_desc" /><br />
					<sf:errors path="review_desc" class="error" /></td>
			</tr>
			<tr>
				<td class="label">점수:</td>
				<td><sf:input class="control" type="text" path="score" /><br />
					<sf:errors path="score" class="error" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="submit" /></td>
			</tr>
		</table>
	</sf:form>
<%@include file="main_bottom.jsp" %>
</body>
</html>
