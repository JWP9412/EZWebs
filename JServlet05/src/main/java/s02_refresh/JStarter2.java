package s02_refresh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstarter2")
public class JStarter2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.addHeader("Refresh","2;url=jtarget2");	// 2초 후에 jtarget2로 이동
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>refresh</h3>");
		out.println("<hr>");
		out.println("<p>2초후에 이동합니다</p>");
		
		out.println("</html></body>");
	}

}
