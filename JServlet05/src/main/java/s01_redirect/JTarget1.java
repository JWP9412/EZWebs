package s01_redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jtarget1")
public class JTarget1 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>sendRedirect('jtarget1')</h3>");
		out.println("<hr>");
		out.println("<p>jstarter1에서 sendRedirect('jtarget1')으로 이동</p>");
		
		out.println("</html></body>");
		
	}

}
