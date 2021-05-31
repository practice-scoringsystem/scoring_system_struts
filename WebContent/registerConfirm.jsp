<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録確認画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div align="center">
		<h2>確認画面</h2>
		<s:form action="addAction">
			<p>
				問題:
				<s:textfield name="question" />
			</p>

			<s:iterator value="answers" var="answer">
				<p>
					答え:
					<td><s:textfield name="answer" /></td>
				</p>
			</s:iterator>
			<s:submit value="確認する" />
		</s:form>
	</div>
</body>
</html>