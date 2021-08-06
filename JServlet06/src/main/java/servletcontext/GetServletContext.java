/*
 * [SetvletContext]
 * 	- 컨테이너(톰캣)이 실행 시 생성되고 컨테이너가 종료 시 소멸
 * 	- 웹 애플리케이션마다 한 개의 컨텍스트가 생성
 * 	- 웹 애플리케이션이 실행되면서 애플리케이션 전체의 공통 자원이나
 * 	  정보를 미리 바인딩해서 공유
 * 	
 */
package servletcontext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getservletcontext")
public class GetServletContext extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.printf("[getservletcontext] service : method (%s) %n",request.getMethod());
		response.setContentType("text/html;charset=utf-8");
		
		ServletContext context = getServletContext();
		
		List member = (ArrayList)context.getAttribute("member");
		
			PrintWriter out  =response.getWriter();
			
			resHTML(out,member);
		
		
		
	}
	
	static void resHTML(PrintWriter out,List member){
		out.print("<html><body>");
		
		out.print("<h1>ServletContext (getservletcontext)</h1><hr>");
		if(member != null) {
		out.printf("<p>번호 : %s</p>",(String)member.get(0));
		out.printf("<p>이름 : %s</p>",(String)member.get(1));
		out.printf("<p>나이 : %d</p>",(Integer)member.get(2));
		}else {
			out.printf("<p>공유하고 있는 자료가 없습니다</p>");
		}
		
		out.print("</body></html>");
		
		}
}
