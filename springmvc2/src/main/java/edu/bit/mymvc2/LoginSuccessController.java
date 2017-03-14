package edu.bit.mymvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class LoginSuccessController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//InternalResourceViewResolver
		System.out.println("===LoginSuccessController===");
		String id= arg0.getParameter("id");
		String pw = arg0.getParameter("pw");
//		MemberVO vo = new  MemberVO(id,pw);
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("memberVO",vo);
		mav.setViewName("loginsuccess");//view����   "WEB-INF/views/hello/hello.jsp"
		return mav;
	}	
}
