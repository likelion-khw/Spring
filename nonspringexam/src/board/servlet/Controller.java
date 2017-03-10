package board.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	ArrayList<Object> handleRequest(HttpServletRequest request, HttpServletResponse response);
}
