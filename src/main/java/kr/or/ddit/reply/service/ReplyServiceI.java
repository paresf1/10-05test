package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.model.ReplyVo;

public interface ReplyServiceI {

	//해당 게시글의 댓글을 조회하기 위한 메서드
	List<ReplyVo> getReply(int board_seq);
	
	//해당 게시글의 댓글을 등록하기 위한 메서드
	int setReply(ReplyVo rv);
	
	//댓글을 삭제하기 위한 메서드
	int deleteReply(int reply_seq);
}
