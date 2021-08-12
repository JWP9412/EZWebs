<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="members.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<% 
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="member" class="members.MemberVO"/>
<jsp:setProperty name="member" property="*"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 등록 및 조회</title>
</head>
<body>
	<h1>멤버 등록 확인</h1>
	<h3>Expression Language - useBean</h3>
	<p></p>
	<table>
		<tr bgcolor="66aabb">
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
		</tr>
		
		<tr>
			<td><%=member.getMid()%> </td>
			<td><%=member.getMname()%> </td>
			<td><%=member.getPwd()%> </td>
			<td><%=member.getEmail()%> </td>
		</tr>
		
		<tr>
			<td>${param.mid} </td>
			<td>${param.mname} </td>
			<td>${param.pwd} </td>
			<td>${param.email} </td>
		</tr>
		
	</table>
</body>
</html>