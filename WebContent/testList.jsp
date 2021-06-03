<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト一覧</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<div align="center">
		<h2>テスト一覧</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>問題</th>
				<th>答え</th>
			</tr>
		</thead>

		<s:form action="testResultAction">
			<s:iterator value="qlist" var="q">
				<tr>
					<td><s:textfield name="questionIds" value="%{#q.id}" readonly="true" /></td>
					<td><s:textfield name="question" value="%{#q.question}" readonly="true" /></td>
					<td><s:textfield name="answers" /></td>
				</tr>
			</s:iterator>
			<td><s:submit value="採点する" /></td>
		</s:form>
	</table>
	</div>
</body>
</html>