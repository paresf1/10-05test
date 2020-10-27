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
import kr.or.ddit.Board.Service.BoardServiceI;
import kr.or.ddit.model.BoardMenuVo;

/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardMenuInsert")
public class BoardMenuInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardServiceI boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardMenuInsert.class);

	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String board_name = request.getParameter("board_name");
		String board_delete = request.getParameter("board_delete");
		
		try {
			if(board_delete.equals("미사용")) {
				board_delete = "Y";
			}else {
				board_delete = "N";
			}
		} catch (Exception e) {
			
		}
		
		BoardMenuVo bmvo = new BoardMenuVo();
		bmvo.setBoard_name(board_name);
		bmvo.setBoard_delete(board_delete);
		
		int count = boardService.setBoardmenu(bmvo);
		logger.debug("{}",count);
		
		List<BoardMenuVo> menuList = boardService.getAllmenu();
		request.getSession().setAttribute("menuList", menuList);
		
		request.getRequestDispatcher("boardMenu/boardmenusetting.jsp").forward(request, response);
	}

}
