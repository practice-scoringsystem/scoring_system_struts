<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div align="center">
		<h2>編集画面</h2>
		<s:form action="confirmUpdateAction">
			<s:hidden name="id" />
			<p>
				問題:
				<s:textfield name="question" />
			</p>

			<s:iterator status="st" value="calist" var="ca">

				<s:hidden name="answerId" value="%{#ca.id}" />
				<td>答え:
					<s:textfield name="answer" value="%{#ca.answer}" />
				</td><br>
			</s:iterator>

			<s:submit value="確認する" />
		</s:form>
	</div>
</body>
</html>