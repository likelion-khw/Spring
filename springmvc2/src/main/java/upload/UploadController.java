package upload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	// edu.bit.mymvc2, board, member, upload
	// 각 컨트롤

	@RequestMapping(value = "upload.file", method = RequestMethod.GET)
	public String uploadform() {
		return "/file/fileupload";
	}

	@RequestMapping(value = "upload.file", method = RequestMethod.POST)
	public String uploadsubmit(@ModelAttribute("uploadvo") UploadVO vo) throws IOException{

		// 2개 파일 전송 -- 서버 내부 c:/testupload폴더 생성 == 저장
		MultipartFile mutifile1 = vo.getFile1();
		MultipartFile mutifile2 = vo.getFile2();

		String filename1 = mutifile1.getOriginalFilename();
		String filename2 = mutifile2.getOriginalFilename();

		//파일 내부 입력
		
		//서버 저장 파일경로 지정
		String fileSavePath = "/Users/woong/Desktop/testupload/";
		
		//서버저장 파일명 지정
		File f1 = new File(fileSavePath + filename1);
		File f2 = new File(fileSavePath + filename2);
		
		//mutifile1의 데이터를 f1에 복사
		mutifile1.transferTo(f1);
		mutifile2.transferTo(f2);
		
		return "/file/fileuploadsuccess";
	}
}
