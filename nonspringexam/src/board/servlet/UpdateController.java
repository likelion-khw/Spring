package board.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	ArrayList<BoardVO> abvo = new ArrayList<BoardVO>();

	public UpdateController(ArrayList<BoardVO> abvo)
	{
		this.abvo = abvo;
	}

	public ArrayList<Object> handleRequest(HttpServletRequest request, HttpServletResponse response) {

		abvo.get(abvo.size() - 1).setBoard("수정제목", "수정된놈이야", "수정맨");

		ArrayList<Object> ao = new ArrayList<Object>();
		ao.add("update.jsp");
		ao.add(abvo);

		request.setAttribute("msg", "마지막 게시물에 댓글이 수정되었습니다!");

		return ao;
	}

}
