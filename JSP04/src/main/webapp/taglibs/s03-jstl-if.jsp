<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");

%>

<c:set var="id" value="1234" scope="page"/>
<c:set var="name" value="${'Hong'}" scope="page"/>
<c:set var="age" value="${30}" scope="page"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Taglib - jstl</title>
</head>
<body>
	<h1>커스텀 태그 라이브러리 - IF</h1>
	<p> 조건식(c:if) </p>
	<hr>
	<c:if test="${! empty id}">
		<p>! empty id </p>
		<p>id: ${id}</p>
		<hr>
	</c:if>
	
	<c:if test="${not empty id}">
		<p>not empty id </p>
		<p>id: ${id}</p>
		<hr>
	</c:if>
	
	<c:if test="${empty id}">
		<p>empty id </p>
		<p>id: ${id}</p>
		<hr>
	</c:if>
	
	<c:if test='${age > 19}'>
		<p> ${name}은 성인입니다.</p>
		<p>age : ${age}</p>
	</c:if>
	
</body>
</html>