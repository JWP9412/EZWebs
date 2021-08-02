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
public class Login extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Login.init()");
	}
	public void destroy() {
		System.out.println("Login.destroy()");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login.doGet()");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); //MIME-TYPE
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		sendResponse(response.getWriter(), userid, userpw);
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
	
}
