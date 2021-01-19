<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>영화관 등록</h3>
	<form method="post" action="/theater/insert">
		영화관 이름 : <input type="text" name="ti_name"><br>
              영화관 주소 : <input type="text" name="ti_address"><br>
              영화관 전화번호 1 : <input type="text" name="ti_phone1"><br>
              영화관 전화번호 2 : <input type="text" name="ti_phone2"><br>
        <button>영화관 등록</button>
    </form>
</body>
</html>