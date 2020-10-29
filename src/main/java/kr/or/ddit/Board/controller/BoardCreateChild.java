package kr.or.ddit.Board.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.Board.Service.BoardServiceI;
import kr.or.ddit.Files.FileUploadUtil;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.FileVo;
import kr.or.ddit.model.MemberVo;

/**
 * Servlet implementation class BoardContentChild
 */
@WebServlet("/BoardCreateChild")
@MultipartConfig
public class BoardCreateChild extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int board_seq;
	int boardmenu_seq;
	BoardServiceI boardService;
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		board_seq = Integer.parseInt(request.getParameter("board_seq"));
		boardmenu_seq = Integer.parseInt(request.getParameter("boardmenu_seq"));
		
		request.getRequestDispatcher("board/BoardCreateChild.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		int count = Integer.parseInt(request.getParameter("count"));
		
		MemberVo mv = (MemberVo)request.getSession().getAttribute("memberVo");
		
		BoardVo bv = new BoardVo();
		bv.setBoard_title(board_title);
		bv.setUser_id(mv.getUser_id());
		bv.setBoard_content(board_content);
		bv.setBoardmenu_seq(boardmenu_seq);
		bv.setBoard_parent_seq(board_seq);
		
		int board_seq = boardService.setBoardChild(bv);
		
		FileVo fv = new FileVo();
		for (int i = 1; i <=count ; i++) {
			Part profile = request.getPart("FILE_NAME"+i);
			String realfileName = FileUploadUtil.getFilename(profile.getHeader("content-Disposition"));
			String fileExtension = FileUploadUtil.getExtension(realfileName);
			String file_name = "D:\\profile\\"+UUID.randomUUID().toString() + "."+fileExtension;
			String filePath = "";
			
			if (profile.getSize() > 0) {
				filePath = file_name;
				profile.write(filePath);
			}
			fv.setBoard_seq(board_seq);
			fv.setFile_name(file_name);
			fv.setFile_realname(realfileName);
			
			boardService.setFile(fv);
		}
		
			response.sendRedirect(request.getContextPath() + "/BoardList?boardmenu_seq="+boardmenu_seq);
			
		
	}	
}

