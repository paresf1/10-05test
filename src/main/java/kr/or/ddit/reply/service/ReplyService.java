package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.model.ReplyVo;
import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoI;

public class ReplyService implements ReplyServiceI{

	private ReplyDaoI replydao;
	public ReplyService() {
		replydao = new ReplyDao();
	}
	
	@Override
	public List<ReplyVo> getReply(int board_seq) {
		return replydao.getReply(board_seq);
	}

	@Override
	public int setReply(ReplyVo rv) {
		return replydao.setReply(rv);
	}

	
	
}
