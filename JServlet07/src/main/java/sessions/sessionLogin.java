/*
 *  세션(Session)
 *  
 *  request.getSession()
 *  	- 기존에 세션이 존재하면 그 세션을 반환하고 없으면 새로운 세션을 생성해서 반환
 */
package sessions;

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

@WebServlet("/sessionlogin")
public class sessionLogin extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		int login = -1;
		
		if(session.isNew()) {
				if(userid != null  && userid.isEmpty() != true) {
					session.setAttribute("userid", userid);
					login = 1;
				}
				else {
					session.invalidate();
				}
		}
		else {
				String uid = (String)session.getAttribute("userid");
				if(uid != null & uid.equals(userid)) {
					login = 0;
				}else {
					session.invalidate();
				}
		}
		
		resHTML(response.getWriter(),session, userid,login);
		
		if(login < 0) {
			session.invalidate();
		}
	}

	static void resHTML(PrintWriter out,HttpSession session, String userid,int login) {
		out.print("<html><body>");

		out.print("<h1>로그인 처리</h1>");
		out.print("<h3>세션으로 로그인 처리</h3>");
		
		if(session != null) {
		out.print("<hr>");
		out.printf("<p>세션 아이디: %s </p>", session.getId());
		out.printf("<h3>세션 유효시간: %d초 (%d분)</h3>", session.getMaxInactiveInterval(),session.getMaxInactiveInterval()/60);
		out.printf("<p>세션 생성시간: %s </p>", new Date(session.getCreationTime()));
		out.printf("<p>세션 최근접근: %s </p>", new Date(session.getLastAccessedTime()));
		out.printf("<p>새로운 세션: %b </p>", session.isNew());
		}
		
		out.print("<hr>");
		
		if(login == 1) {
			out.println("<p>로그인 성공</p>");
			out.printf("<p>환영합니다 : 아이디(%s)</p>",userid);
			
		}
		else if(login == 0 ) {
			out.println("<p>이미 로그인 상태입니다.</p>");
			out.printf("<p> 아이디(%s)</p>",userid);
			
		}
		else {
			out.print("<p>로그인 실패</p>");
			out.print("<a href='sessionlogin.html'>다시 시도해 주세</a>");
		}
		
		out.print("</body></html>");
	}

}
