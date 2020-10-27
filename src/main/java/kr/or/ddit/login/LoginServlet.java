package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.Board.Service.BoardServiceI;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.MemberVo;

/**
 * login.jsp 이후 아이디와 패스워드가 일치한지 확인하기 위한 서블릿
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

	private MemberServiceI memberService;
	private BoardServiceI boardService;

	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
		boardService = new BoardService();
	}

	/**
	 * 주소창을 간결하게 하기 위해서 get으로 한번 받는다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user_id = request.getParameter("user_id");
		String user_pass = request.getParameter("user_pass");
		MemberVo memberVo = memberService.getMember(user_id);

		// main에다가 옆에 리스트를 불러오기 위함
		List<BoardMenuVo> menuList = boardService.getAllmenu();

		List<BoardMenuVo> menuListUpdate = boardService.getAllBoardmenuUpdate();
//		session.setAttribute("id", userId);

		if (memberVo == null || !memberVo.getUser_pass().equals(user_pass)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			logger.debug("로그인실패");
		}

		// 비밀번호가 일치하는 경우(메인페이지로 이동)
		else if (memberVo.getUser_pass().equals(user_pass)) {
			
			request.getSession().setAttribute("memberVo", memberVo);
			request.getSession().setAttribute("menuList", menuList);
			request.getSession().setAttribute("menuListUpdate", menuListUpdate);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
			logger.debug("로그인성공");
		}

	}

}
