<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div align="center">
		<h2>削除確認画面</h2>
		<s:form action="deleteAction">
			<s:hidden name="id" readonly="true" />
			<p>
				問題:
				<s:textfield name="question" readonly="true" />
			</p>

			<s:iterator value="calist" var="ca">
				<s:hidden name="#ca.id" readonly="true" />
				<td>答え:
					<s:textfield name="#ca.answer" readonly="true"/>
				</td><br>
			</s:iterator>
			<s:submit value="削除する" />
		</s:form>
	</div>
</body>
</html>