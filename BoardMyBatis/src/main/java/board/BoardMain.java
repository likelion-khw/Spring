package board;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardMain {

	public static void main(String[] args) throws IOException{
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("board/board_spring.xml");
		BoardService service = factory.getBean("boardService", BoardServiceImpl.class);
		
		List<BoardVO> list = service.getBoardAll();
		
		for(BoardVO vo: list)
		{
			System.out.println(vo.toString());
		}
		
//		BoardVO vo = new BoardVO();
//		
//		vo.setNum(104);
//		vo.setTitle("수정된제목");
//		vo.setContent("수정된 내용입니다");
//		
//		service.updateBoard(vo);
		
//		service.deleteBoard(104);
		
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("추가된 게시물");
//		vo.setContent("추가된 게시물 내용입니다");
//		vo.setWriter("java");
//		vo.setPasswd(1234);
//		
//		service.insertBoard(vo);
		

	}

}
