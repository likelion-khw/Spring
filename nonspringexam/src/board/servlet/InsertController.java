package board.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	ArrayList<BoardVO> abvo = new ArrayList<BoardVO>();

	public InsertController(ArrayList<BoardVO> abvo)
	{
		this.abvo = abvo;
	}

	public ArrayList<Object> handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		abvo.add(new BoardVO(2,"추가된놈","추가됬습니다","김김추"));
		
		ArrayList<Object> ao = new ArrayList<Object>();
		ao.add("insert.jsp");
		ao.add(abvo);
		
		request.setAttribute("msg", "게시물을 추가했습니다");
		return ao;
	}

}
