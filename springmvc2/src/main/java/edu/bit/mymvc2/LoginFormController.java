package edu.bit.mymvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class LoginFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//InternalResourceViewResolver
		System.out.println("===LoginFormController===");
		ModelAndView mav = new ModelAndView();

		mav.addObject("title","로그인폼입니다.(Loginform)");//Model설정 메소드
		mav.setViewName("loginform");//view설정   "WEB-INF/views/hello/hello.jsp"
		return mav;
	}	
}
