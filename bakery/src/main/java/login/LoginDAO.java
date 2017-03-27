package login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDAO {
	@Autowired
	SqlSession session;

	public String login(LoginVO vo) {
		String result = "idno";
		LoginVO lvo = session.selectOne("login.one", vo.getUserid());
		if (lvo != null) {
			if (lvo.getPassword().equals(vo.getPassword())) {
				result = "ok";
			} else {
				result = "pwd";
			}
		}
		return result;
	}
	
	public LoginVO memberOne(String userid){
		return session.selectOne("login.one", userid);
	}

}
