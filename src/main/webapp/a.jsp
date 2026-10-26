<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String s = "hello";
	pageContext.setAttribute("s",s);
	//<a href = "a.jsp?x=xxx">a.jsp로 이동</a>	
	//String param = request.getParameter("x");
	/* index -> a.jsp의 데이터를 받아 b로 바로 전달함 */
	request.setAttribute("x","good-bye" );
	request.getRequestDispatcher("b.jsp").forward(request, response);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>a.jsp</h1>
<hr>
<p>${s }</p>
<a href = "b.jsp">b.jsp로 이동</a>
</body>
</html>