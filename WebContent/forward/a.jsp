<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나는 a.jsp<br>
<%=request.getParameter("num") %>
<%
// response의 sendRedirect 같은 경우에는 해당 주소로 이동한다고 생각하면 됨.
// response.sendRedirect("/forward/b.jsp");
// ReuqestDispatcher의 forward 같은 경우는 요청한 애용을 그대로 가지고
// 해당 리소스로 이동한다고 생각하면 됨.

request.setAttribute("msg","야 조심해");
RequestDispatcher rd = request.getRequestDispatcher("/forward/b.jsp");
rd.forward(request, response);
%>
</body>
</html>