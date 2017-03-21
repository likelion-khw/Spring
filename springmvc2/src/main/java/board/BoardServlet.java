package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;

public class BoardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dbao = new BoardDAO();

		String jspfile = "";
		if (request.getParameter("action") == null || request.getParameter("action").equals("list")) {
			ArrayList<BoardVO> abvo = dbao.getBoardList(1);
			int count = dbao.getBoardCount();
			request.setAttribute("count", count);
			request.setAttribute("abvo", abvo);
			jspfile = "/board/boardlist.jsp";

		} else if (request.getParameter("action").equals("page")) {
			int page = Integer.parseInt(request.getParameter("page"));
			ArrayList<BoardVO> abvo = dbao.getBoardList(page);
			int count = dbao.getBoardCount();
			request.setAttribute("count", count);
			request.setAttribute("abvo", abvo);
			jspfile = "/board/boardlist.jsp";
		} else if (request.getParameter("action").equals("detail")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			BoardVO bvo = dbao.getDetail(seq);
			request.setAttribute("bvo", bvo);
			jspfile = "/board/boarddetail.jsp";
		} else if (request.getParameter("action").equals("writer")) {
			jspfile = "/board/boardwriteform.jsp";
		} else if (request.getParameter("action").equals("writeprocess")) {

			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			String writer = request.getParameter("writer");
			int password = Integer.parseInt(request.getParameter("password"));
			boolean is = dbao.insertBoard(new BoardVO(-1, title, contents, writer, "", password, 0,null,null));

			request.setAttribute("is", is);
			jspfile = "/board/boardwriteprocess.jsp";

		} else if (request.getParameter("action").equals("update")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			BoardVO bvo = dbao.getDetail(seq);
			request.setAttribute("bvo", bvo);

			jspfile = "/board/boardupdateform.jsp";

		} else if (request.getParameter("action").equals("checkup")) {

			int seq = Integer.parseInt(request.getParameter("seq"));
			int password = Integer.parseInt(request.getParameter("password"));
			boolean is = dbao.checkPassword(seq, password);
			BoardVO bvo = dbao.getDetail(seq);

			request.setAttribute("bvo", bvo);
			request.setAttribute("is", is);

			jspfile = "/board/boardupdateform.jsp";

		} 
		
		else if (request.getParameter("action").equals("checkdel")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			int password = Integer.parseInt(request.getParameter("password"));
			BoardVO bvo = dbao.getDetail(seq);
			boolean is = dbao.checkPassword(seq, password);

			request.setAttribute("bvo", bvo);
			request.setAttribute("is", is);

			jspfile = "/board/boarddeleteform.jsp";
		}

		else if (request.getParameter("action").equals("updateprocess")) {
			String title = String.valueOf(request.getParameter("title"));
			String contents = String.valueOf(request.getParameter("contents"));
			String writer = String.valueOf(request.getParameter("writer"));
			int password = Integer.parseInt(request.getParameter("password"));
			int seq = Integer.parseInt(request.getParameter("seq"));

			BoardVO bvo = dbao.getDetail(seq);

			bvo.setTitle(title);
			bvo.setContents(contents);
			bvo.setWriter(writer);
			bvo.setPassword(password);

			boolean is = dbao.updateBoard(bvo);

			request.setAttribute("is", is);

			jspfile = "/board/boardupdateprocess.jsp";

		} 
		
		else if (request.getParameter("action").equals("deleteprocess")) {
			int seq = Integer.parseInt(request.getParameter("seq"));

			boolean is = dbao.deleteBoard(seq);
			request.setAttribute("is", is);
			jspfile = "/board/boarddeleteprocess.jsp";
		}
		
		else if (request.getParameter("action").equals("delete")) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			BoardVO bvo = dbao.getDetail(seq);

			request.setAttribute("bvo", bvo);

			jspfile = "/board/boarddeleteform.jsp";
		} 
		
		else if (request.getParameter("action").equals("login")) {
			jspfile= "/board/loginform.jsp";
		}

		else if (request.getParameter("action").equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();

			jspfile = "/BoardServlet?action=list";
		} 
		
		else {
			jspfile = "/board/boarderror.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(jspfile);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO mdao = new MemberDAO();

		RequestDispatcher rd = null;

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		if (session.getAttribute("id") == null) {
			String userid = request.getParameter("id");
			String password = request.getParameter("pwd");

			String result = mdao.membercheck(userid, password);

			if (result.equals("idno")) {
				rd = request.getRequestDispatcher("/board/loginform.jsp");
				request.setAttribute("msg", "아이디가 존재하지 않습니다 <br> 회원가입을 하세요!");
				rd.forward(request, response);

			} else if (result.equals("pwdno")) {
				rd = request.getRequestDispatcher("/board/loginform.jsp");
				request.setAttribute("msg", "패스워드가 틀립니다.");
				request.setAttribute("id", userid);
				rd.forward(request, response);

			} else if (result.equals("pass")) {
				session.setAttribute("id", userid);
				response.sendRedirect("/exam/BoardServlet");
			}

		}
	}

}
