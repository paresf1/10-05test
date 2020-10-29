package kr.or.ddit.Board.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.Board.Dao.BoardDao;
import kr.or.ddit.Board.Dao.BoardDaoI;
import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.FileVo;

public class BoardService implements BoardServiceI {

	BoardDaoI boardDao;
	
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	@Override
	public List<BoardMenuVo> getAllmenu() {
		return boardDao.getAllmenu();
	}

	@Override
	public int setBoardmenu(BoardMenuVo bmvo) {
		
		return boardDao.setBoardmenu(bmvo);
	}

	@Override
	public int updateBoardmenu(BoardMenuVo bmvo) {
		return boardDao.updateBoardmenu(bmvo);
	}

	@Override
	public List<BoardMenuVo> getAllBoardmenuUpdate() {
		return boardDao.getAllBoardmenuUpdate();
	}


	@Override
	public Map<String, Object> getAllBoardList(BoardVo bv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardList", boardDao.getAllBoardList(sqlSession,bv));
		
		int totalCnt = boardDao.selectMemberTotalCnt(sqlSession, bv.getBoardmenu_seq());
		int pageSize = bv.getPageSize();
		int pages = (int)Math.ceil( (double)totalCnt/pageSize);
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}

	@Override
	public int setBoard(BoardVo bv) {
		return boardDao.setBoard(bv);
	}
	

	@Override
	public BoardVo getBoardContent(int board_seq) {
		return boardDao.getBoardContent(board_seq);
	}

	@Override
	public int setFile(FileVo fv) {
		return boardDao.setFile(fv);
	}

	@Override
	public List<FileVo> getFileList(int board_seq) {
		return boardDao.getFileList(board_seq);
	}

	@Override
	public FileVo getFile(int file_seq) {
		return boardDao.getFile(file_seq);
	}

	@Override
	public int updateBoard(BoardVo bv) {
		return boardDao.updateBoard(bv);
	}

	@Override
	public int deleteFile(int file_seq) {
		return boardDao.deleteFile(file_seq);
	}

	@Override
	public int deleteBoard(int board_seq) {
		return boardDao.deleteBoard(board_seq);
	}

	@Override
	public int setBoardChild(BoardVo bv) {
		return boardDao.setBoardChild(bv);
	}
}
