package kr.or.ddit.Board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.model.BoardVo;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardList.class);
    private BoardService boardService;

    public BoardList() {
    	boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardmenu_seq =  Integer.parseInt(request.getParameter("boardmenu_seq"));
		List<BoardVo> boardList = boardService.getAllBoardList(boardmenu_seq);
		
		request.setAttribute("boardList", boardList);
		
		for (int i = 0; i < boardList.size(); i++) {
			logger.debug(boardList.get(i).getBoard_title());
		}
		
		request.getRequestDispatcher("board/boardList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
