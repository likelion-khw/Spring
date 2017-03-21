package mybatis.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws IOException {

		//
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		// 1. 마이바티스 xml 설정 파일 읽어옴
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/service/configuration.xml"));

		// 서비스계층 - dao 계층

		// 2. 디비연결
		SqlSession session = factory.openSession(true); // auto 커밋

		EmpServiceImpl service = new EmpServiceImpl();

		service.setSession(session);

		
		// 전체 레코드 조회
//		List<EmpVO> list = service.getAllEmp();
//
//		for (EmpVO vo : list) {
//			System.out.println(vo.getId() + ":" + vo.getName() + ":" + vo.getJob_id() + ":" + vo.getHire_date());
//		}

		// test2 : 특정 레코드 조회
//		EmpVO vo = service.getEmp(500);
//		System.out.println(vo.getId() + ":" + vo.getName() + ":" + vo.getJob_id() + ":" + vo.getHire_date());
		
		
		//test3: resultMap 레코드 호출
//		List<EmpVO> list = service.getAllEmp2();
//
//		for (EmpVO vo : list) {
//			System.out.println(vo.getId() + ":" + vo.getName() + ":" + vo.getJob_id() + ":" + vo.getHire_date());
//		}
		
		//test4: sql 조각을 이용한 레코드 호출 where 절 사용
//		List<EmpVO> list = service.getEmpReuse(150);
//
//		for (EmpVO vo : list) {
//			System.out.println(vo.getId() + ":" + vo.getName() + ":" + vo.getJob_id() + ":" + vo.getHire_date());
//		}
		
		//test5: sql 조각을 이용한 레코드 호출 order절 사용
		List<EmpVO> list = service.getEmpReuse2();

		for (EmpVO vo : list) {
			System.out.println(vo.getId() + ":" + vo.getName() + ":" + vo.getJob_id() + ":" + vo.getHire_date());
		}

		
		
	}

}
