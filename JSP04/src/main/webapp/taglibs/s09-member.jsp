<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
	import="java.util.* , members.*"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="memberBean" class="members.MemberVO"/>
<jsp:setProperty name="memberBean" property="*"/>

<%
	request.setCharacterEncoding("utf-8");	

	MemberDBCP memberDBCP = new MemberDBCP();
	memberDBCP.addMember(memberBean);
	List memberList = memberDBCP.getMembers();
	request.setAttribute("memberList", memberList);
%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Taglib - forward</title>
</head>
<body>
	<jsp:forward page="s09-memberlist.jsp"></jsp:forward>
<!-- 
	<c:redirect url="s07-member.jsp">
		<c:param name ="mid" value="${param.mid}"/>
		<c:param name ="mname" value="${param.mname}"/>
		<c:param name ="pwd" value="${param.pwd}"/>
		<c:param name ="email" value="${param.email}"/>
	</c:redirect>
 -->	
</body>
</html>