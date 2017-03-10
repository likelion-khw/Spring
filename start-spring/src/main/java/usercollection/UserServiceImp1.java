package usercollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UserServiceImp1 implements UserService {
	UserDAO dao;

	public void addUser() {
		//<property 변경 , new < bean 변경 
		dao.addUser();
	}
	
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	public ArrayList<UserVO> getUserList() {
		return dao.getUserlist();
	}
	
	public HashSet<UserVO> getUserSet() {
		return dao.getUserset();
	}
	
	public HashMap<String,UserVO> getUserMap() {
		return dao.getUsermap();
	}

}
