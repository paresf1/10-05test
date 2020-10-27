package kr.or.ddit.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.Board.Service.BoardServiceI;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.model.BoardMenuVo;

/**
 * Servlet implementation class Commonleft
 */
@WebServlet("/commonleft")
public class Commonleft extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private MemberServiceI memberService;
	private BoardServiceI boardService;	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
		boardService = new BoardService();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardMenuVo> menuList = boardService.getAllmenu();
		request.setAttribute("menuList", menuList);
		
		request.getRequestDispatcher("layout/left.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
