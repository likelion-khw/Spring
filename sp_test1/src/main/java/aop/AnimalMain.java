package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("aop/animal.xml");
		
		Animal [] animals = new Animal[3];
		
		animals[0] = factory.getBean("dog1", Animal.class);
		animals[1] = factory.getBean("cat1", Animal.class);
		animals[2] = factory.getBean("rab1", Animal.class);
		
		for(Animal a: animals)
		{
			a.eat();
		}
	}
}
