package aoptest;

public class AOPTarget1 {
	public String method(int i, double d, String s){
		System.out.println("나는 핵심로직 1을 수행합니다");
		return "핵심로직1";
	}
}
