package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("loginvo")
public class LoginController {
	@Autowired
	LoginServiceImpl service;
	ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="start.bakery", method=RequestMethod.GET)
	public String login(){
		return "login/loginform";
	}
	
	@RequestMapping(value="start.bakery", method=RequestMethod.POST)
	public ModelAndView login(LoginVO vo){
		mav.addObject("loginvo",service.memberOne(vo.userid));
		mav.setViewName("redirect:/order.bakery");
		return mav;
	}
	@ResponseBody
	@RequestMapping(value="startcheck.bakery", method=RequestMethod.POST)
	public int loginCheck(LoginVO vo){
		String result = service.login(vo);
		int msg = 0;
		
		if(result.equals("idno"))
		{
			msg = 1;
		}else if(result.equals("pwd"))
		{
			msg = 2;
		}
		return msg;
	}
	
	@RequestMapping(value="end.bakery", method=RequestMethod.GET)
	public String logout(SessionStatus session){
		session.setComplete();
		return "login/loginform";
	}

}
