<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.List, customers.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>명령어 관리</title>
	</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	/*
	if(session != null){
		boolean isSession = request.isRequestedSessionIdValid();
		String userid = (String)session.getAttribute("userid");
		System.out.printf("[memberlist] userid : (%s)(%b)\n",userid,isSession);
		
		if(isSession != true || userid = null || userid.isEmpty()){
			response.sendRedirect("memberlogin.html");
			return;
		}
	}else{
		response.sendRedirect("memberlogin.html");
		return;
	}
	*/
	
	CustomerDBCP customerDBCP = new CustomerDBCP();
	
	String command = request.getParameter("command");
	if(command != null) {
		
		if(command.equals("insertCustomer")) {
			String cno   = request.getParameter("cno");
			String cname = request.getParameter("cname");
			String ctel   = request.getParameter("ctel");
			String address = request.getParameter("address");
			System.out.printf("[memberlist] insertCustomer: (%s)(%s)(%s)(%s)%n", cno, cname, ctel, address);
			
			if(cno != null && cno.isEmpty() != true) { 
				CustomerVO customer = new CustomerVO(cno, cname, ctel, address);
				customerDBCP.insertCustomer(customer);
			}
		}
		else if(command.equals("delCustomer")){
			String cno = request.getParameter("cno");
			System.out.printf("[memberlist] delCustomer: cno(%s)%n", cno);
	
			if(cno != null && cno.isEmpty() != true) { 
				customerDBCP.delCustomer(cno);
			}
		}
		else if(command.equals("editCustomer")) {
			String cno   = request.getParameter("cno");
			String cname = request.getParameter("cname");
			String ctel   = request.getParameter("ctel");
			String address = request.getParameter("address");
			System.out.printf("[memberlist] editCustomer: (%s)(%s)(%s)(%s)%n", cno, cname, ctel, address);
			
			if(cno != null && cno.isEmpty() != true) { 
				CustomerVO customer = new CustomerVO(cno, cname, ctel, address);
				customerDBCP.editCustomer(customer);
			}
		}
	}		
	
	List<CustomerVO> customers = customerDBCP.getCustomer();
	
	request.setAttribute("customers", customers);
	
	RequestDispatcher dispatch = request.getRequestDispatcher("customers.jsp");
	dispatch.forward(request, response);
%>
</body>
</html>