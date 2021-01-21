<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 리스트</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>음식이름</th>
			<th>가격</th>
			<th>타입</th>
			<th>생성일</th>
			<th>생성시간</th>
		</tr>

		<%
			List<Map<String, String>> strList = (List<Map<String, String>>) request.getAttribute("list");
		    for (int i = 0; i < strList.size(); i++) {
			Map<String, String> food = strList.get(i);
		%>
		<tr>
			<td><%=food.get("fi_num")%></td>
			<td><a href="/food/update?fi_num=<%=food.get("fi_num")%>"><%=food.get("fi_name")%></a></td>
			<td><%=food.get("fi_price")%></td>
			<td><%=food.get("fi_type")%></td>
			<td><%=food.get("fi_credat")%></td>
			<td><%=food.get("fi_cretim")%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="6" align="right"><a href="/food/insert"><button>음식 등록</button></a></td>
		</tr>
	</table>
</body>
</html>