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
	<p>isELIgnored=false</p>
	<hr>
	<p>
		정수 : ${1234} <br>
		문자열 : ${"Hello, EL!!!"} <br>
		덧셈 : ${10+99}<br>
		문자열(숫자)+ 숫자 : ${"1" + 99}
		
		
	</p>
</body>
</html>