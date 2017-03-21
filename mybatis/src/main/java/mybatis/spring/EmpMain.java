package mybatis.spring;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("mybatis/spring/spring_mybatis.xml");
		
		EmpService service = (EmpService)factory.getBean("empService");


		// 전체 레코드 조회
		// List<EmpVO> list = service.getAllEmp();
		//
		// for (EmpVO vo : list) {
		// System.out.println(vo.getId() + ":" + vo.getName() + ":" +
		// vo.getJob_id() + ":" + vo.getHire_date());
		// }

		// test2 : 특정 레코드 조회
		// EmpVO vo = service.getEmp(500);
		// System.out.println(vo.getId() + ":" + vo.getName() + ":" +
		// vo.getJob_id() + ":" + vo.getHire_date());

		// test3: resultMap 레코드 호출
		// List<EmpVO> list = service.getAllEmp2();
		//
		// for (EmpVO vo : list) {
		// System.out.println(vo.getId() + ":" + vo.getName() + ":" +
		// vo.getJob_id() + ":" + vo.getHire_date());
		// }

		// test4: sql 조각을 이용한 레코드 호출 where 절 사용
		// List<EmpVO> list = service.getEmpReuse(150);
		//
		// for (EmpVO vo : list) {
		// System.out.println(vo.getId() + ":" + vo.getName() + ":" +
		// vo.getJob_id() + ":" + vo.getHire_date());
		// }

		// test5: sql 조각을 이용한 레코드 호출 order절 사용
		// List<EmpVO> list = service.getEmpReuse2();
		//
		// for (EmpVO vo : list) {
		// System.out.println(vo.getId() + ":" + vo.getName() + ":" +
		// vo.getJob_id() + ":" + vo.getHire_date());
		// }

		// // test6: 조건문을 사용한 레코드 조회
		// List<EmpVO> list = service.getEmpDynamicWhere();
		//
		// for (EmpVO vo : list) {
		// System.out.println(vo.getId() + ":" + vo.getName() + ":" +
		// vo.getJob_id() + ":" + vo.getHire_date());
		// }

		// test7: update문 레코
		// service.updateDynamicEmp();

		// test8: collection 을 활용한 파라미터 넘기기

		// List<EmpVO> list = service.getEmpReuseCollection();
		//
		// for (EmpVO vo : list) {
		// System.out.println(vo.getId() + ":" + vo.getName() + ":" +
		// vo.getJob_id() + ":" + vo.getHire_date());
		// }

		// test8: collection 을 활용한 파라미터 넘기기

		// List<EmpVO> list = service.getEmpReuseCollection2();
		//
		// for (EmpVO vo : list) {
		// System.out.println(vo.getId() + ":" + vo.getName() + ":" +
		// vo.getJob_id() + ":" + vo.getHire_date());
		// }

		// test9: rownum 을 활용한 파라미터 넘기기

		List<EmpVO> list = service.getEmpRownum();

		for (EmpVO vo : list) {
			System.out.println(vo.getId() + ":" + vo.getName() + ":" + vo.getJob_id() + ":" + vo.getHire_date());
		}

	}

}
