package kr.or.ddit.Board.Service;

import java.util.List;

import kr.or.ddit.Board.Dao.BoardDao;
import kr.or.ddit.Board.Dao.BoardDaoI;
import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.BoardVo;

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
	public List<BoardVo> getAllBoardList(int boardmenu_seq) {
		return boardDao.getAllBoardList(boardmenu_seq);
	}

}
