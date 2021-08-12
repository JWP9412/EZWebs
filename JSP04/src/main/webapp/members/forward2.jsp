<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  	request.setCharacterEncoding("utf-8");
	request.setAttribute("address", "경기도 성남시");
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward to member2.jsp</title>
	</head>
	
	<body>
		<jsp:forward page="member2.jsp"></jsp:forward>
	</body>
</html>