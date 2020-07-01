package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.vo.MemberVO;

public class MemberModel {

	public ArrayList<MemberVO> selectMembers(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> mlist = null;
		
		conn = DBconn.getConnetion();
		String sql = "select * from users";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			mlist = new ArrayList<MemberVO>();
			
			while(rs.next()) {
				MemberVO mvo = new MemberVO();
				
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd")); 
				mvo.setName(rs.getString("name"));
				
				mlist.add(mvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.close(pstmt, rs);
		}
		return mlist;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
