package board;

import java.util.List;

public interface BoardService {
	List<BoardVO> getBoardAll();
	BoardVO getBoard(int num);
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(int num);
}
