<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화관 등록</title>
</head>
<body>
<%
Map<String,String> theater = (Map<String,String>)request.getAttribute("theater");
%>
	<h3>영화관 등록</h3>
	<form method="post" action="/theater/update">
		<input type="hidden" name="ti_num" value="<%=theater.get("ti_num")%>">
		영화관이름 : <input type="text" name="ti_name" value="<%=theater.get("ti_name")%>"><br>
		영화관주소 : <input type="text" name="ti_address" value="<%=theater.get("ti_address")%>"><br>
		전화번호1 : <input type="text" name="ti_phone1" value="<%=theater.get("ti_phone1")%>"><br>
		전화번호2 : <input type="text" name="ti_phone2" value="<%=theater.get("ti_phone2")%>"><br>
		<button>수정</button>
	</form>
	
	<form method="post" action="/theater/delete">
		<input type="hidden" name="ti_num" value="<%=theater.get("ti_num")%>">
		<button>삭제</button>
	</form>
</body>
</html>