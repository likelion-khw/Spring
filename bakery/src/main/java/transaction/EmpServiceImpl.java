package transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("empService")
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDAO empDAO;

	@Transactional(rollbackFor=java.sql.SQLException.class, readOnly=false, propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	public List<EmpVO> getEmpList() {
		return empDAO.getEmpList();
	}
}
