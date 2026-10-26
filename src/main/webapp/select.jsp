<%@page import="java.util.ArrayList"%>
<%@page import="domain.Student"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>학생 목록</h1>
	<hr>
	<table border="1">
		<tbody>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>학과</th>
				<th>학년</th>
			</tr>
			<!-- 목록데이터 items 가 var에 대입  항상된 for문과 동일--> 
			<c:forEach var="s" items="${students}">
				<tr>
					<!-- 학생 1명의 정보가 한 개 행에 표시됨 -->
					<td>${s.stu_no}</td>
					<td>${s.stu_name}</td>
					<td>${s.stu_dept}</td>
					<td>${s.stu_grade}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>