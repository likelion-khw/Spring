package edu.bit.mymvc2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AllController{
	
	
	@RequestMapping("/hello.action")
	public ModelAndView hello(@RequestParam(value ="msg", required = false , defaultValue="hellow") String msg){
		
		System.out.println("===="+msg+"====");
		ModelAndView mav = new ModelAndView();
		mav.addObject("helloMessage","Hello Spring~~");//Model���� �޼ҵ�
		mav.setViewName("hello");//view����   "WEB-INF/views/hello/hello.jsp"
		return mav;
	}
	
	//�⺻ get/post ��� ��� - post������θ� ��������
	//@...(�̸�="",�̸�="")
	@RequestMapping("/loginform.action")  // 기본적으로 RequestMapping 선언되어있는건 requestparam의 id와 매개변수명과 동일하면 자동으로 인식
	// 단 아이디와 패스워드가 널이면 처리 못함  널처리 필요하면 RequestParam 어노테이션 설정
	public String loginform(){
		System.out.println("===LoginFormController_annotation===");
		return "loginform";		//jsp�̸��� ���� �� �� �ٷ� jsp�������� ������
	}
	
	@RequestMapping(value = "/login.action", method=RequestMethod.POST)
	public String loginsuccess(
//			@RequestParam("id") String id,@RequestParam("pw") String pw,
//			String id, String pw
			
//			MemberVO vo
			@ModelAttribute("memberVO") MemberVO vo
			) throws Exception{
	
//		request.setCharacterEncoding("euc-kr");
		System.out.println("===LoginSuccessController_annotation===");
//		
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		MemberVO vo = new MemberVO(id,pw);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("memberVO",vo);
//		mav.setViewName("loginsuccess");	
		
		//return mav;
		return "loginsuccess";
	
	}
}
