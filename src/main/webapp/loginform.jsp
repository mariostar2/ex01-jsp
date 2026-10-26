<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	boolean getLoginForm(String id, String pws){
		return "admin".equals(id) && "1234".equals(pws); 
		
	}	
%>
<%
/* 아이디와 패스워드 값을 파라미터 값으로 받아서 저장  */
	String id = request.getParameter("id");
	String pws = request.getParameter("pws");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<% if(getLoginForm(id,pws)){ %>
		<h1>로그인 성공하였습니다</h1>
		<p><%= id %>님, 환영합니다</p>
	<% }else { %>
		<h1>로그인에 실패하였습니다</h1>
	<% } %>
	<a href = "login.jsp">돌아가기</a>
</body>
</html>