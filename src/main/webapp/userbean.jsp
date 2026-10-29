<%@page import="domain.Member2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- bean는 set,get 속성 사용시 name   -->
	<jsp:useBean id ="bean" class="domain.Member2"/>
	<jsp:setProperty property="name" name="bean" value="철수"/>
	<jsp:setProperty property="age" name="bean" value="30"/>
	<jsp:setProperty property="gender" name="bean" value="남자"/>
	
	이름: <jsp:getProperty property="name" name="bean"/>
	나이: <jsp:getProperty property="age" name="bean"/>
	성별: <jsp:getProperty property="gender" name="bean"/>
	<hr>
	
</body>
</html>