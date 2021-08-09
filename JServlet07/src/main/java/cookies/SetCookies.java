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


@WebServlet("/setcookies")
public class SetCookies extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		Cookie hellocookie = new Cookie("hellocookie", URLEncoder.encode("Hello Cookie 20초","utf-8"));
		hellocookie.setMaxAge(60); // 유효기간(1일)
		response.addCookie(hellocookie);
		
		resHTML(response.getWriter());
	}
	
	static void resHTML(PrintWriter out){
		out.print("<html><body>");
		
		out.print("<h1>쿠키 처리</h1>");
		out.print("<hr>");
		out.printf("<p>쿠키 처리 시간: %s </p>",new Date());
		
		out.print("</body></html>");
	}

}
