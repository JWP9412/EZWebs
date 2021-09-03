<%@page import="java.util.List"%>
<%@page import="members.MemberVO"%>
<%@page import="members.MemberDBCP"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="membervo" class="members.MemberVO" scope="page"></jsp:useBean>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

MemberDBCP memberDBCP = new MemberDBCP(); 

String command = request.getParameter("command");
if(command != null) {
	
	if(command.equals("addMember")) {
		String mid   = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String pwd   = request.getParameter("pwd");
		String email = request.getParameter("email");
		System.out.printf("[memberlist] addMember: (%s)(%s)(%s)(%s)%n", mid, mname, pwd, email);
		
		if(mid != null && mid.isEmpty() != true) { 
			MemberVO member = new MemberVO(mid, mname, pwd, email);
			memberDBCP.addMember(member);
		}
	}
	else if(command.equals("delMember")){
		String mid = request.getParameter("mid");
		System.out.printf("[memberlist] delMember: mid(%s)%n", mid);

		if(mid != null && mid.isEmpty() != true) { 
			memberDBCP.delMember(mid);
		}
	}
	else if(command.equals("editMember")) {
		String mid   = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String pwd   = request.getParameter("pwd");
		String email = request.getParameter("email");
		System.out.printf("[memberlist] editMember: (%s)(%s)(%s)(%s)%n", mid, mname, pwd, email);
		
		if(mid != null && mid.isEmpty() != true) { 
			MemberVO member = new MemberVO(mid, mname, pwd, email);
			memberDBCP.updateMember(member);
		}
	}
}		

List<MemberVO> members = memberDBCP.getMembers();

request.setAttribute("members", members);

RequestDispatcher dispatch = request.getRequestDispatcher("memberview");
dispatch.forward(request, response);

%>
</body>
</html>