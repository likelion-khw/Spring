package board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;

	public ArrayList<BoardVO> getBoardList(int pageNum) {
		return dao.getBoardList(pageNum);
	}

	public BoardVO getBoardDetail(int seq) {
		return dao.getDetail(seq);
	}
	
	public boolean insertBoard(BoardVO vo){
		return dao.insertBoard(vo);
	}
	
	public boolean deleteBoard(int seq){
		return dao.deleteBoard(seq);
	}
	
	public boolean updateBoard(BoardVO vo){
		return dao.updateBoard(vo);
	}
	
	public boolean checkPassword(int seq, int password){
		return dao.checkPassword(seq, password);
	}

	public int getBoardCount() {
		return dao.getBoardCount();
	}
}
