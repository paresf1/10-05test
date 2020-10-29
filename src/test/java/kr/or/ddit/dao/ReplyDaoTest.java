package kr.or.ddit.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.model.ReplyVo;
import org.junit.Test;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoI;

public class ReplyDaoTest {

	ReplyDaoI replydao = new ReplyDao();
	@Test
	public void getReply(){
		int board_seq = 76;
		List<ReplyVo> replyList =  replydao.getReply(board_seq);
		assertNotNull(replyList);
	}
	@Test
	public void setReply() {
		
		ReplyVo revo = new ReplyVo();
		revo.setBoard_seq(76);
		revo.setReply_content("내용");
		revo.setUser_id("lss");
		revo.setReply_seq(200);
		int result = replydao.setReply(revo);
		assertTrue(result ==1);
	}

	@Test
	public void deleteReply() {
		int reply_seq = 58;
		int result = replydao.deleteReply(reply_seq);
		assertTrue(result ==1);
	}
}





