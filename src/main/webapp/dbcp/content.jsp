	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	<h1>Content page</h1>
	<hr>
		<%
			int result = 0;
			Cookie[] cookies =  request.getCookies();	
		%>
		<%
		if(cookies != null){
			for(Cookie c : cookies){
			 	String cookiesName =  c.getName();
			}
		}
		%>
		<p>방문한 적이 몇번? <%= result %><br>
		<a href = "session_info_jsp">뒤로가기</a>
	</body>
	</html>