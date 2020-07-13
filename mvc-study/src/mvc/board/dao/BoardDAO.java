package mvc.board.dao;

import java.util.ArrayList;

import mvc.board.vo.BoardVO;

public interface BoardDAO {
	
	public ArrayList<BoardVO> selectBoards();

	public int insertBoard(String writer, String content);
}
