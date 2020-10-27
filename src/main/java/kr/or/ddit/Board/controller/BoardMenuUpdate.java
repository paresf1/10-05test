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
import kr.or.ddit.model.BoardMenuVo;


/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardMenuUpdate")
public class BoardMenuUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardServiceI boardService;
	
    @Override
    public void init() throws ServletException {
    	boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardmenu_seq = Integer.parseInt(request.getParameter("boardmenu_seq"));
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
		bmvo.setBoardmenu_seq(boardmenu_seq);
		bmvo.setBoard_name(board_name);
		bmvo.setBoard_delete(board_delete);
		
		boardService.updateBoardmenu(bmvo);
		
		List<BoardMenuVo> menuList = boardService.getAllmenu();
		request.getSession().setAttribute("menuList", menuList);
		
		List<BoardMenuVo> menuListUpdate = boardService.getAllBoardmenuUpdate();
		request.getSession().setAttribute("menuListUpdate", menuListUpdate);

		
		request.getRequestDispatcher("boardMenu/boardmenusetting.jsp").forward(request, response);
	}
}
