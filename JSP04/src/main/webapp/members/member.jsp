<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<% 
	request.setCharacterEncoding("UTF-8");

	String mid =request.getParameter("mid");
	String mname =request.getParameter("mname");
	String pwd =request.getParameter("pwd");
	String email =request.getParameter("email");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 등록 및 조회</title>
</head>
<body>
	<h1>멤버 등록 확인</h1>
	<h3>Expression Language - param</h3>
	<p>표현언어의 내장 객체인 param.name을 사용하면
	request.getParameter(name)을 대체할 수 있다.</p>
	<table>
		<tr bgcolor="66aabb">
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
		</tr>
		
		<tr>
			<td><%=mid%> </td>
			<td><%=mname%> </td>
			<td><%=pwd%> </td>
			<td><%=email%> </td>
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