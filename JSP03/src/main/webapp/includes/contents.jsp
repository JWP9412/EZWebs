<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	request.setCharacterEncoding("utf-8");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contents JSP</title>
</head>
<body>
	<h1>인클루드 액션 태그</h1>
	<jsp:include page="content.jsp" flush="true">
		<jsp:param name="content" value="사용설명서"/>
		<jsp:param name="imagename" value="goods.jpg"/>
		
	</jsp:include>
</body>
</html>