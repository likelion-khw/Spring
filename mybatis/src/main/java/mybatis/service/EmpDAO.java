package mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAO{
	
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<EmpVO> getAllEmp() {
		List<EmpVO> list = session.selectList("emp.all");
		return list;
	}
	
	public List<EmpVO> getAllEmp2(){
		List<EmpVO> list = session.selectList("emp.allByResultMap");
		return list;
	}

	public EmpVO getEmp(int id) {
		EmpVO vo = session.selectOne("emp.one");
		return vo;
	}
	
	public List<EmpVO> getEmpReuse(int id){
		List<EmpVO> list = session.selectList("dynamic.getEmpReuse",id);
		return list;
	}
	public List<EmpVO> getEmpReuse2(){
		List<EmpVO> list = session.selectList("dynamic.getEmpReuse2");
		return list;
	}
}
