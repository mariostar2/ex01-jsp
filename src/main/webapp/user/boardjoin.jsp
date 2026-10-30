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
	<h1>회원 가입 폼</h1>
	<hr>
	<form action="${pageContext.request.contextPath}/boardjoin" method="post">
		<label>아이디:<input type="text" name="id"></label><br>
		 <label>비밀번호:<input type="password" name="pw"></label><br>
		<button type="submit">가입하기</button>
	</form>
</body>
</html>