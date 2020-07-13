package mvc.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.member.vo.MemberVO;
import util.DBconn;
import mvc.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{
	
	public MemberVO selectIdCheck(String id, String pwd){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO mvo = new MemberVO();
		
		conn = DBconn.getConnetion();
		String sql = "select * from users "
				+ "where id = ? "
				+ "and pwd = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBconn.close(pstmt, rs);
		}
		
		return mvo;		
	}
	
	
	public int selectUserCheck(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		conn = DBconn.getConnetion();
		String sql = "select count(id) from users "
				+ "where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.close(pstmt, rs);
		}
		
		return result;
	}
	
	
	public int insertJoin(String id, String pwd, String name){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		conn = DBconn.getConnetion();
		String sql = "insert into users (id, pwd, name) "
				   + "values ( ? , ? , ? )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.close(pstmt, rs);
		}
		return result;
	}

}
