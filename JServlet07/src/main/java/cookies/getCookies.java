package cookies;

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

@WebServlet("/getcookies")
public class getCookies extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		String hellocookie = "none";
		
		Cookie[] cookievals = request.getCookies();
		for (int cnt = 0; cookievals != null && cnt < cookievals.length; cnt++) {
			if(cookievals[cnt].getName().equals("hellocookie")) {
				hellocookie =URLDecoder.decode(cookievals[cnt].getValue(), "utf-8");
				break;
			}
		}
			resHTML(response.getWriter(),hellocookie);
	}

	static void resHTML(PrintWriter out,String hellocookie) {
		out.print("<html><body>");

		out.print("<h1>쿠키 처리</h1>");
		out.print("<hr>");
		out.printf("<p>쿠키 처리 시간: %s </p>", hellocookie);

		out.print("</body></html>");
	}

}
