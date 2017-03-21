package mybatis.spring;

import java.util.ArrayList;
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
	
	public List<EmpVO> getEmpDynamicWhere(){
		EmpVO vo = new EmpVO();
//		vo.setName("William");
		List<EmpVO> list = session.selectList("dynamic.getEmpDynamicWhere", vo);
		return list;
	}
	
	public void updateDynamicEmp(){
		EmpVO vo = new EmpVO();
		vo.setId(100);
		session.update("dynamic.updateEmp", vo);
	}
	
	public List<EmpVO> getEmpReuseCollection(){
		int[] condition = {100,110};
		List<EmpVO> list = session.selectList("dynamic.getEmpReuseCollection", condition);
		return list;
	}
	
	public List<EmpVO> getEmpReuseCollection2(){
		List<String> job = new ArrayList();
		job.add("IT_PROG");
		job.add("ST_MAN");
		job.add("SA_CLERK");
		List<EmpVO> list = session.selectList("dynamic.getEmpReuseCollection2", job);
		return list;
	}
	
	public List<EmpVO> getEmpRownum(){
		int[] rownum = {1,5};
		
		List<EmpVO> list = session.selectList("dynamic.getEmpRownum",rownum);
		return list;
	}
	
}
