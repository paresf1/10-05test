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
 * Servlet implementation class BoardMenuList
 */
@WebServlet("/boardmenulist")
public class BoardMenuList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	BoardServiceI boardService;
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	// 전체 리스트 조회
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
