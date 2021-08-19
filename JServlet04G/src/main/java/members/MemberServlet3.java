/*
 * http://localhost:8090/JServlet04/members2
 */
package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlist")
public class MemberServlet3 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MemberServlet3] (/memberlist), init...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemberServlet3] (/memberlist): GET");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemberServlet3] (/memberlist): POST");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String command = request.getParameter("command");
		if(command != null) {
			MemberDBCP memberDBCP = new MemberDBCP();
			
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
		}
		
		PrintWriter out = response.getWriter();
		
		outHtmlHeader(out);
		outHtmlMembers(out);
		outHtmlFooter(out);
	}
	
	static void outHtmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<h1>멤버 리스트</h1><hr>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td>");
		out.print("<td>이름</td>");
		out.print("<td>비밀번호</td>");
		out.print("<td>이메일</td>");
		out.print("<td>등록일자</td>");
		out.print("<td>삭제</td>");
		out.print("</tr>");
	}
	
	static void outHtmlMembers(PrintWriter out) {
		MemberDBCP memberDBCP = new MemberDBCP();
		List<MemberVO> members = memberDBCP.getMembers();
		
		for(int cnt=0; cnt < members.size(); cnt++) {
			MemberVO member = (MemberVO)members.get(cnt);
			out.print("<tr>");
			out.printf("<td>%s</td>", member.getMid());
			out.printf("<td>%s</td>", member.getMname());
			out.printf("<td>%s</td>", member.getPwd());
			out.printf("<td>%s</td>", member.getEmail());
			out.printf("<td>%s</td>", member.getRegdate());
			out.printf("<td><a href='/JServlet04G/memberlist?command=delMember&mid=%s'>삭제</a></td>", member.getMid());
			out.print("</tr>");
		}
	}
	
	static void outHtmlFooter(PrintWriter out) {
		out.print("</table>");
		out.print("<a href='/JServlet04G/memberlist.html'>멤버등록</a>");
		out.print("</body></html>");
	}

}
