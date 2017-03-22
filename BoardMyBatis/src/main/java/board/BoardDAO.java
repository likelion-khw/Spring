package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAO {

	@Autowired
	SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<BoardVO> getBoardAll(){
		return session.selectList("board.all");
	}
	
	public BoardVO getBoard(int num){
		return session.selectOne("board.one",num);
	}
	
	public void insertBoard(BoardVO vo){
		session.insert("board.insert",vo);
	}
	
	public void updateBoard(BoardVO vo){
		session.update("board.update", vo);
	}
	
	public void deleteBoard(int num){
		session.delete("board.delete", num);
	}
}
