package kr.or.ddit.Board.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.Board.Dao.BoardDao;
import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.Board.Service.BoardServiceI;
import kr.or.ddit.Files.FileUploadUtil;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.FileVo;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardUpdate")
@MultipartConfig
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardUpdate.class);   
	BoardServiceI boardService;
	 
	BoardVo bv;
	List<FileVo> fileList;
	
	
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		bv = boardService.getBoardContent(board_seq);
		fileList = boardService.getFileList(board_seq);
		
		request.setAttribute("BoardVo", bv);
		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_title = request.getParameter("board_title");
		String board_content =request.getParameter("board_content");
		int count = Integer.parseInt(request.getParameter("count"));
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		
		BoardVo bv = new BoardVo();
		bv.setBoard_title(board_title);
		bv.setBoard_content(board_content);
		bv.setBoard_seq(board_seq);
		
		boardService.updateBoard(bv);

		
		int countdel = Integer.parseInt(request.getParameter("countdel"));
		logger.debug("파일삭제 개수@@@@@@@@@@@@@@@@@@@@{}",countdel);
		for (int i = 1; i <= countdel; i++) {
			int file_seq = Integer.parseInt(request.getParameter("file_delete"+i));
			boardService.deleteFile(file_seq);
		}
		
		FileVo fv = new FileVo();
		for (int i = 1; i <=count ; i++) {
			Part profile = request.getPart("FILE_NAME"+i);
			String realfileName = FileUploadUtil.getFilename(profile.getHeader("content-Disposition"));
			if (!(realfileName == null || realfileName.equals(""))) {
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
		}
		response.sendRedirect(request.getContextPath() + "/BoardContent?board_seq="+board_seq);
		
		
	}
}
