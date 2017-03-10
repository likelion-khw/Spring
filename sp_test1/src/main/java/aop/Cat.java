package aop;

public class Cat implements Animal {
	
	public String eat(){
		System.out.println("생선을 먹는당");
		return "고양이";
	}

}
