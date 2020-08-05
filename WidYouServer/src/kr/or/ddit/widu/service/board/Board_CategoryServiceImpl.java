package kr.or.ddit.widu.service.board;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.widu.dao.board.Board_CategoryDaoImpl;
import kr.or.ddit.widu.dao.board.IBoard_CategoryDao;
import kr.or.ddit.widu.vo.board.Board_categoryVO;

public class Board_CategoryServiceImpl extends UnicastRemoteObject implements IBoard_CategoryService{
	
	private static IBoard_CategoryService service;
	private IBoard_CategoryDao dao;
	protected Board_CategoryServiceImpl() throws RemoteException {
		super();
		dao = Board_CategoryDaoImpl.getInstance();
	}
	
	public static IBoard_CategoryService getInstance() throws RemoteException {
		if(service == null) {
			service = new Board_CategoryServiceImpl();
		}
		return service;
	}

	@Override
	public List<Board_categoryVO> selectAllUserCate() throws RemoteException {
		return dao.selectAllUserCate();
	}
	
	
}
