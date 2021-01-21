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
<%
List<Map<String,String>> theaterList = (List<Map<String,String>>) request.getAttribute("theaterList");
%>
<h3>주차장 등록</h3>
<form method="post" action="park/insert">
주차장 이름 : <input type="text" name="tp_name"><br>
주차장 주소 : <input type="text" name="tp_address"><br>
주차장 전화번호 : <input type="text" name="tp_phone"><br>
극장 이름 : <select name="ti_num">
<option value="">선택</option>
<%
for(int i=0; i<theaterList.size();i++){
	Map<String,String> theater = theaterList.get(i);
%>	
<option value="<%=theater.get("ti_num")%>"><%=theater.get("ti_name")%></option>

<%
}
%>
</select><br>
<button>등록</button>
</form>
</body>
</html>