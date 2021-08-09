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

@WebServlet("/sessiontest")
public class sessionTest extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();
		
		resHTML(response.getWriter(),session);
	}

	static void resHTML(PrintWriter out,HttpSession session) {
		out.print("<html><body>");

		
		out.print("<h1>쿠키 세션 처리</h1>");
		out.printf("<p>기본 유지시간 : 30분</p>");
		
		out.print("<hr>");
		out.printf("<p>세션 아이디: %s </p>", session.getId());
		
		out.printf("<p>세션 유효시간: %d 초 %d 분</p>", session.getMaxInactiveInterval(),session.getMaxInactiveInterval()/60);
		out.printf("<p>세션 생성시간: %s </p>", new Date(session.getCreationTime()));
		out.printf("<p>세션 최근접근: %s </p>", new Date(session.getLastAccessedTime()));
		out.printf("<p>새로운 세션: %b </p>", session.isNew());

		out.print("</body></html>");
	}

}
