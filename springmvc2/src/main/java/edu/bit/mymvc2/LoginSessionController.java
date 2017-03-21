package edu.bit.mymvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("memberVO")
// @... 메소드(SessionStatus st){
// st.setComplete(); // 기존 세션정보를 초기화 시켜버림
// id, pw --> memberVO 모델 저장 --> 세션 저장
public class LoginSessionController {

	@ModelAttribute("memberVO")  // 초기 세션값에 대해 null을 피하기 위해 
	public MemberVO getMemberVO() {
		return new MemberVO();
	}

	@RequestMapping("/login.session") // 기본적으로 RequestMapping 선언되어있는건
	public String loginform() {
		return "loginSessionform";
	}

	@RequestMapping(value = "/login.session", method = RequestMethod.POST)
	public ModelAndView loginsuccess(@ModelAttribute("memberVO") MemberVO vo) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginsessionsuccess");
		return mav;

	}

	@RequestMapping("/loginuser.session")
	public String loginuser() {
		return "loginuser";
	}

	@RequestMapping("/logout.session")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:/login.session";
	}
}
