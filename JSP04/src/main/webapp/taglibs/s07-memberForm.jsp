<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 가입</title>
</head>
<body>
	<form name="member" method="post" action="s07-redirect.jsp">
		<table>
			<th>멤버 가입</th>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mid"></td>
			</tr>
			
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="mname"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			
			
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="멤버가입"></td>
				<td><input type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
	<hr>
</body>
</html>