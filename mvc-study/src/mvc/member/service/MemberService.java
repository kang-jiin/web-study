package mvc.member.service;

import mvc.member.vo.MemberVO;

public interface MemberService {

	public MemberVO selectIdCheck(String id, String pwd);
	
	public int selectUserCheck(String id);
	
	public int insertJoin(String id, String pwd, String name);
}
