package kr.or.ddit.widu.dao.board;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.widu.util.SqlMapClientFactory;
import kr.or.ddit.widu.vo.board.BoardVO;

public class BoardDaoImpl implements IBoardDao{
	
	private static IBoardDao dao;
	private SqlMapClient client;
	
	public static IBoardDao getInstance() {
		if(dao ==null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	
	
	private BoardDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}

	@Override
	public List<BoardVO> selectOderByBoard(int category_id) {
		List<BoardVO> list = new ArrayList<>();
		
		try {
			list = client.queryForList("board.selectOderByBoard", category_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = new ArrayList<>();
		
		try {
			list = client.queryForList("board.selectAllBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> selelectTitleBoard(String board_title) {
		List<BoardVO> list =  new ArrayList<>();
		try {
			list = client.queryForList("board.selelectTitleBoard");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	
	@Override
	public int insertBoard(BoardVO board) {
		int cnt = 0;
		try {
			Object obj = client.insert("board.insertBoard", board);
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public BoardVO selectBoardId(int board_id) {
		BoardVO board = new BoardVO();
		
		try {
			board = (BoardVO) client.queryForObject("board.selectBoardId", board_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return board;

	}

	@Override
	public List<BoardVO> selectWriter(String board_writer) {
		List<BoardVO> list = new ArrayList<>();
		
		try {
			list = client.queryForList("board.selectWriter");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateBoard(BoardVO board) {
		int cnt = 0;
		try {
			Object obj = client.insert("board.updateBoard", board);
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int board_id) {
		int cnt = 0;
		try {
			Object obj = client.insert("board.deleteBoard", board_id);
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> selectMyBoard(String mem_id){
		List<BoardVO> list = null;
		
		try {
			list = client.queryForList("board.selectMyBoard", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BoardVO> selectMyBoardBycate(BoardVO board){
		
		List<BoardVO> list = null;
		
		try {
			list = client.queryForList("board.selectMyBoardBycate",board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);/////
		return list;
	}
	
	
	
	
}
