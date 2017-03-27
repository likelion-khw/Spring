package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("loginvo")
public class LoginController {
	@Autowired
	LoginServiceImpl service;
	
	
	@RequestMapping(value="start.bakery", method=RequestMethod.GET)
	public String login(){
		return "login/loginform";
	}
	
	@RequestMapping(value="start.bakery", method=RequestMethod.POST)
	public ModelAndView login(LoginVO vo){
		ModelAndView mav = new ModelAndView();
		String result = service.login(vo);
		String msg ="";
		mav.addObject("id",null);
		
		if(result.equals("idno"))
		{
			msg = "해당 아이디가 존재하지 않습니다.";
			mav.setViewName("login/loginform");
			mav.addObject("msg",msg);
		}else if(result.equals("pwd"))
		{
			msg = "패스워드를 확인해주세요.";
			mav.addObject("id",vo.getUserid());
			mav.setViewName("login/loginform");
			mav.addObject("msg",msg);
		}else if(result.equals("ok"))
		{
			mav.addObject("loginvo",service.memberOne(vo.getUserid()));
			mav.setViewName("redirect:/order.bakery");
		}
		return mav;
	}
	
	@RequestMapping(value="end.bakery", method=RequestMethod.GET)
	public String logout(SessionStatus session){
		session.setComplete();
		return "login/loginform";
	}

}
