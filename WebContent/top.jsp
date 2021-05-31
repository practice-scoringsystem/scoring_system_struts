<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Struts2のタグライブラリを使用可能にする -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- タイプ宣言はHTML5のものを使用する -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topページ</title>
    </head>
    <body>
    	<s:a action="logoutAction">ログアウト</s:a><br>
        <s:a action="listAction">問題と答えを確認する</s:a><br>
        <html:link href="#">テストをする</html:link><br>
        <html:link href="#">採点履歴を表示する</html:link>
    </body>
</html>