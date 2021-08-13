<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");

%>

<c:set var="hello" value="Hello, Taglib(jstl)" scope="page"/>
<c:set var="name" value="${'Hong'}" scope="page"/>
<c:set var="age" value="${30}" scope="page"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Taglib - jstl</title>
</head>
<body>
	<h1>커스텀 태그 라이브러리 - JSTL</h1>
	<p> c:remove -> 변수 제거 </p>
	<hr>

	<p>hello : ${hello}</p>
	<p>name : ${name}</p>
	<p>age : ${age}</p>
	<hr>
	
<c:remove var="hello"/>

	<p>hello : ${hello}</p>
	<p>name : ${name}</p>
	<p>age : ${age}</p>
	<hr>
</body>
</html>