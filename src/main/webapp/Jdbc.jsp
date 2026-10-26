<%@page import="domain.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%
 	/* JDBC 연동 */
 	Class.forName("oracle.jdbc.OracleDriver");
 
 	Connection conn = DriverManager.getConnection(
 		"jdbc:oracle:thin:@localhost:1521:testdb",
 		"green",
 		"1234"
 	);
 
 	Statement stmt = conn.createStatement();
 	ResultSet rs = stmt.executeQuery("SELECT * FROM student");
 	
 	//ArrayList<Student> list = new ArrayList<>();
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		text-align: center;
	}
	
	td{
		border : 2px solid black; 	
	}

</style>
</head>
<body>
 <table>
 		<tr>
 			<td>학번</td>
 			<td>이름</td>
 			<td>전공</td>
 			<td>성별</td>
 		</tr>
 <tbody>

<%
	while(rs.next()){
%>
<tr>
	<td><%= rs.getInt("stu_no") %></td>
	<td><%= rs.getString("stu_name") %></td>
	<td><%= rs.getString("stu_dept") %></td>
	<td><%= rs.getString("stu_gender") %></td>
</tr>
<%
	} 
%>
</tbody>
</table>
</body>
</html>