package jservlet03;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login2.doGet(format) : 숨은 주소 받기");
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login2.doPost(format) : 숨은 주소 받기");
		requestProcess(request, response);
	}
	
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); // MIME-TYPE

		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String address = request.getParameter("useraddress");

		sendResponseFormat(response.getWriter(), userid, userpw, address);
	}

	static void sendResponseFormat(PrintWriter out, String userid, String userpw, String address) {
		String html = String.format("<html><body> 아이디 : %s<br>비밀번호 : %s<br><hr><p>%s</p></body></html>", userid, userpw,
				address);
		out.print(html);
	}
}
