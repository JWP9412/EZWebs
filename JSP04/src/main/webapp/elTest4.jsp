<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Expression Language</title>
</head>
<body>
	<h1>Expression Language</h1>
	<h3>논리연산</h3>
	<hr>
	<p>
		논리곱 (10 == 10 && 10 != 20) : ${10 == 10 && 10 != 20}<br>
		논리합 (10 == 10 || 10 == 20) : ${10 == 10 || 10 == 20}<br>
		부정 (!(10 != 10)0) : ${!(10 != 10)}<br>
	</p>
</body>
</html>