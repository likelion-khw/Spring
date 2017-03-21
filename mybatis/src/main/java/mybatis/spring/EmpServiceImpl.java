package mybatis.spring;

import java.util.List;

public class EmpServiceImpl implements EmpService {

	EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
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
	
	public List<EmpVO> getEmpDynamicWhere(){
		return dao.getEmpDynamicWhere();
	}
	
	public void updateDynamicEmp(){
		dao.updateDynamicEmp();
	}
	
	public List<EmpVO> getEmpReuseCollection(){
		return dao.getEmpReuseCollection();
	}
	
	public List<EmpVO> getEmpReuseCollection2(){
		return dao.getEmpReuseCollection2();
	}
	
	public List<EmpVO> getEmpRownum(){
		return dao.getEmpRownum();
	}
	
}
