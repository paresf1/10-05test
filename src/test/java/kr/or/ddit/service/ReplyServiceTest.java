package kr.or.ddit.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

public class ReplyServiceTest {

	ReplyServiceI replyService = new ReplyService();
	
	@Test
	public void getReply(){
		int board_seq = 76;
		List<ReplyVo> replyList =  replyService.getReply(board_seq);
		assertNotNull(replyList);
	}
	@Test
	public void setReply() {
		
		ReplyVo revo = new ReplyVo();
		revo.setBoard_seq(76);
		revo.setReply_content("내용");
		revo.setUser_id("lss");
		revo.setReply_seq(200);
		int result = replyService.setReply(revo);
		assertTrue(result ==1);
	}

	@Test
	public void deleteReply() {
		int reply_seq = 58;
		int result = replyService.deleteReply(reply_seq);
		assertTrue(result ==1);
	}
}
