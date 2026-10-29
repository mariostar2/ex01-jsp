	
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	
	<body>
		<h1>쿠키용 로그인 화면 구현</h1>
		<form id="loginfofm">
			<label>아이디<input type="text" name="id"></label><br> <label>비밀번호<input
				type="password" name="pw"></label><br>
			<button type="submit">로그인</button>
		</form>
		<script>
		document.getElementById("loginfofm").addEventListener("submit", function(e) {
			e.preventDefault();
			var data = new URLSearchParams(new FormData(e.target));
			fetch("cookieLogin", {
				method : "POST",
				body : data
			}).then(function(res) {
				return res.text();
			}).then(function(result) {
				if (result.trim() === "success") {
					location.href = "cookieLogin";
				} else {
					alert("아이디 비밀번호 오류");
				}
			});
		});
		</script>
	</body>
	</html>