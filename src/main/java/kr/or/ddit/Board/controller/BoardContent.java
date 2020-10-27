package kr.or.ddit.Board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.Board.Service.BoardServiceI;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

/**
 * Servlet implementation class BoardContent
 */
@WebServlet("/BoardContent")
public class BoardContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceI boardService;
	private ReplyServiceI replyService;
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		BoardVo boardContent = boardService.getBoardContent(board_seq);
		List<ReplyVo> replyList = replyService.getReply(board_seq);
		
		request.setAttribute("replyList", replyList);
		request.setAttribute("boardContent", boardContent);
		
		request.getRequestDispatcher("board/boardContent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
