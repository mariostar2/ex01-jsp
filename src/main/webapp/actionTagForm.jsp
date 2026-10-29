<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="actionTagTest.jsp" method="post">
    <label for="userid">아이디</label>
    <input type="text" id="userid" name="userid"><br>
    <label for="userpw">암&nbsp;호</label>
    <input type="password" id="userpw" name="userpw"><br>
    <input type="radio" id="chk_user" name="loginCheck" value="user" checked>
    <label for="chk_user">사용자</label><br>
    <input type="radio" id="chk_manager" name="loginCheck" value="manager">
    <label for="chk_manager">관리자</label><br>
    <input type="submit" value="로그인">
</form>
<hr>

<jsp:include page ="inpage.jsp"/>
<p>x: ${x }</p>
<hr>
<%@include file ="inpage.jsp" %>
<p> x: ${x }</p>
</body>
</html>