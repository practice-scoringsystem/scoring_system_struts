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
	</div>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>問題</th>
				<th>答え</th>
			</tr>
		</thead>

		<s:iterator value="qlist" var="q">
			<!-- 問題 -->
			<tr>
				<td><s:property value="#q.id" /></td>
				<td><s:property value="#q.question" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>