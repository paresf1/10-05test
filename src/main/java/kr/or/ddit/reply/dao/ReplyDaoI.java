package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.model.ReplyVo;

public interface ReplyDaoI {
	
	
	//해당 게시글의 댓글을 조회하기 위한 메서드
	List<ReplyVo> getReply(int board_seq);
	
	//해당 게시글의 댓글을 등록하기 위한 메서드
	int setReply(ReplyVo rv);
}