<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>나의 세션 정보</h1>
<hr>
<%
	session.setAttribute("id","abc");
	session.setAttribute("pw", "1234");
	session.setAttribute("name" , "name");
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	out.println(id + "<br>");
	out.println(pw + "<br>");
	
	Enumeration<String>names = session.getAttributeNames();
	while(names.hasMoreElements()){
		String name =  names.nextElement();
		String value = session.getAttribute(name).toString();
		out.print(name + " :" + value + "<br>");
	}	
%>
<a href = "session_info.jsp">세션 정보 보기</a>
</body>
</html>