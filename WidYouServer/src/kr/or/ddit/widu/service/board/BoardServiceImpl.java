package kr.or.ddit.widu.service.board;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.widu.dao.board.BoardDaoImpl;
import kr.or.ddit.widu.dao.board.IBoardDao;
import kr.or.ddit.widu.vo.board.BoardVO;

public class BoardServiceImpl extends UnicastRemoteObject implements IBoardService{
	IBoardDao dao = BoardDaoImpl.getInstance();

	private static IBoardService service;
	
	public static IBoardService getInstance() throws RemoteException {
		
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
		
	}
	
	protected BoardServiceImpl() throws RemoteException {
		
	}

	@Override
	public List<BoardVO> selectOderByBoard(int category_id) throws RemoteException {
		return dao.selectOderByBoard(category_id);
	}

	@Override
	public List<BoardVO> selectAllBoard() throws RemoteException {
		return dao.selectAllBoard();
	}

	@Override
	public List<BoardVO> selelectTitleBoard(String board_title) throws RemoteException {
		return dao.selelectTitleBoard(board_title);
	}

	@Override
	public int insertBoard(BoardVO board) throws RemoteException {
		return dao.insertBoard(board);
	}

	@Override
	public BoardVO selectBoardId(int board_id) throws RemoteException {
		return dao.selectBoardId(board_id);
	}

	@Override
	public List<BoardVO> selectWriter(String board_writer) throws RemoteException {
		return dao.selectWriter(board_writer);
	}

	@Override
	public int updateBoard(BoardVO board) throws RemoteException {
		return dao.updateBoard(board);
	}

	@Override
	public int deleteBoard(int board_id) throws RemoteException {
		return dao.deleteBoard(board_id);
	}

	@Override
	public List<BoardVO> selectMyBoard(String mem_id) throws RemoteException {
		return dao.selectMyBoard(mem_id);
	}

	@Override
	public List<BoardVO> selectMyBoardBycate(BoardVO board) throws RemoteException {
		return dao.selectMyBoardBycate(board);
	}
	
	
}
