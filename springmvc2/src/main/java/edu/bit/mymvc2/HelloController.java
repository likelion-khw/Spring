package edu.bit.mymvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//InternalResourceViewResolver
		System.out.println("===HelloController===");
		ModelAndView mav = new ModelAndView();
		mav.addObject("helloMessage","Hello Spring~~");//Model설정 메소드
		mav.setViewName("hello");//view설정   "WEB-INF/views/hello/hello.jsp"
		return mav;
	}
	

	/*public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//모델(controller-view주고 받을 데이터)-xxxDAO, 메소드호출결과-xxxVO(콜랙션)
		request.setAttribute("model","controller에서 view로 전달하는 모델데이터 입니다.");
		return "hello.jsp";
		//SimpleUrlHandlerMapping m;
	}*/	
}
