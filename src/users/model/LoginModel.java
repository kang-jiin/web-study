package users.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import users.vo.UsersVO;

public class LoginModel {
	
	public UsersVO selectIdCheck(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UsersVO mvo = new UsersVO();
		
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
}
