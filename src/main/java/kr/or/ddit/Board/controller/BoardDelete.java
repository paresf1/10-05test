package kr.or.ddit.Board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.Board.Service.BoardServiceI;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/BoardDelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		int boardmenu_seq = Integer.parseInt(request.getParameter("boardmenu_seq"));
		boardService.deleteBoard(board_seq);
		
//		http://localhost/Board/Board/BoardList?boardmenu_seq1
//		http://localhost/Board/BoardList?boardmenu_seq=1
		
		response.sendRedirect("BoardList?boardmenu_seq="+boardmenu_seq);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
