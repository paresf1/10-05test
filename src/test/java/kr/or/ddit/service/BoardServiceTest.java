package kr.or.ddit.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.Board.Dao.BoardDao;
import kr.or.ddit.Board.Dao.BoardDaoI;
import kr.or.ddit.Board.Service.BoardService;
import kr.or.ddit.Board.Service.BoardServiceI;
import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.FileVo;

public class BoardServiceTest {
	BoardServiceI boardService = new BoardService();
	BoardDaoI boardDao = new BoardDao();
	
	@Test
	public void getAllmenu() {
		
		List<BoardMenuVo> boardList = boardService.getAllmenu();
		assertNotNull(boardList);
	}
	
	@Test
	public void setBoardmenu() {
		
		BoardMenuVo bmvo = new BoardMenuVo();
		bmvo.setBoard_name("이름");
		bmvo.setBoard_delete("Y");
		
		int result =boardService.setBoardmenu(bmvo);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateBoardmenu(){
		
		BoardMenuVo bmvo = new BoardMenuVo();
		bmvo.setBoard_name("이름");
		bmvo.setBoard_delete("Y");
		bmvo.setBoardmenu_seq(1);
		
		int result = boardService.updateBoardmenu(bmvo);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void getAllBoardmenuUpdate() {
	
		List<BoardMenuVo> boardList = boardService.getAllBoardmenuUpdate();
		
		assertNotNull(boardList);
	}
	
	@Test
	public void getAllBoardList() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int page = 1;
		int boardmenu = 1;
		int pageSize = 7;
		BoardVo bv = new BoardVo();
		bv.setPage(page);
		bv.setPageSize(pageSize);
		bv.setBoardmenu_seq(boardmenu);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardList", boardDao.getAllBoardList(sqlSession,bv));
		
		int totalCnt = boardDao.selectMemberTotalCnt(sqlSession, bv.getBoardmenu_seq());
		int pages = (int)Math.ceil( (double)totalCnt/pageSize);

		map.put("pages", pages);
		
		assertNotNull(map.get("boardList"));
		assertNotNull(map.get("pages"));
	}
	
	
	@Test
	public void setBoard() {
		
		String title = "a";
		String content = "content";
		int boardmenu_seq = 1;
		String userid = "lss";
		int result =0;
		int board_seq = 100;
		
		BoardVo bv = new BoardVo();
		bv.setBoardmenu_seq(boardmenu_seq);
		bv.setBoard_title(title);
		bv.setBoard_content(content);
		bv.setUser_id(userid);
		bv.setBoard_seq(board_seq);
		
		result = boardService.setBoard(bv); 
		int nextseq = bv.getBoard_seq();
		
		System.out.println(nextseq);
		System.out.println(board_seq);
		
		assertTrue(result==nextseq);
	}
	@Test
	public void getBoardContent() {
		int board_seq = 76;
		
		BoardVo bv = boardService.getBoardContent(board_seq);
		
		assertNotNull(bv);
	}
	@Test
	public void updateBoard() {
		String title = "a";
		String content = "a";
		int seq = 76;
				
		BoardVo bv = new BoardVo();
		bv.setBoard_title(title);
		bv.setBoard_content(content);
		bv.setBoard_seq(seq);
		
		int result = boardService.updateBoard(bv);
		
		assertTrue(result==1);
	}
	
	@Test
	public void deleteBoard() {
		int board_seq = 76;
		
		int result = boardService.deleteBoard(board_seq);
		
		assertTrue(result==1);
	}
	
	@Test
	public void setFile() {
		
		FileVo fv = new FileVo();
		fv.setFile_name("name");
		fv.setFile_realname("realname");
		fv.setBoard_seq(76);
		fv.setFile_seq(100);
		int result = boardService.setFile(fv);
		assertTrue(result==1);
	}
	
	@Test
	public void getFileList() {
		int board_seq = 76;
		List<FileVo> fileList = boardService.getFileList(board_seq);
		assertNotNull(fileList);
	}
	
	@Test
	public void getFile() {
		int file_seq = 46;
		FileVo fv = boardService.getFile(file_seq);
		assertNotNull(fv);
	}

}
