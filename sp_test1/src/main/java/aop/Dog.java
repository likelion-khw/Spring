package aop;

public class Dog implements Animal {
	
	public String eat(){
		System.out.println("치킨을 먹는당");
		return "강아지";
	}

}
