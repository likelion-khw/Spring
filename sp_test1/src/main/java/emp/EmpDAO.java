package emp;

import java.util.List;

public class EmpDAO {
	
	List<EmpVO> list;

	public void setList(List<EmpVO> empVO) {
		this.list = empVO;
	}

	public void insertEmp(EmpVO empVO) {
		System.out.println(empVO.toString());
	}

	public List<EmpVO> selectAllEmp() {
		return list;

	}
}
