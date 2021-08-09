/*
 * [세션쿠키]
 * 		- 브라우저가 사용하는 메모리에 저장
 * 		- 브라우저가 종료되면 쿠기도 소멸
 * 		- 순서
 * 		1) 브라우저가 서버에 접속(요청)을 하면 서버는 쿠키를 생성해서 브라우저 전송
 * 		2) 브라우저는 서버가 전송한 쿠키를 받아서 메모리에 보관
 * 		3) 브라우저는 다시 서버에 요청할 때 보관된 쿠키를 서버에 전송
 * 		4) 서버는 브라우저가 전송한 쿠키를 보고 동일한 브라우저는 것을 식별
 */
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

@WebServlet("/getsessioncookies")
public class getSessionCookies extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		String hellocookie = "none";
		
		Cookie[] cookievals = request.getCookies();
		for (int cnt = 0; cookievals != null && cnt < cookievals.length; cnt++) {
			if(cookievals[cnt].getName().equals("hellosessioncookie")) {
				hellocookie =URLDecoder.decode(cookievals[cnt].getValue(), "utf-8");
				break;
			}
		}
			resHTML(response.getWriter(),hellocookie);
	}

	static void resHTML(PrintWriter out,String hellocookie) {
		out.print("<html><body>");

		out.print("<h1>쿠키 세션 처리</h1>");
		out.print("<hr>");
		out.printf("<p>쿠키 세션 처리 시간: %s </p>", hellocookie);

		out.print("</body></html>");
	}

}
