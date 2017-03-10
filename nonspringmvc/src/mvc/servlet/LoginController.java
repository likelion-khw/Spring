package mvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		MemberVO mvo = new MemberVO("mvc","mvc");
		
		request.setAttribute("log", mvo);
		return "login.jsp";
	}

}
