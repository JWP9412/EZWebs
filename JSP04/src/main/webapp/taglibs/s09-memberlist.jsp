
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="java.util.* , members.*"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");	
%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Taglib - 멤버등록</title>
</head>
<body>
	<h1>커스텀 태그 라이브러리</h1>
	<p>멤버 등록</p>
	<p>이동경로 (forward) : memberForm.jsp ->member.jsp	-> memberlist.jsp</p>
	<hr>
	<table border='1' align="center">
		<tr align="center" bgcolor="lightblue">
			<td width="8%"><b>아이디</b></td>
			<td width="10%"><b>이름</b></td>
			<td width="10%"><b>비밀번호</b></td>
			<td width="20%"><b>이메일</b></td>
			<td width="20%"><b>등록일자</b></td>
		</tr>
<c:choose>
	<c:when test="${empty memberList}">
			<tr align="center">
				<td colspan="4">아이디가 없습니다.</td>
			</tr>
	</c:when>
	<c:otherwise>
		<c:forEach var="member" items="${memberList}">
			<tr align="center">
				<td><c:out value='${member.mid}'></c:out></td>
				<td><c:out value='${member.mname}'></c:out></td>
				<td><c:out value='${member.pwd}'></c:out></td>
				<td><c:out value='${member.email}'></c:out></td>
				<td><c:out value='${member.regdate}'></c:out></td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
	</table>
</body>
</html>