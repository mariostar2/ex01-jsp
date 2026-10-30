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
<title>게시글 수정</title>
</head>
<body>
	<h1>수정 화면</h1>
	<hr>
	<form action="${pageContext.request.contextPath}/boardupdate" method="post" enctype="multipart/form-data">

		<input type="hidden" name="noticeNo" value="${me.noticeNo}">
		<input type="hidden" name="image" value="${me.noticeImage}">

		<table>
			<tr>
				<td>번호</td>
				<td>${me.noticeNo}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" value="${me.noticeName}" readonly></td>
			</tr>
			<tr>
				<td>올린 날짜</td>
				<td>${me.noticeDate}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${me.noticeTitle}"></td>
			</tr>
			<tr>
				<td>이미지 설명</td>
				<td><textarea name="content" rows="10" cols="40">${me.noticeForm}</textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>
					<img src="${pageContext.request.contextPath}/uploads/${me.noticeImage}" width="150"><br>
					새 이미지: <input type="file" name="file">
				</td>
			</tr>
		</table>

		<button type="submit">수정 완료</button>
	</form>

	<a href="${pageContext.request.contextPath}/boardlist">목록으로</a>
</body>
</html>