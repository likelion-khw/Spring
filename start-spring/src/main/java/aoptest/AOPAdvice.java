package aoptest;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class AOPAdvice {
	long startTime = 0;
	
	public void beforemethod() {
		// Target 메소드 실행 전에
		startTime = System.currentTimeMillis();
		System.out.println("===== 공통관심 메소드(advice)입니다. =====");
		System.out.println("===== 핵심관심(target) 이전에 실행됩니다. =====");
		System.out.println("===== " + new Date(startTime) + " 에 핵심관심이 시작됩니다. =====");
	}

	// public void aftermethod(){
	// //Target 메소드 실행 후에
	// long end = System.currentTimeMillis();
	// System.out.println("===== 핵심관심(target) 이후에 실행됩니다. =====");
	// System.out.println("===== "+ (end-startTime) + "의 시간이 소요됬습니다. =====");
	// }

	public void aftermethod(Object returnValue) {
		// Target 메소드 실행 후에 리턴값이 있는 메소드중 값을 전해주는
		System.out.println("===== 핵심관심(target) 이후에 실행됩니다. =====");
		System.out.println("===== 핵심관심(target)의 리턴값은" + returnValue + " 입니다. =====");
	}

	public void aroundmethod(ProceedingJoinPoint joinpoint) { // aop.xml
		try {
			System.out.println("**************************************");
			System.out.println("===== 핵심관심(target) 이전에 실행됩니다. ====="); // joinpoint
																		// 수행 전

			Object returnValue = joinpoint.proceed(); // 핵심로직 수행중
			// 핵심 로직 객체 이름, 메소드명, 매개변수, 리턴값

			String targetName = joinpoint.getTarget().toString();
			String methodName = joinpoint.toLongString(); // 수행했던
																		// 메소드는?
			Object args[] = joinpoint.getArgs(); // 메소드의 매개변수는?

			System.out.println("===== 핵심관심(target) 이후에 실행됩니다. ====="); // joinpoint
																		// 수행 후

			System.out.println(" === 핵심로직 객체명 === " + targetName + " === ");
			System.out.println(" === 핵심로직 메소드명 === " + methodName + " === ");

			for (Object o : args) {
				System.out.println(" === 핵심로직 매개변수 === " + o + " === ");
			}

			System.out.println(" === 핵심로직 리턴값 === " + returnValue + " === ");
			
		} catch (Throwable e) {
			System.out.println("핵심로직 수행 중 에러 방식!!!");
		}
	}

}
