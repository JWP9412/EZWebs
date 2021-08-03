package s04_dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jtarget4")
public class JTarget4 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String msg =request.getParameter("msg");
		
		out.println("<html><body>");
		out.println("<h1>dispatch</h1>");
		out.println("<hr>");
		out.println("<p>jstarter4에서 jtarget4으로 이동</p>");
		out.println("<p>msg: "+msg+"</p>");
		out.println("</html></body>");
		
	}

}
