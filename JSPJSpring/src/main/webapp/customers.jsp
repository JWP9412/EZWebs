<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, customers.*" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="customers" class="customers.CustomerVO" scope="page"></jsp:useBean>
<%
String cno = request.getParameter("cno");
String cname = request.getParameter("cname");
String ctel = request.getParameter("ctel");
String address = request.getParameter("address");

customers.setCno(cno);
customers.setCname(cname);
customers.setCtel(ctel);
customers.setAddress(address);

CustomerDBCP customerDBCP = new CustomerDBCP();
customerDBCP.insertCustomer(customers);

List<CustomerVO> customerList = customerDBCP.getCustomer();
//List<CustomerVO> customerList = (List<CustomerVO>)request.getAttribute("customers");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 조회</title>
</head>
<body>
	<table border="1">
		<tr bgcolor="lightblue">
			<td>고객번호</td>
			<td>고객이름</td>
			<td>전화번호</td>
			<td>고객주소</td>
			<td>수정</td>
			<td>삭제</td>
			
		</tr>

		<%
		for (int cnt = 0; cnt < customerList.size(); cnt++) {
			CustomerVO cus = (CustomerVO)customerList.get(cnt);
		%>
		<tr>
			<td><%=cus.getCno()%></td>
			<td><%=cus.getCname()%></td>
			<td><%=cus.getCtel()%></td>
			<td><%=cus.getAddress()%></td>
			<td><a href='#'>수정</a></td>
			
			<td><a href='commandlist.jsp?command=delCustomer&cno=<%=cus.getCno()%>' >삭제</a></td>
		
		</tr>

		<%
		}
		%>


	</table>
</body>
</html>