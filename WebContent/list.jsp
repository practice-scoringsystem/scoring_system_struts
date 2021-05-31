<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問題・答え一覧</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div align="center">
		<a href="register.jsp">
			<button>新規登録</button>
		</a>
		<h2>一覧</h2>
	</div>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>問題</th>
				<th>答え1</th>
				<th>答え2</th>
				<th></th>
				<th></th>
			</tr>
		</thead>

		<s:iterator value="qlist" var="q">
			<!-- 問題 -->
			<tr>
				<td><s:property value="#q.id" /></td>
				<td><s:property value="#q.question" /></td>

				<!-- 答え -->
				<s:iterator value="calist" var="ca">
					<s:if test="%{#q.id == #ca.questionsId}">
						<td><s:property value="#ca.answer" /></td>
					</s:if>
				</s:iterator>

				<!-- 編集ボタン -->
				<td>
					<a href="editAction?id=<s:property value="#q.id" />">
						<button>編集</button>
					</a>
				</td>

				<!-- 削除ボタン -->
				<td>
					<a href="confirmDeleteAction?id=<s:property value="#q.id" />">
						<button>削除</button>
					</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>