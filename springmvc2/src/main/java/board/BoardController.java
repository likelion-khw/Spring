package board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	// http://ip:Port/mvc2/list.board

	@Autowired
	BoardService service;
	ModelAndView mav = new ModelAndView();

	
	// 초기화면 리스트 설정
	@RequestMapping("list.board")
	public ModelAndView getBoardList(
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum) {
		ArrayList<BoardVO> list = service.getBoardList(pageNum);
		int count = service.getBoardCount();
		int pagzing = count / 5;

		if (count % 5 != 0) {
			pagzing += 1;
		}
		mav.addObject("pagzing", pagzing);
		mav.addObject("list", list);
		mav.setViewName("board/boardlist");

		return mav;

	}

	
	// 게시물 상세 페이지
	@RequestMapping("detail.board")
	public ModelAndView getBoardDetail(int seq) {
		BoardVO bvo = service.getBoardDetail(seq);
		mav.addObject("bvo", bvo);
		mav.setViewName("board/boarddetail");

		return mav;
	}

	// 게시물 추가
	@RequestMapping(value = "write.board",method=RequestMethod.GET)
	public String insert() {
		return "board/write";
	}
	
	@RequestMapping(value = "write.board",method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IOException {
		boolean ist = service.insertBoard(vo);
		
		MultipartFile file1 = vo.getFile1();
		MultipartFile file2 = vo.getFile2();
		
		String filename1 = (vo.getWriter() +"_"+file1.getOriginalFilename());
		String filename2 = (vo.getWriter() +"_"+file2.getOriginalFilename());
		
		System.out.println(filename1 + filename2);
		
		String fileSavePath = "/Users/woong/Desktop/boardupload/";
		
		File f1 = new File(fileSavePath+filename1);
		File f2 = new File(fileSavePath+filename2);
		
		file1.transferTo(f1);
		file2.transferTo(f2);
		
		return "redirect:/list.board";
	}
	
	//게시물 수정
	@RequestMapping(value ="update.board", method=RequestMethod.GET)
	public ModelAndView update(int seq){
		BoardVO bvo = service.getBoardDetail(seq);
		mav.addObject("seq",seq);
		mav.addObject("bvo",bvo);
		mav.setViewName("board/update");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value ="update.board", method=RequestMethod.POST)
	public boolean updateBoard(BoardVO vo){
		boolean ist = service.updateBoard(vo);
		return ist;
	}
	
	
	//게시물 삭제
	@RequestMapping("delete.board")
	public String deleteBoard(int seq){
		service.deleteBoard(seq);
		return "redirect:/list.board";
	}
	
	
	//ajax를 이용한 패스워드 확인
	@ResponseBody
	@RequestMapping("pwcheck.board")
	public boolean checkPassword(int seq, int password){
		boolean check = service.checkPassword(seq, password);
		return check;
	}
}
