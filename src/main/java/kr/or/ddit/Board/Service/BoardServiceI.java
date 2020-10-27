package kr.or.ddit.Board.Service;

import java.util.List;

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

	//BoardList를 가져오기 위한 메서드
	List<BoardVo> getAllBoardList(int boardmenu_seq);
	
}