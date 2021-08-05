package s05_binding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstarter5")
public class JStarter5 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("msgx", "환영합니다");
		
//		response.sendRedirect("jtarget5");
		RequestDispatcher dispatch = request.getRequestDispatcher("jtarget5");
		dispatch.forward(request, response);
	}

}
