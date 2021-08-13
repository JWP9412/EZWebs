<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="java.util.* , members.*"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<p>멤버 등록</p>
<p>이동경로 : memberForm.jsp -> redirect.jsp -> member.jsp
	<c:redirect url="s07-member.jsp">
		<c:param name ="mid" value="${param.mid}"/>
		<c:param name ="mname" value="${param.mname}"/>
		<c:param name ="pwd" value="${param.pwd}"/>
		<c:param name ="email" value="${param.email}"/>
	</c:redirect>
</body>
</html>