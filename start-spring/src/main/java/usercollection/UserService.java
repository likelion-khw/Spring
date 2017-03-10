package usercollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface UserService {

	// main 요청 기능들 메소드 선언
	public void addUser();
	public ArrayList<UserVO> getUserList();
	public HashSet<UserVO> getUserSet();
	public HashMap<String,UserVO> getUserMap();
}
