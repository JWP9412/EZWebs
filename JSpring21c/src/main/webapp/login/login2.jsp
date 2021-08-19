<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인 2</title>
</head>
<body>
	<h1>로그인 2</h1>
	<table border="1" width="50%">
	
	   <tr>
	      <td>아이디</td>
	      <td>비밀번호</td>
	   </tr>
	   <tr>
	      <td>${userID}</td>
	      <td>${passwd}</td>
	   </tr>
	</table>
</body>
</html>
