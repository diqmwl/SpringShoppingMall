<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 

<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>">
</script>
<script>
	$(document).ready(function() {
		$("#reviewinsert").submit(function(event) {
			event.preventDefault();
			// serialize는 form의 <input> 요소들의 name이 배열형태로 그 값이 인코딩되어 URL query string으로 하는 메서드
			var queryString = $("#reviewinsert").serialize();
			//		action="${pageContext.request.contextPath}/auth/review"

			$.ajax({
				url : "http://localhost:8080/SpringShopping/auth/review",
				type : "POST",
				dataType : "text",
				data : queryString,
				success : function(result) {
					if (result == "error"){
						alert("리뷰내용을 작성해주세요")
					}
					else if (result == "success") {
						location.reload();
					}else{
						location.href='${pageContext.request.contextPath}/login.jsp';	
					}
				},
				error : function(error) {
					alert(error);
				}
			})
		});
	});
</script>

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
			<tr>	
			<td><p><c:out value="${product.product_name}"></c:out></p></td>
			<td><p><c:out value="${product.product_price}"></c:out></p></td>
			<td><p><c:out value="${product.product_desc}"></c:out></p></td>
			<td><p><c:out value="${product.product_url}"></c:out></p></td>
			</tr>
		<tr>
			<td><br>
				<h1>리뷰</h1></td>
		</tr>

		<c:forEach var="review" items="${review}">
		<tr>
			<td><p>
					<c:out value="${review.username}"></c:out>
				</p></td>
			<td><p>
					<c:out value="${review.product_name}"></c:out>
				</p></td>
			<td><p>
					<c:out value="${review.review_desc}"></c:out>
				</p></td>
			<td><p>
					<c:out value="${review.score}"></c:out>
				</p></td>
			<td><p>
					<c:out value="${review.date}"></c:out>
				</p></td>
		</tr>
		</c:forEach>	
	</table>
	<br>

	<c:if test="${paging.startPage != 1}">
		<a href="${pageContext.request.contextPath}/main/productlist/detail?productname=${product.product_name}&key=1">[처음]</a>
		<a href="${pageContext.request.contextPath}/main/productlist/detail?productname=${product.product_name}&key=${paging.startPage-10}">[이전]</a>
	</c:if>
	
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
		var="idx">
		<a href="${pageContext.request.contextPath}/main/productlist/detail?productname=${product.product_name}&key=${idx}">[${idx}]</a>
	</c:forEach>
	<c:if test="${key != paging.totalPage}">
		<a href="${pageContext.request.contextPath}/main/productlist/detail?productname=${product.product_name}&key=${paging.startPage+10}">[다음]</a>
		<a href="${pageContext.request.contextPath}/main/productlist/detail?productname=${product.product_name}&key=${paging.totalPage}">[끝]</a>
	</c:if>


	<br>
	<h1>리뷰작성</h1>
	<sf:form id ="reviewinsert" method="post"
		modelAttribute="reviewinsert">
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
