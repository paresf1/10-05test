package kr.or.ddit.Board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.Board.Service.BoardServiceI;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;

/**
 * Servlet implementation class BoardCreate
 */
@WebServlet("/BoardCreate")
@MultipartConfig
public class BoardCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(BoardCreate.class);
	String boardmenu_seq;
	
	private BoardServiceI boardService;
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boardmenu_seq =  request.getParameter("boardmenu_seq");
		
		request.getRequestDispatcher("board/boardCreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		
		MemberVo mv = (MemberVo)request.getSession().getAttribute("memberVo");
		
		int boardmenu_seq_int = Integer.parseInt(boardmenu_seq);
		BoardVo bv = new BoardVo();
		bv.setBoard_title(board_title);
		bv.setUser_id(mv.getUser_id());
		bv.setBoard_content(board_content);
		bv.setBoardmenu_seq(boardmenu_seq_int);
		
		int result = boardService.setBoard(bv);
		logger.debug(bv.getBoard_title());
		logger.debug(bv.getBoard_content());
		logger.debug(bv.getUser_id());
		
		logger.debug("{}",result);
		if(result ==1) {
			response.sendRedirect(request.getContextPath() + "/BoardList?boardmenu_seq="+boardmenu_seq);
		}else {
			response.sendRedirect(request.getContextPath() + "/BoardCreate?boardmenu_seq="+boardmenu_seq);
		}
		
	}	
}










