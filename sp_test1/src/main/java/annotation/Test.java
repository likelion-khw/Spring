package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/test.xml");

		TestServiceImpl testService = factory.getBean("testService",TestServiceImpl.class);

		TestVO vo = testService.test();
		System.out.println(vo.getMember1() + " : " + vo.getMember2());

	}
}
