package edu.bit.mymvc2;
/*
 * 		uri-pattern : / -> DispatcherServlet(서블릿에 보낼때)
 * 
 *     				  /* 는 모든 요청 : filter 적용 
 * 
 * */

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnTypeController {
	@RequestMapping("/sample")
	public String home(){
		System.out.println("home method");
		return "sample/home";
	}
	
	@RequestMapping("/sample/doA")
	public String doA(Model model){
		System.out.println("doA method");
		model.addAttribute("msg","홈페이지 방문을 환영합니다");
		return "sample/doB";
	}
	
	@RequestMapping("/sample/doB")
	public void doB(){//리턴타입 없어도 위 @RequestMapping에 지정된 경로로 찾아감
		System.out.println("doB method");
	}  // view/sample/doB.jsp
	
	@RequestMapping("/sample/doC")
	public ModelAndView doC(){
		System.out.println("doC method");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("member", new MemberVO("User1","User1","User1","User1","User1"));
		return new ModelAndView("sample/doC", "map", map);
	}
	
	@RequestMapping("/sample/doD")
	public String doD(){
		System.out.println("doD method");
		return "redirect:/sample/doE";
	}
	
	@RequestMapping("/sample/doE")
	public void doE(){
		System.out.println("doE method");
	}

}
