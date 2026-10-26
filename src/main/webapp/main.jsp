<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
<h1>메인 페이지</h1>
<hr>
<div style="display:${empty sessionScope.loginId ? 'block' : 'none'}">
	<p>로그인이 필요합니다.</p>
	<a href="login">로그인</a>
</div>
<div style="display:${empty sessionScope.loginId ? 'none' : 'block'}">
	<p>${sessionScope.loginId}님 환영합니다!</p>
	<a href="sessionForm">성공 페이지</a>
	<a href="logout">로그아웃</a>
</div>
</body>
</html>