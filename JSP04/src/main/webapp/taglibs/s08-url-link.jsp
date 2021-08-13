<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="java.util.* , members.*"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="memberurl" value="s08-member.jsp">
		<c:param name ="mid" value="7070"/>
		<c:param name ="mname" value="Se7en"/>
		<c:param name ="pwd" value="7070"/>
		<c:param name ="email" value="sv@sv.sv"/>
</c:url>

<%
	request.setCharacterEncoding("utf-8");	
%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Taglib - redirect</title>
</head>
<body>
<h1>커스텀 태그 라이브러리</h1>
	<hr>
	<a href='${memberurl}'>멤버조회</a>
</body>
</html>