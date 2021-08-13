<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");

%>

<<c:set var="id" value="" scope="page"/>
<c:set var="name" value="${'Hong'}" scope="page"/>
<c:set var="age" value="${30}" scope="page"/>
<c:set var="height" value="${180}" scope="page"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Taglib - jstl</title>
</head>
<body>
	<h1>커스텀 태그 라이브러리</h1>
	<p> 선택문(c:choose / switch랑 비슷) </p>
	<hr>
	<table border='1'>
		<tr align="center" bgcolor="55aaff" >
			<td>아이디</td>
			<td>이름</td>
			<td>나이</td>
			<td>신장</td>
		</tr>
<c:choose>

	<c:when test="${empty id}">
		<tr>
			<td colspan="4">아이디가 없습니다</td>
		</tr>
	</c:when>
	
	<c:otherwise>
		<tr>
			<td>${id }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${height }</td>
		</tr>
	</c:otherwise>
		
</c:choose>
	</table>
</body>
</html>