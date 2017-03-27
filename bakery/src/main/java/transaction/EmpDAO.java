package transaction;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO  {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<EmpVO> getEmpList()  {
		//employees 테이블 2개 레코드 insert
		
		EmpVO vo1 = new EmpVO();
		vo1.setEmployee_id(601);
		vo1.setLast_name("강");
		vo1.setEmail("kang601@bit.com");
		vo1.setJob_id("IT_PROG");
		
		int rowcount1 = sqlSession.insert("transaction.insertEmp", vo1);
		
		System.out.println(rowcount1);
		
		EmpVO vo2 = new EmpVO();
		vo2.setEmployee_id(602);
		vo2.setLast_name("강");
		vo2.setEmail("kang602@bit.com");
		vo2.setJob_id("IT_PROG");
		
		int rowcount2 = sqlSession.insert("transaction.insertEmp", vo2);
		
		System.out.println(rowcount2);
		
		//employees 테이블 조회
		
		List<EmpVO> list = sqlSession.selectList("transaction.all", 600);
		
		return list;
	}
}