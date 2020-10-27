package kr.or.ddit.member.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.model.BoardMenuVo;
import kr.or.ddit.model.MemberVo;

public class MemberDao implements MemberDaoI{

	@Override
	public MemberVo getMember(String user_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		MemberVo memberVo = sqlSession.selectOne("member.getMember", user_id);
		sqlSession.close();
		
		return memberVo;
	}

	

}
