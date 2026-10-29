<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>로그아웃 필터용 </h1>
<body>
	<%
		Cookie cookie =  new Cookie("id", "");
		//로그아웃할때 	
		cookie.setMaxAge(0); 
		//response로 추가
		response.addCookie(cookie); 
		response.sendRedirect("logincookie.jsp");
	

	
			
	%>
</body>
</html>