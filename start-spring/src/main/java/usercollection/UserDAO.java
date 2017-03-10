package usercollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UserDAO {
	// UserDAO 기본생성자 -> UserVO, ArrayList<UserVO> 주입 준비
	ArrayList<UserVO> userlist;
	UserVO vo;
	HashSet<UserVO> userset;
	HashMap<String,UserVO> usermap;
	
	public UserDAO() {
		System.out.println("UserDAO 객체 생성");
	}

	public void addUser() {
		System.out.println(vo.getName() + "의 나이는 " + vo.getAge() + "입니다");
	}

	public void setVo(UserVO vo) {
		this.vo = vo;
	}
	
	public ArrayList<UserVO> getUserlist() {
		// xml 파일 5개 uservo list 선언
		return userlist;
	}

	public void setUserlist(ArrayList<UserVO> userlist) {
		this.userlist = userlist;
	}

	public HashSet<UserVO> getUserset() {
		return userset;
	}

	public void setUserset(HashSet<UserVO> userset) {
		this.userset = userset;
	}
	
	public HashMap<String,UserVO> getUsermap() {
		return usermap;
	}

	public void setUsermap(HashMap<String,UserVO> usermap) {
		this.usermap = usermap;
	}

}
