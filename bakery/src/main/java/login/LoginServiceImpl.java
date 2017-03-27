package login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginDAO dao;
	
	public String login(LoginVO vo){
		return dao.login(vo);
	}
	
	public LoginVO memberOne(String userid){
		return dao.memberOne(userid);
	}

}
