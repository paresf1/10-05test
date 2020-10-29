package kr.or.ddit.dao;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.Mybatis.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.model.MemberVo;

public class MemberDaoTest {

	MemberDaoI memberdao = new MemberDao();
	@Test
	public void getMembertest() {
		
		/***Given***/
		String userId = "lss";
		String pass = "lss";
		
		/***When***/
		MemberVo memberVo = memberdao.getMember(userId);
		
		
		/***Then***/
		assertEquals(userId, memberVo.getUser_id());
		assertEquals(pass, memberVo.getUser_pass());
	}
}
