package s05_binding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jtarget5")
public class JTarget5 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String msg = (String)request.getAttribute("msgx");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Binding: Dispatcher</h1>");
		out.println("<hr>");
		out.println("<p>jstarter5에서 jtarget5으로 이동</p>");
		out.println("<p>msg: " + msg + "</p>");
		out.println("</html></body>");
		
	}

}
