<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>${pageScope.y }</p>
<p>${requestScope.y }</p>
<p>${sessionScope.y }</p>
<p>${applicationScope.y }</p>
</body>
</html>