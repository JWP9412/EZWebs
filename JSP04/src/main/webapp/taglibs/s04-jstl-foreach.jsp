<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List listx = new ArrayList();
	listx.add("hello");
	listx.add("world");
	listx.add("welcome");
%>

<c:set var="lists" value="<%=listx %>"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Taglib - jstl</title>
</head>
<body>
	<h1>커스텀 태그 라이브러리</h1>
	<p> 반복문(c:foreach) </p>
	<hr>
	<c:forEach var="data" items="${lists}" varStatus="loop">
		<p>[${data}] : index(${loop.index}), count(${loop.count}), first(${loop.first}), last(${loop.last})</p>
	</c:forEach>
	<hr>
</body>
</html>