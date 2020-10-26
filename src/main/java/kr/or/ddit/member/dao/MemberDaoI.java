package kr.or.ddit.member.dao;

import kr.or.ddit.member.model.MemberVo;

public interface MemberDaoI {
	
	// id를 얻어서 로그인을 확인하기 위한 메서드
	MemberVo getMember(String user_id);
}
