package mvc.member.service;

import mvc.member.dao.MemberDAO;
import mvc.member.dao.MemberDAOImpl;
import mvc.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO memberDAO = new MemberDAOImpl();

	public MemberVO selectIdCheck(String id, String pwd) {
		return memberDAO.selectIdCheck(id, pwd);
	}
	
	public int selectUserCheck(String id) {
		return memberDAO.selectUserCheck(id);
	}
	
	public int insertJoin(String id, String pwd, String name) {
		return memberDAO.insertJoin(id, pwd, name);
	}
}
