package login;

public interface LoginService {
	String login(LoginVO vo);
	LoginVO memberOne(String userid);
}
