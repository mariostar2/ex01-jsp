<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 필터용</h1>
<hr>
	<%
		String id =  request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if("admin".equals(id)&& "1234".equals(pw)){
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(60 * 30);
			response.addCookie(cookie);
			response.sendRedirect("cookieMain.jsp");
		
			/* 재로그인시 쿠키 초기화 */
	/* 		Cookie noticeCookie = new Cookie("hideNotice","");
			noticeCookie.setMaxAge(0);
			noticeCookie.setPath("/");
			response.addCookie(noticeCookie); */
			
	
		}
		
		
	%>
</body>
</html>