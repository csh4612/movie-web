<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 수정과 삭제</title>
</head>
<body>
<%
Map<String,String> food = (Map<String,String>)request.getAttribute("food");
%>
	<h3>음식 수정과 삭제</h3>
	<form method="post" action="/food/update">
		<input type="hidden" name="fi_num" value="<%=food.get("fi_num")%>">
		음식 이름 : <input type="text" name="fi_name" value="<%=food.get("fi_name")%>"><br>
		음식 가격 : <input type="text" name="fi_price" value="<%=food.get("fi_price")%>"><br>
		음식 타입 : <input type="text" name="fi_type" value="<%=food.get("fi_type")%>"><br>
		<button>수정</button>
	</form>
	
	<form method="post" action="/food/delete">
		<input type="hidden" name="fi_num" value="<%=food.get("fi_num")%>">
		<button>삭제</button>
	</form>
</body>
</html>