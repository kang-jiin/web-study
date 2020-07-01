package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.model.DBconn;
import board.vo.BoardVO;

public class BoardModel {

	public ArrayList<BoardVO> selectBoards(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVO> blist = null;
		
		conn = DBconn.getConnetion();
		String sql = "select * from board";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			blist = new ArrayList<BoardVO>();
			
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				
				bvo.setId(rs.getInt("id"));
				bvo.setWriter(rs.getString("writer")); 
				bvo.setContent(rs.getString("content"));
				
				blist.add(bvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.close(pstmt, rs);
		}
		return blist;
		
		
	}

}
