/*
 * 멤버로그인
 */
package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memberlogin")
public class MemberLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		boolean membered = isMember(userid, userpw);
		if(membered) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
		}
		
		resHTML(response.getWriter(), userid, membered);
	}
	
	static boolean isMember(String mid, String pwd) {
		MemberDBCP memberDBCP = new MemberDBCP();
		return memberDBCP.isMember(mid, pwd);
	}

	static void resHTML(PrintWriter out, String userid, boolean membered) {
		out.print("<html><body>");
		out.print("<h1>멤버 로그인</h1>");
		out.print("<hr>");
		
		if(membered) {
			out.printf("<p>로그인 성공</p>");
			out.printf("<p>환영합니다. (%s)님 </p>", userid);
			out.print("<a href='memberlist'>멤버리스트</a>");
		}
		else {
			out.printf("<p>(%s)는 존재하지 않는 멤버아이디입니다.</p>", userid);
			out.print("<a href='memberlogin.html'>다시 로그인 하세요</a>");
		}
		
		out.print("</body></html>");
	}
}
