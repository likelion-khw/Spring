package emp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("empService")
public class EmpServiceImpl {

	@Resource(name = "empDAO")
	private EmpDAO empDAO;
	@Resource(name = "empVO")
	private EmpVO empVO;

	public void insertEmp(EmpVO empVO) {
		empDAO.insertEmp(empVO);
	}

	public List selectAllEmp() {
		return empDAO.selectAllEmp();
	}
}
