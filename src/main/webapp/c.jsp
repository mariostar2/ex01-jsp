<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/* 묵시적 객체 */
	pageContext.setAttribute("y", "page-y");
	request.setAttribute("y", "request-y");
	session.setAttribute("y" ,"session-y");
	application.setAttribute("y", "application-y");
	
	

%>
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
<a href ="d.jsp">d.sjp로 가기</a>
<%--${y } page영역 --%>
<%--  ${requestScope.y }--%>
<%-- ${sessionScope.y } --%>
<%-- ${applicationScope.y } --%>
</body>
</html>