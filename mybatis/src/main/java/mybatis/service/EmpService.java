package mybatis.service;

import java.util.List;

public interface EmpService {
	List<EmpVO> getAllEmp();
	EmpVO getEmp(int id);
	
	//resultMap 용
	List<EmpVO> getAllEmp2();
	
	//sql 태그 조각 사용.
	
	List<EmpVO> getEmpReuse(int id);
	List<EmpVO> getEmpReuse2();
}
