package aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aoptest/aop.xml");
		
		
		//target 독립적 실행가능 + advice ===> 1개의 객체인것처럼 보이게 수행 ( Spring AOP )
		//1개 객체 대리 (=대신) 수행 : Spring = proxy
		AOPTarget1 t1 = factory.getBean("target1", AOPTarget1.class);
		AOPTarget2 t2 = factory.getBean("target2", AOPTarget2.class);
		
		//beformethod 실행
		t1.method(100, 3.15, "자방");
		
		//beformethod 실행
		t2.login("김현웅");
		
		//beformethod 실행
		t2.logout("김현웅");
		
		//bean 을 읽어와서 
		
		//AOPTarget1 : method
		//AOPTarget2 : login , logout

	}

}
