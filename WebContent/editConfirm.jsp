<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集確認画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div align="center">
		<h2>編集確認画面</h2>
		<s:form action="updateAction">
			<s:hidden name="id" />
			<p>
				問題:
				<s:textfield name="question" readonly="true" />
			</p>

			<s:iterator value="answerId" var="aId">
				<s:hidden name="answerId" value="%{#aId}" />
			</s:iterator>
			<s:iterator value="answer" var="ans">
				<td>答え:
					<s:textfield name="answer" value="%{#ans}" readonly="true" />
				</td><br>
			</s:iterator>

			<s:submit value="更新する" />
		</s:form>
	</div>
</body>
</html>