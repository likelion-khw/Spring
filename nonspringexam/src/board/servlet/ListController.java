package board.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListController implements Controller{
	
	ArrayList<BoardVO> abvo = new ArrayList<BoardVO>();
	
	public ListController(ArrayList<BoardVO> abvo)
	{
		this.abvo = abvo;
	}
	
	public ArrayList<Object> handleRequest(HttpServletRequest request, HttpServletResponse response){
		
		ArrayList<Object> ao = new ArrayList<Object>();
		ao.add("list.jsp");
		ao.add(abvo);
		
		request.setAttribute("abvo", abvo);
		
		return ao;
	}

}
