package kr.or.ddit.member.dao;

import org.apache.catalina.manager.DummyProxySession;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDao implements MemberDaoI{

	@Override
	public MemberVo getMember(String user_id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		MemberVo memberVo = sqlSession.selectOne("member.getMember", user_id);
		sqlSession.close();
		
		return memberVo;
	}

}
