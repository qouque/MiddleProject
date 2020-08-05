package kr.or.ddit.widu.service.join;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.widu.dao.join.JoinDaoImpl;
import kr.or.ddit.widu.vo.member.MemberVO;

public class JoinServiceImpl extends UnicastRemoteObject implements IJoinService {
	
	private JoinDaoImpl joinDao;
	private static JoinServiceImpl service;
	
	private JoinServiceImpl() throws RemoteException {
		super();
		joinDao = JoinDaoImpl.getInstance();
	}
	
	public static JoinServiceImpl getInstance() throws RemoteException {
	
		if(service == null) {
			service = new JoinServiceImpl();
		}
		
		return service;
	}

	@Override
	public int insertMember(MemberVO mv) throws RemoteException {
		// TODO Auto-generated method stub
		return joinDao.insertMember(mv);
	}

}
