package mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.board.vo.BoardVO;
import util.DBconn;

public class BoardDAOImpl {

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
	

	public int insertBoard(String writer, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		conn = DBconn.getConnetion();
		String sql = "insert into board (id, writer, content) "
				   + "values ( board_seq.NEXTVAL , ? , ? )";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, content);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBconn.close(pstmt, rs);
		}
		
		return result;
	}	

}
