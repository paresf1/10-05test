package kr.or.ddit.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.model.MemberVo;

public class MemberServiceTest {

	MemberServiceI memberService = new MemberService();
	@Test
	public void getMembertest() {
		
		/***Given***/
		String userId = "lss";
		String pass = "lss";
		
		/***When***/
		MemberVo memberVo = memberService.getMember(userId);
		
		
		/***Then***/
		assertEquals(userId, memberVo.getUser_id());
		assertEquals(pass, memberVo.getUser_pass());
	}
}
