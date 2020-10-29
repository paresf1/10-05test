package kr.or.ddit.Board.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.FileVo;

public class BoardDao implements BoardDaoI {

	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	@Override
	public List<BoardMenuVo> getAllmenu() {

		SqlSession sqlSession = MybatisUtil.getSqlSession();

		List<BoardMenuVo> boardList = sqlSession.selectList("boardMenu.getAllBoardmenu");

		sqlSession.close();
		return boardList;
	}

	@Override
	public int setBoardmenu(BoardMenuVo bmvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0;

		try {
			result = sqlSession.insert("boardMenu.setBoardmenu", bmvo);
		} catch (Exception e) {
			//
		}

		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();
		return result;
	}

	@Override
	public int updateBoardmenu(BoardMenuVo bmvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0;
		result = sqlSession.update("boardMenu.updateBoardmenu", bmvo);

		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		sqlSession.close();
		return result;
	}

	@Override
	public List<BoardMenuVo> getAllBoardmenuUpdate() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardMenuVo> boardList = sqlSession.selectList("boardMenu.getAllBoardmenuUpdate");
		sqlSession.close();

		return boardList;
	}

	@Override
	public List<BoardVo> getAllBoardList(SqlSession SqlSession, BoardVo bv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.getAllBoardList", bv);
		sqlSession.close();

		return boardList;
	}

	@Override
	public int selectMemberTotalCnt(SqlSession SqlSession, int boardmenu_seq) {
		return SqlSession.selectOne("board.getBoardTotalCnt", boardmenu_seq);
	}

	@Override
	public int setBoard(BoardVo bv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result =0;
		int board_seq = 0;
		try {
			result = sqlSession.insert("board.setBoard", bv);
			board_seq = bv.getBoard_seq();
			logger.debug("selectkey셀렉트 키 값!!{}", board_seq);
		} catch (Exception e) {
			//
		}
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return board_seq;
	}

	@Override
	public BoardVo getBoardContent(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		BoardVo bv = sqlSession.selectOne("board.getBoardContent", board_seq);
		
		sqlSession.close();
		return bv;
		
	}



	@Override
	public int updateBoard(BoardVo bv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0;
		result = sqlSession.update("board.updateBoard", bv);

		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}



	@Override
	public int deleteBoard(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0;
		result =sqlSession.update("board.deleteBoard", board_seq);

		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}
	
	@Override
	public int setFile(FileVo fv) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result =0; 
		try {
			result = sqlSession.insert("file.setFile", fv);
		} catch (Exception e) {
			//
		}
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public List<FileVo> getFileList(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<FileVo> fileList = sqlSession.selectList("file.getFileList", board_seq);
		sqlSession.close();
		return fileList;
	}

	@Override
	public FileVo getFile(int file_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		FileVo fv = sqlSession.selectOne("file.getFile", file_seq);
		sqlSession.close();
		return fv;
	}
	
	@Override
	public int deleteFile(int file_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0;
		result = sqlSession.delete("file.deleteFile", file_seq);

		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int setBoardChild(BoardVo bv) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0;
		result = sqlSession.delete("board.setBoardChild", bv);

		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int setBoardresult(BoardVo bv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result =0;
		try {
			result = sqlSession.insert("board.setBoard", bv);
		} catch (Exception e) {
		}
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}
}











