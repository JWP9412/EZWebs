<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login JSP</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<%if(userid == null || userid.length() ==0){%>
	<h3>아이디를 입력하세요.</h3>
	<a href="login3.html">다시 로그인 하세여</a>
	<% } 
	else{ 
		if(userid.equals("manager")){
	%>
	<h2>매니저로 로그인 했습니다.</h2>
	<form type="button" value="정보수정"></form>
	<form type="button" value="정보삭제"></form>
	<%
		}
		else{
	%>
	<h3>환영합니다.</h3>
	<h3>아 이 디 : <%= userid %>님</h3>
	<%
		}
	}
	%>
</body>
</html>