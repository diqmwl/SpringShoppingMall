<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Spring Shopping Mall!!!!</h1>
	<%@include file="main_top.jsp"%>
	<table>
		<tr>
			<td>상품명</td>
			<td>가격</td>
			<td>상품 설명</td>
			<td>사진</td>
		</tr>
		<c:forEach var="product" items="${product}">
			<tr
				onclick="location.href='${pageContext.request.contextPath}/main/productlist/detail?productname=${product.product_name}&key=1'">
				<td><p>
						<c:out value="${product.product_name}"></c:out>
					</p></td>
				<td><p>
						<c:out value="${product.product_price}"></c:out>
					</p></td>
				<td><p>
						<c:out value="${product.product_desc}"></c:out>
					</p></td>
				<td><p>
						<c:out value="${product.product_url}"></c:out>
					</p></td>
			</tr>
		</c:forEach>
	</table>
	<%@include file="main_bottom.jsp"%>
</body>
</html>
