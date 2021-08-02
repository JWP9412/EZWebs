package jservlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login4")
public class Login4 extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login4.doGet(format) : 숨은 주소 받기");
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login4.doPost(format) : 숨은 주소 받기");
		requestProcess(request, response);
	}
	
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); // MIME-TYPE

		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String address = request.getParameter("useraddress");
		
		if((userid != null && userid.length() != 0) && userpw != null && userpw.length() !=0) {
			sendResponseFormat(response.getWriter(), userid, userpw, address);
		}else {
			invalidLogin(response.getWriter());
		}

	
	}

	static void sendResponseFormat(PrintWriter out, String userid, String userpw, String address) {
		StringBuffer html = new StringBuffer();
		html.append("<html><body>");
		html.append(String.format("<h3>아이디(%s) 로 로그인 성공</h3><br><hr><p>%s</p>", userid,address));
		html.append("</html></body>");
		out.print(html);
	}
	
	static void invalidLogin(PrintWriter out) {
		StringBuffer html = new StringBuffer();
		html.append("<html><body>");
		
		String strfault = String.format("<h3>아이디가 이상합니다.</h3><br>");
		String strlogin = String.format("<a href='http://localhost:8090/JServlet03/login4.html'>로그인 화면으로 이동</a>");
		html.append(strfault);
		html.append(strlogin);
		
		html.append("</html></body>");
		out.print(html);
	}
}
