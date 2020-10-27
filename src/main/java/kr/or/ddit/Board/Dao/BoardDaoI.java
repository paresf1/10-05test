package kr.or.ddit.Board.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.BoardVo;

public interface BoardDaoI {

	//BoardMenu의 사용의 경우에만 전체 리스트를 불러오기 위한 메서드
	List<BoardMenuVo> getAllmenu();
	
	//BoardMenu의 업데이트 이후 전체 리스트를 불러오기 위한 메서드
	List<BoardMenuVo> getAllBoardmenuUpdate();
	
	//BoardMenu를 생성하기 위한 메서드
	int setBoardmenu(BoardMenuVo bmvo);
	
	//BoardMenu를 수정하기 위한 메서드
	int updateBoardmenu(BoardMenuVo bmvo);
	
	//BoardList를 가져오기 위한 메서드
//	List<BoardVo> getAllBoardList(int boardmenu_seq);
	
	//전체게시글 개수에 따른 리스트 목록과 페이지를 같이 보여주기 위한 메서드
	List<BoardVo> getAllBoardList(SqlSession SqlSession,BoardVo bv);
	
	//게시글 전체개수를 보여주기 위한 메서드
	int selectMemberTotalCnt(SqlSession SqlSession,int boardmenu_seq);
	
	// Board게시글을 생성하기 위한 메서드
	int setBoard(BoardVo bv);
	
	// 게시글을 클릭 했을때 그에 대한 내용을 조회하기 위한 메서드
	BoardVo getBoardContent(int board_seq);
}



















