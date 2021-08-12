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
	<h3>비교연산</h3>
	<hr>
	<p>
		같다(10 == 10) : ${10 == 10}<br>
		같다(10 eq 20) : ${10 eq 20}<br>
		같다("hello" eq "world") : ${"hello" eq "world"} <br>
		같지않다({"hello" != "world") : ${"hello" != "world"}<br>
		같지않다("hello" ne "world") : ${"hello" ne "world"}<br>
		크다(11 > 12) : ${11 > 12} <br>
		작다(11 < 12) : ${11 < 12} <br>
		크거나같다(10 >= 5) : ${10 >= 5}<br>
		크거나같다(10 ge 5) : ${10 ge 5}<br>
		작거나같다(10 <= 5) : ${10 <= 5}<br>
		작거나같다(10 le 5) : ${10 le 5}<br>
	</p>
</body>
</html>