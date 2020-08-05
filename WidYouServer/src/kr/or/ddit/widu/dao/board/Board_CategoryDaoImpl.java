package kr.or.ddit.widu.dao.board;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.widu.util.SqlMapClientFactory;
import kr.or.ddit.widu.vo.board.Board_categoryVO;

public class Board_CategoryDaoImpl implements IBoard_CategoryDao{
	
	private static IBoard_CategoryDao dao;
	
	private SqlMapClient smc;
	
	private Board_CategoryDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IBoard_CategoryDao getInstance() {
		if(dao == null) {
			dao = new Board_CategoryDaoImpl();
		}
		return dao;
	}

	@Override
	public List<Board_categoryVO> selectAllUserCate() {
		
		List<Board_categoryVO> list = null;
		
		try {
			list = smc.queryForList("board_cate.selectAllUserCate");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
}
