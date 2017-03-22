package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;

	public void setDao(BoardDAO dao) {
		this.dao = dao;
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
