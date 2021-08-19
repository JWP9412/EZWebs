/*
 * http://localhost:8090/JServlet04/members
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

@WebServlet("/members")
public class MemberServlet extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MemberServlet] init...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		outHtmlHeader(out);
		outHtmlMembers(out);
		outHtmlFooter(out);
	}
	
	static void outHtmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td>");
		out.print("<td>이름</td>");
		out.print("<td>비밀번호</td>");
		out.print("<td>이메일</td>");
		out.print("<td>등록일자</td>");
		out.print("</tr>");
	}
	
	static void outHtmlMembers(PrintWriter out) {
		MemberDAO memberDAO = new MemberDAO();
		List<MemberVO> members = memberDAO.getMembers();
		
		for(int cnt=0; cnt < members.size(); cnt++) {
			MemberVO member = (MemberVO)members.get(cnt);
			out.print("<tr>");
			out.printf("<td>%s</td>", member.getMid());
			out.printf("<td>%s</td>", member.getMname());
			out.printf("<td>%s</td>", member.getPwd());
			out.printf("<td>%s</td>", member.getEmail());
			out.printf("<td>%s</td>", member.getRegdate());
			out.print("</tr>");
		}
	}
	
	static void outHtmlFooter(PrintWriter out) {
		out.print("</table>");
		out.print("</body></html>");
	}

}
