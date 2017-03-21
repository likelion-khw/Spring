package mybatis;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws IOException {

		//
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		// 1. 마이바티스 xml 설정 파일 읽어옴
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/configuration.xml"));

		// 2. 디비연결
		SqlSession session = factory.openSession(true); // auto 커밋

		// 3. test-mapper.xml : test.all : select : EmpVO
		// 레코드 형태 객체 - EmpVO 타입(여러개)

		// test 1 : EmpVO들만 리스트로 만들어달라

		// List<EmpVO> list = session.selectList("emp.all");
		//
		// for(EmpVO vo : list)
		// {
		// System.out.println(vo.employee_id + ":" + vo.first_name + ":" +
		// vo.getDepartment_id()+ ":" +vo.getJob_id() + ":" +
		// vo.getHire_date());
		// }

		// test2 : 특정 레코드 조회
		// EmpVO vo = session.selectOne("emp.one",100);
		//
		// System.out.println(vo.employee_id + ":" + vo.first_name + ":" +
		// vo.getDepartment_id()+ ":" +vo.getJob_id() + ":" +
		// vo.getHire_date());

		// test3 : 특정 레코드 조회 (vo)

		// EmpVO vo = new EmpVO();
		// vo.setEmployee_id(200);
		//
		// vo = session.selectOne("emp.oneEmpVO",vo);
		//
		// System.out.println(vo.employee_id + ":" + vo.first_name + ":" +
		// vo.getDepartment_id()+ ":" +vo.getJob_id() + ":" +
		// vo.getHire_date());

		// test4: 특정 레코드 삽입하기(vo)

		// EmpVO vo = new EmpVO();
		// vo.setEmployee_id(500);
		// vo.setFirst_name("woong");
		// vo.setLast_name("kim");
		// vo.setEmail("kim22@naver.com");
		// vo.setPhone_number("01-1234-1234");
		// vo.setHire_date();
		// vo.setJob_id("IT_PROG");
		// vo.setSalary(9999);
		// vo.setCommission_pct(0);
		// vo.setManager_id(100);
		// vo.setDepartment_id(50);
		//
		// session.insert("emp.insertEmp",vo);

		// test 5: update : test.updateEmp

		// EmpVO vo = new EmpVO();
		//
		// vo.setEmployee_id(500);
		// vo.setDepartment_id(80);
		// vo.setJob_id("ST_CLERK");
		// session.update("emp.updateEmp", vo);
		//

		// test 6: test.deleteEmp

		// session.delete("emp.deleteEmp", 105);

		
		
		// test 7 : 시퀀즈 포함된 insert 삽입
		EmpVO vo = new EmpVO();
		// vo.setEmployee_id(500);
		vo.setFirst_name("woong");
		vo.setLast_name("kim");
		vo.setEmail("aasdf@a1df.asdf");
		vo.setPhone_number("01-1234-1234");
		// vo.setHire_date();
		vo.setJob_id("IT_PROG");
		vo.setSalary(12300);
		vo.setCommission_pct(0);
		vo.setManager_id(100);
		vo.setDepartment_id(50);

		session.insert("emp.insertEmpWithSelectKey", vo);

		EmpVO vo1 = session.selectOne("emp.one", 5);

		System.out.println(vo1.employee_id + ":" + vo1.first_name + ":" + vo1.getDepartment_id() + ":" + vo1.getJob_id()
				+ ":" + vo1.getHire_date());

	}

}
