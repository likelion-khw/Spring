package mybatis.spring;

import java.util.List;

public interface EmpService {
	List<EmpVO> getAllEmp();
	EmpVO getEmp(int id);
	
	//resultMap 용
	List<EmpVO> getAllEmp2();
	
	//sql 태그 조각 사용.
	
	List<EmpVO> getEmpReuse(int id);
	List<EmpVO> getEmpReuse2();
	
	// 조건문 사용
	List<EmpVO> getEmpDynamicWhere();
	
	//update 조건문사용
	void updateDynamicEmp();
	
	// collection 사용
	List<EmpVO> getEmpReuseCollection();
	List<EmpVO> getEmpReuseCollection2();
	
	//rownum으로 조회
	
	List<EmpVO> getEmpRownum();
}
