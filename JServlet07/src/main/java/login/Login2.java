/*
 * [hidden 태그]
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String usersid = String.format("@%s", userid);
		
		resHTML(response.getWriter(), userid, userpw, usersid);
	}
	static void resHTML(PrintWriter out,String userid, String userpw, String usersid) throws UnsupportedEncodingException {
		out.print("<html><body>");
		
//		out.print();
		out.print("<h1>로그인 성공</h1>");
		
		out.print("<hr>");
		out.printf("<p>아이디 : %s</p>",userid);
		out.printf("<p>비밀번호 : %s</p>",userpw);
		out.printf("<p>SID : %s</p>",usersid);
		
		String sid = URLEncoder.encode(usersid,"utf-8");
		
		out.printf("<input type='hidden' name='usersid' value='%s'/>",sid);
		
		out.printf("<a href='/JServlet07/service2?userid=%s&userpw=%s&userid=%s'>서비스2</a>",
				userid,userpw,sid);
		
		out.print("</body></html>");
	}
}
