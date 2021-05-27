<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>

	<div align="center">
		<h2>ログイン</h2>
		<s:form action="loginAction">
			<s:textfield name="userId" label="userId">ID:</s:textfield><br>
			<s:password name="password" label="password">パスワード:</s:password><br>
			<s:submit value="ログイン" />
		</s:form>
	</div>

</body>
</html>