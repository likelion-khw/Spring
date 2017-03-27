package transaction;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisTest_Transaction {
public static void main(String[] args){
	ApplicationContext factory
	= new ClassPathXmlApplicationContext
	("transaction/springbean_transaction.xml");

	EmpService service = (EmpService)factory.getBean("empService");
	List<EmpVO> list = service.getEmpList();
	for(int i = 0; i < list.size(); i++){
		EmpVO vo2 = list.get(i);
		System.out.println(vo2.getEmployee_id() + " / " + vo2.getLast_name()
				+ " / " + vo2.getJob_id() );
	}
}
}