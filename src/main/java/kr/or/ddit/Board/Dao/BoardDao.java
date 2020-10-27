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
		
		List<BoardMenuVo> boardList =  sqlSession.selectList("boardMenu.getAllBoardmenu");

		sqlSession.close();
		return boardList;
	}

	@Override
	public int setBoardmenu(BoardMenuVo bmvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0;
		
		try {
			result =  sqlSession.insert("boardMenu.setBoardmenu", bmvo);
		} catch (Exception e) {
			// 
		}
		
		if(result ==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}

		sqlSession.close();
		return result;
	}

	@Override
	public int updateBoardmenu(BoardMenuVo bmvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0;
		result =  sqlSession.update("boardMenu.updateBoardmenu", bmvo);
		
		if(result ==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}

		sqlSession.close();
		return result;
	}

	@Override
	public List<BoardMenuVo> getAllBoardmenuUpdate() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardMenuVo> boardList =  sqlSession.selectList("boardMenu.getAllBoardmenuUpdate");
		sqlSession.close();
		
		return boardList;
	}

	@Override
	public List<BoardVo> getAllBoardList(int boardmenu_seq) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> boardList =  sqlSession.selectList("boardMenu.getAllBoardList", boardmenu_seq);
		sqlSession.close();
		
		return boardList;
	}

}
