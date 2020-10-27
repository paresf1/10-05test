package kr.or.ddit.Board.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;

public class BoardDao implements BoardDaoI {

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
		try {
			result = sqlSession.insert("board.setBoard", bv);
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
	public BoardVo getBoardContent(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		BoardVo bv = sqlSession.selectOne("board.getBoardContent", board_seq);
		
		sqlSession.close();
		return bv;
	}
}
