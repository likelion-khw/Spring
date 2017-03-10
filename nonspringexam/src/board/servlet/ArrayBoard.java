package board.servlet;

import java.util.ArrayList;

public class ArrayBoard {
	ArrayList<BoardVO> abvo = new ArrayList<BoardVO>();
	
	public ArrayBoard(){
		abvo.add(new BoardVO(1,"첫번째","테스트이빈다용","김혀눙"));
		abvo.add(new BoardVO(2,"두번쨰","그래욜애","장그래"));
		abvo.add(new BoardVO(3,"세번쨰","나 차장이양","오차장"));
		abvo.add(new BoardVO(4,"네번째","안녕하세요 그래용","장그래"));
		abvo.add(new BoardVO(5,"다섯번째","마부장나오라그래!","김사장"));
	}

	public ArrayList<BoardVO> getAbvo() {
		return abvo;
	}

	public void setAbvo(ArrayList<BoardVO> abvo) {
		this.abvo = abvo;
	}
	
	
}
