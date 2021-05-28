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
	<div align="center">
		<h2>編集画面</h2>
		<s:form action="confirmUpdateAction">
			<s:hidden name="id" readonly="true" />
			<p>
				問題:
				<s:textfield name="question" />
			</p>

			<s:hidden name="answerId" readonly="true" />
			<p>
				答え:
				<s:textfield name="answer" />
			</p>
			<s:submit value="更新する" />
		</s:form>
	</div>
</body>
</html>