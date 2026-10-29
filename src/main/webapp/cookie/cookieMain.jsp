<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 사용자 메인 페이지</h1>
<hr>

<p>${logid}님 환영합니다</p>
<p>지금까지 방문한 횟수는 총 ${result}회입니다</p>

<jsp:include page="notice.jsp" />

<a href="cookieLogin?action=logout">로그아웃</a>

<script>
	function update() {
		fetch("notice", { method: "POST" })
			.then(function(res) {
				return res.text();
			})
			.then(function(result) {
				if (result.trim() === "ok") {
					document.getElementById("noticeboard").style.display = "none";
				}
			});
	}

	var closeBox = document.getElementById("close");
	if (closeBox) {
		closeBox.addEventListener("change", function(e) {
			if (e.target.checked) {
				update();
			}
		});
	}
</script>
</body>
</html>