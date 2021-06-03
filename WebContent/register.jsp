<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div align="center">
		<h2>新規登録</h2>

		<s:actionerror />

		<s:form action="confirmAddAction">
			<p>
				問題:
				<s:textfield name="question" />
			</p>
			<p>
				答え:
				<s:textfield name="answers" />
			</p>

			<p>
				答え:
				<s:textfield name="answers" />
			</p>
			<s:submit value="確認する" />
		</s:form>
	</div>
</body>
</html>