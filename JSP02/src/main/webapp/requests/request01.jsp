<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("name", "홍길동");
	request.setAttribute("tel", "031-1000-1234");
%>

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Request Attribute</title>
</head>
<body>
	<h1>요청 속성 처리</h1>
	<hr>
	<p>요청으로 이름(name)과 전화번호(tel)을 request02.jsp로 전달</p>
	<%
		RequestDispatcher dispatch = request.getRequestDispatcher("request02.jsp");
		dispatch.forward(request, response);
	%>
</body>
</html>