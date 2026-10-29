<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="jakarta.tags.core" %>

<%
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	String loginCheck = request.getParameter("loginCheck");
	pageContext.setAttribute("userid", userid);
	pageContext.setAttribute("loginCheck",loginCheck);

%>
<!-- jsp:액션태그 $:el 표현식 c:jstl -->
	<c:if test='${loginCheck == "user"}'>
		<jsp:forward page ="userMain.jsp">
			<jsp:param name ="userid" value="${userid}"/>
		</jsp:forward>
	</c:if>
	<c:if test='${loginCheck == "manager"}'>
		<jsp:forward page ="managerMain.jsp">
			<jsp:param name ="userid" value="${userid}"/>
		</jsp:forward>
	</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>