/*
 * [세션쿠키]
 * 		- 브라우저가 사용하는 메모리에 저장
 */
package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/setsessioncookies")
public class SetSessionCookies extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		Cookie hellosession = new Cookie("hellosessioncookie", URLEncoder.encode("Hello Session Cookie(Session)","utf-8"));
		hellosession.setMaxAge(-1); // 세션쿠키(-1 대입)
		response.addCookie(hellosession);
		
		resHTML(response.getWriter());
	}
	
	static void resHTML(PrintWriter out){
		out.print("<html><body>");
		
		out.print("<h1>세션 쿠키 처리</h1>");
		out.print("<hr>");
		out.printf("<p>세션 쿠키 처리 시간: %s </p>",new Date());
		
		out.print("</body></html>");
	}

}
