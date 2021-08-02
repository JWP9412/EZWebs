package jservlet02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class Login2 extends HttpServlet {
		public void init(ServletConfig config) throws ServletException {
			System.out.println("Login.init()...");
		}
	public void destroy() {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login2.doPost()");
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		System.out.println("userid: "+userid);
		System.out.println("userpw: "+userpw);
	}

}
