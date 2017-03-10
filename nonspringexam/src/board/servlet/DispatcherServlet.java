package board.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	ArrayList<BoardVO> abvo = new ArrayBoard().getAbvo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String url = request.getRequestURI();
			String parse[] = url.split("/");
			String result = parse[parse.length - 1];

			HandlerMapping mapping = new HandlerMapping(abvo);
			Controller ct = mapping.getController(result);
			ArrayList<Object> ao = ct.handleRequest(request, response);

			String viewname = (String) ao.get(0);
			abvo = (ArrayList<BoardVO>) ao.get(1);

			response.setContentType("text/html; charset=UTF-8");
			RequestDispatcher rd = request.getRequestDispatcher("/board/" + viewname);
			rd.forward(request, response);
	}

}
