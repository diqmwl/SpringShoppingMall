<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" ; charset=utf-8">
<title>Create Offer</title>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/main/docreate"
		modelAttribute="user">
		<table class="formtable">
			<tr>
				<td class="label">아이디:</td>
				<td><sf:input class="control" type="text" path="username" /><br />
					<sf:errors path="username" class="error" /></td>
			</tr>
			<tr>
				<td class="label">비밀번호:</td>
				<td><sf:input class="control" type="text" path="password" /><br />
					<sf:errors path="password" class="error" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="submit" /></td>
			</tr>
			<tr>
				<td><sf:input class="control" type="hidden" value="1"
						path="enabled" /><br />
			</tr>
		</table>
	</sf:form>

</body>
</html>
