<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 등록</title>
</head>
<body>
	<h3>음식 등록</h3>
	<form method="post" action="/food/insert">
		음식 이름 : <input type="text" name="fi_name"><br>
		음식 가격 : <input type="text" name="fi_price"><br>
		음식 타입 : <input type="text" name="fi_type"><br>
		<button>등록</button>
	</form>
</body>
</html>