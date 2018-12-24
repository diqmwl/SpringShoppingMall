<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body onload='document.f.username.focus();'>
	<div id = "login-div">
		<h3>Login page</h3>
		<c:if test="${not empty logoutMsg}">
			<div style="color: #0000ff">
				<h3>${logoutMsg}</h3>
			</div>
		</c:if>
		<form name='f' action='${pageContext.request.contextPath}/login'
			method='POST'>
			<c:if test="${not empty errorMsg}">
				<div style="color: #ff0000">
					<h3>${errorMsg}</h3>
				</div>
			</c:if>
			<table>
				<tr>
					<td>Username:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Login" /></td>
				</tr>
				<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
			</table>
		</form>
	</div>
</body>
</html>