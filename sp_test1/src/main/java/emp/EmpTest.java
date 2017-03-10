package emp;

import java.util.Iterator;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {
	public static void main(String args[]) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("emp/emp.xml");
		
		EmpServiceImpl empService = (EmpServiceImpl) (factory.getBean("empService"));
		EmpVO empVO = (EmpVO) (factory.getBean("empVO")); // insert

		if (args[0].equals("insert")) {
			empService.insertEmp(empVO);
			System.out.println("사원 등록을 완료하였습니다.");
			
		} else if (args[0].equals("list")) {
			List all = empService.selectAllEmp();
			Iterator i = all.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
		}
	}
}
