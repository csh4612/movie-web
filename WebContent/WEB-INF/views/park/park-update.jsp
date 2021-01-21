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
	Map<String, String> park = (Map<String, String>) request.getAttribute("park");
	List<Map<String,String>> theaterList = (List<Map<String,String>>) request.getAttribute("theaterList");
	%>

	<form method="post" action="/park/update">
	     <input type="hidden" name="tp_num" value="<%=park.get("tp_num")%>">
	         주차장명 : <input type="text" name="tp_name" value="<%=park.get("tp_name")%>"><br>
	         주소 : <input type="text" name="tp_address" value="<%=park.get("tp_address")%>"><br>
	         전번 : <input type="text" name="tp_phone" value="<%=park.get("tp_phone")%>"><br>
	         극장명 : <Select name="ti_num">
	         <%
	         for(int i=0; i<theaterList.size();i++){
	        	 Map<String,String> theater = theaterList.get(i);
	        	 String selected = "";
	        	 if(park.get("ti_num").equals(theater.get("ti_num"))){
	        		 selected = "selected";
	        	 }
	         %>
	         <option value="<%=theater.get("ti_num")%>" <%=selected%>><%=theater.get("ti_name")%>
	         <%
	         }
	         %>
	         </Select><br>
	     <button>수정</button>
	</form>
	
	<form method="post" action="/park/delete">
	<input type="hidden" name="tp_num" value="<%=park.get("tp_num")%>">
	<button>삭제</button>
	</form>
</body>
</html>