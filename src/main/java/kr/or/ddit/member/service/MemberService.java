package kr.or.ddit.member.service;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.model.MemberVo;

public class MemberService implements MemberServiceI {

	private MemberDaoI memberDao; 
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVo getMember(String user_id) {
		
		return memberDao.getMember(user_id);
	}
	
	
}







