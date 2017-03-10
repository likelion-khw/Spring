package board.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyController implements Controller{
	
	ArrayList<BoardVO> abvo = new ArrayList<BoardVO>();
 	
	public ReplyController(ArrayList<BoardVO> abvo)
	{
		this.abvo = abvo;
	}
	
	public ArrayList<Object> handleRequest(HttpServletRequest request, HttpServletResponse response){
		
		abvo.get(abvo.size()-1).setReply(new ReplyVO("댓글맨","나는야 댓글맨"));
		
		ArrayList<Object> ao = new ArrayList<Object>();
		ao.add("reply.jsp");
		ao.add(abvo);
		
		request.setAttribute("msg", "마지막 게시물에 댓글이 추가되었습니다!");
		
		return ao;
	}

}
