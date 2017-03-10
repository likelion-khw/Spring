package mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://ip:port/프로젝트명/hellow.mvc 중에 hellow만 판별 하는 법
		String url = request.getRequestURI();
		// http:, , ip:port , 프로젝트명, hellow.mvc
		String parse[] = url.split("/");
		String result = parse[parse.length - 1];

		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(result);
		String viewname = controller.handleRequest(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/view/" + viewname);
		rd.forward(request, response);
	}

}
