<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<h1>파일 업로드 폼</h1>
<hr>
	<form action="../upload" method="post" enctype="multipart/form-data">
		작성자<input type ="text" name ="author"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>