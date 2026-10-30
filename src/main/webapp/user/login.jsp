<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action ="${pageContext.request.contextPath}/boardlogin" method ="post"> 
		<label>아이디:<input type="text" name="id"></label><br>
		<label>비밀번호:<input type="password" name="pw"></label>
		<button type ="submit">로그인</button>
	</form>
	<a href ="${pageContext.request.contextPath}/boardjoin">회원가입</a>
</body>
</html>