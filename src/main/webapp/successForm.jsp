<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${sessionScope.loginid }님의 마이페이지 입니다</h1>
<p>로그인한 사용자만 보는게 가능합니다</p>
<a href="logout">로그아웃</a>
</body>
</html>