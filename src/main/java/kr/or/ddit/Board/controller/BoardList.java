package kr.or.ddit.Board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @Override
    	public void init() throws ServletException {
    		boardService = new BoardService();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardmenu_seq =  Integer.parseInt(request.getParameter("boardmenu_seq"));
		request.setAttribute("boardmenu_seq", boardmenu_seq);
		
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);
		
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str ==null ? 7: Integer.parseInt(pageSize_str);
		request.setAttribute("pageSize", pageSize);
		
		BoardVo bv = new BoardVo();
		bv.setPage(page);
		bv.setPageSize(pageSize);
		bv.setBoardmenu_seq(boardmenu_seq);
		
		Map<String, Object> map = boardService.getAllBoardList(bv);
		request.setAttribute("boardList", map.get("boardList"));
		request.setAttribute("pages", map.get("pages"));
		
		
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
