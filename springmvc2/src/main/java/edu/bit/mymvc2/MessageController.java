package edu.bit.mymvc2;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class MessageController {

	// 바뀐 언어설정을 읽어와 저장하는 곳 ( xml에서 설정된 bean태그 읽어옴 )
	@Autowired
	SessionLocaleResolver localeResolver;

	// 언어설정된 메시지를 읽어옴
	@Autowired
	MessageSource messageSource;

	@RequestMapping("i18n.do")
	public String i18n(Locale locale, HttpServletRequest request, Model model) {
		String title = messageSource.getMessage("site.title", null ,"defalut text", locale);
		String count = messageSource.getMessage("site.count", new String[]{"첫번째"} ,"defalut text", locale);
		String msgfirst = messageSource.getMessage("msg.first", null ,"defalut text", locale);
		System.out.println("session locale = " + localeResolver.resolveLocale(request));
		System.out.println("site.title = " +title);
		System.out.println("site.count = " + count);

		System.out.println("msg.first = " + msgfirst);
		
		System.out.println("not.exists = " + messageSource.getMessage("not.exists", null ,"defalut text", locale));
		
		//model에 언어설정정보 전송
		
		model.addAttribute("sitecount", messageSource.getMessage("site.count", new String[]{msgfirst} ,"defalut text", locale));
		
		return "i18n"; // i18n.jsp로 넘김
	}
	
	@RequestMapping(value="login.message",method=RequestMethod.GET)
	public String loginform(){
		return "loginformmessage";
	}
	
	@RequestMapping(value="login.message",method=RequestMethod.POST)
	public String login(@ModelAttribute("id") String id, @ModelAttribute("pw") String pw){
		return "loginsubmitmessage";
	}
}
