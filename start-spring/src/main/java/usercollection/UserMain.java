package usercollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMain {
	// main 안에서 new 생성자를 지우자
	public static void main(String[] args) {

		System.out.println("==xml 읽기 전 ==");
		// spring(객체 생성 - 관리) + 반 = > 완성
		ApplicationContext factory = new ClassPathXmlApplicationContext("usercollection/user.xml");

		System.out.println("==xml 읽기 후 ==");

		UserDAO dao = factory.getBean("dao", UserDAO.class);
		// setuserlist 와 setvo 설정!

		UserServiceImp1 service = factory.getBean("service", UserServiceImp1.class);

		ArrayList<UserVO> userlist = service.getUserList();

		for (UserVO vo : userlist) {
			System.out.println(vo.getName() + " : " + vo.getAge());
		}

		System.out.println("=======================");
		
		HashSet<UserVO> userset = service.getUserSet();

		for (UserVO vo : userset) {
			System.out.println(vo.getName() + " : " + vo.getAge());
		}
		
		System.out.println("=======================");
		
		HashMap<String,UserVO> usermap = service.getUserMap();
		
		Set<String> keys = usermap.keySet();
		
		for(String str : keys)
		{
			System.out.println(usermap.get(str).getName() + " : " + usermap.get(str).getAge());
		}

	}

}
