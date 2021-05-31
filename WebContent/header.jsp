<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
	if (session.getAttribute("login_id") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<div>
		<a href="top.jsp">Topページ</a>
		<a href="logoutAction">ログアウト</a>
	</div>
</body>
</html>