package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.model.ReplyVo;

public class ReplyDao implements ReplyDaoI{

	@Override
	public List<ReplyVo> getReply(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<ReplyVo> replyList = sqlSession.selectList("reply.getReply", board_seq);
		sqlSession.close();
		return replyList;
	}

	@Override
	public int setReply(ReplyVo rv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0; 
		
		try {
			result = sqlSession.insert("reply.setReply", rv);
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
	public int deleteReply(int reply_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int result = 0; 
		
		try {
			result = sqlSession.update("reply.deleteReply",reply_seq);
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

}
