<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<table style="background-color: #F7BE81; text-align: center;">

		<tr style="background-color: #F7BE81; text-align: center;">

			<td><a href="login.jsp">로그인</a></td>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<td><a href="/logout">로그아웃</a></td>
			</c:if>
			<td><a href="productlist.jsp">상품목록</a></td>

			<td><a href="cartlist.jsp">장바구니</a></td>

			<td><a href="orderlist.jsp">마이페이지</a></td>

			<td><a href="board.jsp">문의게시판</a></td>

		</tr>

	</table>
</body>
</html>