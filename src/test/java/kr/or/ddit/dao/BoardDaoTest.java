package kr.or.ddit.dao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.Board.Dao.BoardDao;
import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.FileVo;

public class BoardDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);
	BoardDao boardDao = new BoardDao();
			
	@Test
	public void getAllmenu() {
		
		List<BoardMenuVo> boardList = boardDao.getAllmenu();
		assertNotNull(boardList);
	}
	
	@Test
	public void setBoardmenu() {
		
		BoardMenuVo bmvo = new BoardMenuVo();
		bmvo.setBoard_name("이름");
		bmvo.setBoard_delete("Y");
		
		int result =boardDao.setBoardmenu(bmvo);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateBoardmenu(){
		
		BoardMenuVo bmvo = new BoardMenuVo();
		bmvo.setBoard_name("이름");
		bmvo.setBoard_delete("Y");
		bmvo.setBoardmenu_seq(1);
		
		int result = boardDao.updateBoardmenu(bmvo);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void getAllBoardmenuUpdate() {
	
		List<BoardMenuVo> boardList = boardDao.getAllBoardmenuUpdate();
		
		assertNotNull(boardList);
	}
	
	@Test
	public void getAllBoardList() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int page = 1;
		int pageSize = 7;
		int boardmenu = 1;
		BoardVo bv = new BoardVo();
		bv.setPage(page);
		bv.setPageSize(pageSize);
		bv.setBoardmenu_seq(boardmenu);
		
		List<BoardVo> boardList = boardDao.getAllBoardList(sqlSession, bv);
		
		assertNotNull(boardList);
	}
	@Test
	public void selectMemberTotalCnt() {
		
		SqlSession SqlSession = MybatisUtil.getSqlSession();
		int boardmenu_seq = 1;
		int result = SqlSession.selectOne("board.getBoardTotalCnt", boardmenu_seq);
		
		assertNotNull(result);
		
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
		
		result = boardDao.setBoard(bv); 
		int nextseq = bv.getBoard_seq();
		
		System.out.println(nextseq);
		System.out.println(board_seq);
		logger.debug("next{}",nextseq);
		logger.debug("board{}",board_seq);
		
		assertTrue(result==nextseq);
	}
	@Test
	public void getBoardContent() {
		int board_seq = 76;
		
		BoardVo bv = boardDao.getBoardContent(board_seq);
		
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
		
		int result = boardDao.updateBoard(bv);
		
		assertTrue(result==1);
	}
	
	@Test
	public void deleteBoard() {
		int board_seq = 76;
		
		int result = boardDao.deleteBoard(board_seq);
		
		assertTrue(result==1);
	}
	
	@Test
	public void setFile() {
		
		FileVo fv = new FileVo();
		fv.setFile_name("name");
		fv.setFile_realname("realname");
		fv.setBoard_seq(76);
		fv.setFile_seq(100);
		int result = boardDao.setFile(fv);
		assertTrue(result==1);
	}
	
	@Test
	public void getFileList() {
		int board_seq = 76;
		List<FileVo> fileList = boardDao.getFileList(board_seq);
		assertNotNull(fileList);
	}
	
	@Test
	public void getFile() {
		int file_seq = 46;
		FileVo fv = boardDao.getFile(file_seq);
		assertNotNull(fv);
	}
	
	@Test
	public void setBoardresult() {
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
		result = boardDao.setBoardresult(bv);
		
		assertEquals(1, result);
	}
	
}




















