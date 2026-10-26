<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Student" %>
<%@ page import="dao.XDao" %>
<%
	XDao xDao = new XDao();
	List<Student> list = xDao.f();
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>학생 목록</title></head>
<body>
<table border="1">
  <tr><th>학번</th><th>이름</th><th>학과</th><th>성별</th><th>키</th><th>몸무게</th></tr>
<% for (Student s : list) { %>
  <tr>
    <td><%= s.getStu_no() %></td>
    <td><%= s.getStu_name() %></td>
    <td><%= s.getStu_dept() %></td>
    <td><%= s.getGender() %></td>
    <td><%= s.getStu_height() %></td>
    <td><%= s.getStu_weight() %></td>
  </tr>
<% } %>
</table>
</body>
</html>