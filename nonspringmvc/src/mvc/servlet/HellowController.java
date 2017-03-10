package mvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HellowController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 모델(Controller와 view 주고 받을 데이터 )--DAO,메소드 호출 -- VO 콜렉션
		request.setAttribute("model", "controller에서 view로 전달하는 모델데이터입니다");
		return "hellow.jsp";
	}

}
