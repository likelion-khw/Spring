package board;

import java.util.ArrayList;
//DAO 들이 해야 할 일 정의

public interface BoardService {
	ArrayList<BoardVO> getBoardList(int pageNum);
	BoardVO getBoardDetail(int seq);
	boolean insertBoard(BoardVO vo);
	boolean deleteBoard(int seq);
	boolean updateBoard(BoardVO vo);
	boolean checkPassword(int seq, int password);
	int getBoardCount();

}
