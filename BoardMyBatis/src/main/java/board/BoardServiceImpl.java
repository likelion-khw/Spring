package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardServiceImpl implements BoardService{
	
	BoardDAO dao = new BoardDAO();
	
	public void setSession(SqlSession session) {
		dao.setSession(session);
	}

	public List<BoardVO> getBoardAll(){
		return dao.getBoardAll();
	}
	
	public BoardVO getBoard(int num){
		return dao.getBoard(num);
	}
	
	public void insertBoard(BoardVO vo){
		dao.insertBoard(vo);
	}
	
	public void updateBoard(BoardVO vo){
		dao.updateBoard(vo);
	}
	
	public void deleteBoard(int num){
		dao.deleteBoard(num);
	}
}
