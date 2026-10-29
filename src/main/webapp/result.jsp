<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id ="member" class = "domain.Member2" scope="page"/> 
	<jsp:setProperty property="*" name="member"/>

이름: <jsp:getProperty property="name" name="member"/>
나이: <jsp:getProperty property="age" name="member"/>
성별: <jsp:getProperty property="gender" name="member"/>
<hr>
이름(page) : ${member.name }<br>
</body>
</html>