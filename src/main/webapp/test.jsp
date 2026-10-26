<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test.jsp</h1>
<hr>
<p>${requestScope.x }</p>
<p>${sessionScope.x }</p>
<p>${applicationScope.x }</p>
</body>
</html>