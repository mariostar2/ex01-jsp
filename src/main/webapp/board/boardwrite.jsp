<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<style>
textarea{
	resize:none;

}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 작성 페이지</h1>
	<form action="${pageContext.request.contextPath}/boardwrite" method = "post" enctype="multipart/form-data">
		<table>
			<tr>
			<td>작성자<input type = "text" value="${sessionScope.loguser.id}"></td>
			</tr>
			<tr>
			<td>제목<input type="text"name ="title"></td>
			</tr>
			<tr>
			<td>이미지설명<textarea name="content" rows="10" cols="10" ></textarea></td>
			</tr>
			<tr>
			<td>이미지파일<input type="file" name="file"></td>
			</tr>
		</table>
		<button type ="submit">등록</button>
	</form>
</body>
</html>