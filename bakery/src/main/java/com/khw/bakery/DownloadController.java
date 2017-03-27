package com.khw.bakery;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController{

	@RequestMapping("download.file")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String name = request.getParameter("name");
		
		// 다운로드 할 대상
		File f = new File("/Users/woong/git/Spring_/bakery/src/main/webapp/"+name);
		
		// 다운로드 컨텐츠 타입, 길이 설정
		response.setContentType("text/html; charset=utf-8");
		response.setContentLength((int)f.length());
		
		//전송 파일 이름을 그대로
		URLEncoder.encode(name, "utf-8");
		//무엇을 다운로드 할 것인지 자세한 기술 사항
		response.setHeader("content-Disposition", "attachment;filename=\""+name+"\";");
		
		// 다운로드 할 예정 파일 입력 객체
		FileInputStream in = new FileInputStream(f);
		//	클라이언트로 전송할 객체
		OutputStream out = response.getOutputStream();
		FileCopyUtils.copy(in, out);
		in.close();
		out.close();
	}
}
