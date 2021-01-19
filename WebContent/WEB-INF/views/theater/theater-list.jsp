<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>영화관</th>
			<th>주소</th>
			<th>전화번호1</th>
			<th>전화번호2</th>
		</tr>

		<%
			List<Map<String, String>> strList = (List<Map<String, String>>) request.getAttribute("list");
		    for (int i = 0; i < strList.size(); i++) {
			Map<String, String> theater = strList.get(i);
		%>
		<tr>
			<td><%=theater.get("ti_num")%></td>
			<td><%=theater.get("ti_name")%></td>
			<td><%=theater.get("ti_address")%></td>
			<td><%=theater.get("ti_phone1")%></td>
			<td><%=theater.get("ti_phone2")%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="5" align="right"><a href="/theater/insert"><button>영화관 등록</button></a></td>
		</tr>
	</table>
</body>
</html>