<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト採点結果</title>
</head>
<body>
	<h2>テスト採点結果</h2>
	<a><s:property value="userName" />さん</a><br>
	<a>
		<s:property value="questionCount" />問中
		<s:property value="score" />問正解です。
	</a><br>
	<a>
		<s:property value="result" />点でした。
	</a>
</body>
</html>