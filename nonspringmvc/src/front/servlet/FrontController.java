package front.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트요청");
		//ip와 port번호를 뺀
		System.out.println(request.getRequestURI());
		//ip와 port번호를 모두 포함된
		System.out.println(request.getRequestURL());
		//해당 프로젝트명
		System.out.println(request.getContextPath());
		
		String cmd = null;
		
		if(request.getRequestURI().equals("/nonspringmvc/a.front"))
		{
			cmd = CommandFactory.getInstance("a").run();
			
		}else if(request.getRequestURI().equals("/nonspringmvc/b.front"))
		{
			cmd = CommandFactory.getInstance("b").run();
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>"+cmd+"</h1>");
	}

}
