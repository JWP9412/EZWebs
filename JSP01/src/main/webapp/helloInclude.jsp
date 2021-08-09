<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Directive Tag</title>
</head>
<body>
	<h1>인클루드 디렉티브(include)</h1>
	<hr>
	<h3>이 페이지는 메인 페이지에 포함된 내용입니다.</h3>
	<%@ include file="content.jsp" %>
	<h3>이 페이지는 메인 페이지의 꼬릿말 내용입니다.</h3>
</body>
</html>