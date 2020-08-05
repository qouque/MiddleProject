package kr.or.ddit.widu.dao.board;

import java.rmi.Remote;
import java.util.List;

import kr.or.ddit.widu.vo.board.Board_categoryVO;

public interface IBoard_CategoryDao{
	
	/**
	 * 모든 카테고리 정보를 담아오는 메소드
	 * @return 카테고리 테이블에 있는 모든 데이터
	 */
	public List<Board_categoryVO> selectAllUserCate();
	
}
