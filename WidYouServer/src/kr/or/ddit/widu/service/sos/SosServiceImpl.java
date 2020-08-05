package kr.or.ddit.widu.service.sos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.widu.dao.board.BoardDaoImpl;
import kr.or.ddit.widu.dao.board.IBoardDao;
import kr.or.ddit.widu.dao.sos.ISosDao;
import kr.or.ddit.widu.dao.sos.SosDaoImpl;
import kr.or.ddit.widu.service.board.BoardServiceImpl;
import kr.or.ddit.widu.service.board.IBoardService;
import kr.or.ddit.widu.vo.board.BoardVO;
import kr.or.ddit.widu.vo.report.Report_BoardVO;

public class SosServiceImpl extends UnicastRemoteObject implements ISosService{

	protected SosServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	ISosDao dao = SosDaoImpl.getInstance();

	private static ISosService service;
	
	public static ISosService getInstance() throws RemoteException {
		
		if(service == null) {
			service = new SosServiceImpl();
		}
		return service;
		
	}

	@Override
	public List<Report_BoardVO> selectAllBoard() throws RemoteException {
		return dao.selectAllBoard();
	}

	@Override
	public List<Report_BoardVO> selelectTitleBoard(String report_title) throws RemoteException {
		return dao.selelectTitleBoard(report_title);
	}

	@Override
	public int insertBoard(Report_BoardVO board) throws RemoteException {
		return dao.insertBoard(board);
	}

	@Override
	public List<Report_BoardVO> selectOderByBoard(int report_id) throws RemoteException {
		return dao.selectOderByBoard(report_id);
	}

	@Override
	public Report_BoardVO selectBoardId(int report_id) throws RemoteException {
		return dao.selectBoardId(report_id);
	}

	@Override
	public List<Report_BoardVO> selectWriter(String report_com_id) throws RemoteException {
		return dao.selectWriter(report_com_id);
	}

	@Override
	public int updateBoard(Report_BoardVO board) throws RemoteException {
		return dao.updateBoard(board);
	}

	@Override
	public int deleteBoard(int board) throws RemoteException {
		return dao.deleteBoard(board);
	}



	
}
