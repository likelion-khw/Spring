package mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpServiceImpl implements EmpService {

	EmpDAO dao = new EmpDAO();
	
	public void setSession(SqlSession session) {
		dao.setSession(session);
	}

	public List<EmpVO> getAllEmp() {
		return dao.getAllEmp();
	}
	
	public List<EmpVO> getAllEmp2(){
		return dao.getAllEmp2();
	}

	public EmpVO getEmp(int id) {
		return dao.getEmp(id);
	}
	
	public List<EmpVO> getEmpReuse(int id){
		return dao.getEmpReuse(id);
	}
	public List<EmpVO> getEmpReuse2(){
		return dao.getEmpReuse2();
	}
	
}
