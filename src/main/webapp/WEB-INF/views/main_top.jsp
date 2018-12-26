<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<table style="background-color: #F7BE81; text-align: center;">

		<tr style="background-color: #F7BE81; text-align: center;">
			<td><a
				href="${pageContext.request.contextPath}/">메인페이지</a></td>

			<td><a
				href="${pageContext.request.contextPath}/main/productlist">상품목록</a></td>

			<td><a href="${pageContext.request.contextPath}/main/cartlist">장바구니</a></td>

			<td><a href="${pageContext.request.contextPath}/main/orderlist">마이페이지</a></td>

			<td><a href="${pageContext.request.contextPath}/main/board">문의게시판</a></td>

			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td><a
					href="${pageContext.request.contextPath}/admin/productinsert">상품추가하기</a></td>
			</sec:authorize>

			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<td><a href="${pageContext.request.contextPath}/main/register">회원가입</a></td>

				<td><a href="${pageContext.request.contextPath}/login">로그인</a></td>
			</c:if>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<td><a
					href="javascript:document.getElementById('logout').submit()">로그아웃</a></td>
			</c:if>
		</tr>

	</table>
	<form id='logout' action='${pageContext.request.contextPath}/logout'
		method='POST'>
		<input name="${_csrf.parameterName}" type="hidden"
			value="${_csrf.token}" />
	</form>
</body>
</html>