package jservlet02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/school")
public class School extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String[] subjects = request.getParameterValues("subject");
		if(subjects == null) {
			System.out.println("[수강목록] 없음");
			return;
		}
		
		System.out.println("[수강목록]");
		
		for (String subject : subjects) {
			System.out.println("과목 : " + subject);
		}
	}

}
