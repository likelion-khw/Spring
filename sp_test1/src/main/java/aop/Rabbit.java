package aop;

public class Rabbit implements Animal {
	
	public String eat(){
		System.out.println("당근을 먹는당");
		return "토끼";
	}

}
