package jservlet02a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class Login2 extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login.doGet()");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); //MIME-TYPE
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
//		sendResponse(response.getWriter(), userid, userpw);
		sendResponseFormat(response.getWriter(), userid, userpw);
	}

	static void sendResponse(PrintWriter out, String userid , String userpw) {
		String html = "<html>";
		html += "<body>";
		
		html += "아이디 : " +userid;
		html += "<br>";
		
		html += "비밀번호 : " +userpw;
		html += "<br>";
		
		html += "</body>";
		html += "</html>";
		
		out.print(html);
	}
	static void sendResponseFormat(PrintWriter out, String userid, String userpw) {
		String html = String.format("<html><body> 아이다 : %s<br>비밀번호 : %s<br></body></html>",userid, userpw);
		out.print(html);
	}
}
