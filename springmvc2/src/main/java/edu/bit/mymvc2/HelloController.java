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
		mav.addObject("helloMessage","Hello Spring~~");//Model���� �޼ҵ�
		mav.setViewName("hello");//view����   "WEB-INF/views/hello/hello.jsp"
		return mav;
	}
	

	/*public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//��(controller-view�ְ� ���� ������)-xxxDAO, �޼ҵ�ȣ����-xxxVO(�ݷ���)
		request.setAttribute("model","controller���� view�� �����ϴ� �𵨵����� �Դϴ�.");
		return "hello.jsp";
		//SimpleUrlHandlerMapping m;
	}*/	
}
