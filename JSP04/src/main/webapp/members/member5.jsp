<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="members.*"
	import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<% 
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="member" class="members.MemberVO"/>
<jsp:setProperty name="member" property="*"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>
<jsp:useBean id="memberMap" class="java.util.HashMap"/>

<%
	MemberVO member2 = new MemberVO("3437","삼사삼사","3434","3434@3434.com");
	memberList.add(member);
	memberList.add(member2);
	
	memberMap.put("title","멤버 리스트");
	memberMap.put("memberList",memberList);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 등록 및 조회</title>
</head>
<body>
	<h1>멤버 등록 확인</h1>
	<h3>Expression Language - useBean</h3>
	<p>ArrayList, HashMap 사용</p>
	<p></p>
	<table>
	<th>${memberMap.title}</th>
		<tr bgcolor="66aabb">
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
		</tr>
		
		<tr>
			<td>${memberMap.memberList[0].mid}</td>
			<td>${memberMap.memberList[0].mname}</td>
			<td>${memberMap.memberList[0].pwd}</td>
			<td>${memberMap.memberList[0].email}</td>
			
		</tr>
		
		<tr>
			<td>${memberMap.memberList[1].mid}</td>
			<td>${memberMap.memberList[1].mname}</td>
			<td>${memberMap.memberList[1].pwd}</td>
			<td>${memberMap.memberList[1].email}</td>
			
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