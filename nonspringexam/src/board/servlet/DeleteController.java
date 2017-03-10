package board.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	ArrayList<BoardVO> abvo = new ArrayList<BoardVO>();

	public DeleteController(ArrayList<BoardVO> abvo) {
		this.abvo = abvo;
	}

	public ArrayList<Object> handleRequest(HttpServletRequest request, HttpServletResponse response) {

		abvo.remove(abvo.size()-1);
		
		ArrayList<Object> ao = new ArrayList<Object>();
		ao.add("delete.jsp");
		ao.add(abvo);

		request.setAttribute("msg", "게시물을 삭제했습니다");
		return ao;
	}

}
