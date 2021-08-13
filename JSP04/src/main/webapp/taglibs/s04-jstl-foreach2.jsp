<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="java.util.* , members.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List memberx = new ArrayList();

	MemberVO m1 = new MemberVO("1000","one","1111","1@1.com");
	MemberVO m2 = new MemberVO("2000","two","2222","2@1.com");
	MemberVO m3 = new MemberVO("3000","three","3333","3@1.com");
	MemberVO m4 = new MemberVO("4000","four","4444","4@1.com");

	memberx.add(m1);
	memberx.add(m2);
	memberx.add(m3);
	memberx.add(m4);
	
%>

<c:set var="members" value="<%=memberx%>"/>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Taglib - jstl</title>
</head>
<body>
	<h1>커스텀 태그 라이브러리</h1>
	<p> 반복문(c:forEach) - ArrayList 사용 </p>
	<p> 배열 객체를 만든 후 set으로 값을 세팅 후 참조를 해야한다.</p>
	<hr>
	<table border='1' align="center">
		<tr align="center" bgcolor="lightblue">
			<td width="8%"><b>아이디</b></td>
			<td width="10%"><b>이름</b></td>
			<td width="10%"><b>비밀번호</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		<!-- members 배열의 갯수를 알고 있는 경우 -->
		<c:forEach var="cnt" begin="0" end="3" step="1">
			<tr align="center">
				<td>${members[cnt].mid}</td>
				<td>${members[cnt].pwd}</td>
				<td>${members[cnt].mname}</td>
				<td>${members[cnt].email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>