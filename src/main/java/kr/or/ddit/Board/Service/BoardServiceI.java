package kr.or.ddit.Board.Service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.BoardVo;

public interface BoardServiceI {
	//BoardMenu의 전체 리스트를 불러오기 위한 메서드
	List<BoardMenuVo> getAllmenu();
	
	//BoardMenu의 업데이트 이후 전체 리스트를 불러오기 위한 메서드
	List<BoardMenuVo> getAllBoardmenuUpdate();
	
	//BoardMenu를 생성하기 위한 메서드
	int setBoardmenu(BoardMenuVo bmvo);
	
	//BoardMenu를 수정하기 위한 메서드
	int updateBoardmenu(BoardMenuVo bmvo);

	//전체게시글 개수에 따른 리스트 목록과 페이지를 같이 보여주기 위한 메서드
	Map<String, Object> getAllBoardList(BoardVo bv);

	// Board게시글을 생성하기 위한 메서드
	int setBoard(BoardVo bv);
	
//	게시글을 클릭 했을때 그에 대한 내용을 조회하기 위한 메서드
	BoardVo getBoardContent(int board_seq);
	
}
