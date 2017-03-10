package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AnimalAdvice {

	public void aroundEat(ProceedingJoinPoint pjp) {
		try {
			System.out.println("식사를 시작할까요? 오늘은 뭐먹어요?"); //
			
			Object returnValue = pjp.proceed();
			String m = pjp.getSignature().getName();
			String T = pjp.getTarget().getClass().getSimpleName();
			
			System.out.println(T +" 객체 : " + m +" 메소드 : " + returnValue + " : 식사를 마칩니다.\n");
			
		} catch (Throwable t) {
			System.out.println("공통로직 수행 중 오류가 발생 했습니다.");
		}

	}

}
