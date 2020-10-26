package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

/**
 * login.jsp 이후 아이디와 패스워드가 일치한지 확인하기 위한 서블릿
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	private MemberServiceI memberService;
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}

	/**
	 * 주소창을 간결하게 하기 위해서 get으로 한번 받는다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("main/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		String user_pass = request.getParameter("user_pass");
		
		MemberVo memberVo = memberService.getMember(user_id);
		
		logger.debug(user_id);
		logger.debug(user_pass);
		if(memberVo ==null || !memberVo.getUser_pass().equals(user_pass)) {
			request.getRequestDispatcher("main/login.jsp").forward(request, response);
			logger.debug("로그인실패");
		}
		
		// 비밀번호가 일치하는 경우(메인페이지로 이동)
		else if(memberVo.getUser_pass().equals(user_pass)) {
			request.getSession().setAttribute("memberVo", memberVo);
			request.getRequestDispatcher("main/main.jsp").forward(request, response);
			logger.debug("로그인성공");
		}
		
	}

}
