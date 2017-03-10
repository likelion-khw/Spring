package front.servlet;

interface Command {     //메소드 부븐 선언 동일하게 
	/* public abstract */ 
	String run();
}

class ACommand implements Command {
	public String run() {
		System.out.println("a업무 수행");
		return "a업무 수행";
	}

}

class BCommand implements Command {
	public String run() {
		System.out.println("b업무 수행");
		return "b업무 수행";
	}
}

class CommandFactory {    // 객체를 생성해주는 공장.
	public static Command getInstance(String name) { // 이 메소드를 통해서만 Command 리턴
		if (name.equals("a")) {
			return new ACommand();
		} else if (name.equals("b")) {
			return new BCommand();
		} else {
			return null;
		}
	}
}

public class CommandFactoryTest {

	public static void main(String[] args) {

		Command c = CommandFactory.getInstance(args[0]);

		c.run();
	}

}
