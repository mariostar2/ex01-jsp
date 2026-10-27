<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%
pageContext.setAttribute("username", "James");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL 연습</h2>
	<hr>
	<!-- 4대 저장소의 값을 찾는 el문  -->
	<p>
		<c:out value="${username }" default="guest" />
	</p>
	<c:set var="hobby" value="coding" scope="page" />
	${pageScope.hobby }
	<br>
	<c:out value="${hobby }" />
	<c:set var="age" value="19"></c:set>
	<c:if test="${age > 20}">
		<p>성인입니다</p>
	</c:if>
	<c:if test="${age < 20}">
		<p>미성년입니다</p>
	</c:if>

	<c:choose>
		<c:when test="${age ge 20 }">
			<p>성인입니다</p>
		</c:when>

		<c:when test="${age lt 20 }">
			<p>미성년입니다</p>
		</c:when>

	</c:choose>
	<c:set var="score" value="80"></c:set>
	<c:choose>
		<c:when test="${score ge 90 }">
			<p>수입니다</p>
		</c:when>
		<c:when test="${score ge 80 }">
			<p>우입니다</p>
		</c:when>
		<c:when test="${score ge 70 }">
			<p>미입니다</p>
		</c:when>
		<c:when test="${score ge 60 }">
			<p>양입니다</p>
		</c:when>
		<c:otherwise>
			<p>그 이외입니다</p>
		</c:otherwise>
	</c:choose>

	<c:forEach var="i" begin="1" end="5" step="1">
		<p>${i }hi~</p>
	</c:forEach>
	<%
	String[] sArry = {"aaa","bbb","ccc"};
	pageContext.setAttribute("sArr", sArry);	
	%>
	<hr>
	<c:forEach var="s" items="${sArr}" varStatus="status">
		<p>${status.index })${s }</p>
	</c:forEach>
	<hr>
	<c:forEach var="s" items="${sArr }" varStatus="status">
		<p>${status.count })${s }</p>
	</c:forEach>
	<hr>
	<fmt:formatNumber value ="50000" type ="currency" currencySymbol ="$"/>
	<br>
	<fmt:formatNumber value = "1234567.89" pattern = "#,###.##"/>
	<br>
	<fmt:formatNumber value ="0.75" type ="percent"/><br>
	
	<%
		pageContext.setAttribute("today", new Date());
	%>
	<fmt:formatDate value ="${today}" /><br>
	<fmt:formatDate value= "${today }" pattern ="yyyy-MM-dd"/><br>
	<fmt:formatDate value= "${today }" pattern ="yyyy-MM-dd-HH:mm:ss"/><br>
	<fmt:formatDate value= "${today }" pattern ="yyyy 년 MM월 dd일 HH시 mm분 ss초"/><br>
</body>
</html>