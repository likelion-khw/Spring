package emp;
import java.util.List;
//기존삭제,수정불필요 + 추가//
public interface EmpService {
	public void insertEmp(EmpVO empVO);
	public List selectAllEmp();
}
