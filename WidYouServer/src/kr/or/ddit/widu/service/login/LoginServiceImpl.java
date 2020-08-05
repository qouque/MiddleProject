package kr.or.ddit.widu.service.login;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;


import kr.or.ddit.widu.dao.login.LoginDaoImpl;
import kr.or.ddit.widu.vo.member.MemberVO;

public class LoginServiceImpl extends UnicastRemoteObject implements ILoginService {
	
	private LoginDaoImpl loginDao;
	
	private static LoginServiceImpl service;
	

	protected LoginServiceImpl() throws RemoteException {
		super();

		loginDao = LoginDaoImpl.getInstance();
	}
	
	public static LoginServiceImpl getInstance() throws RemoteException {
		if(service == null) {
			service = new LoginServiceImpl();
		}
		return service;
	}

	@Override
	public boolean memberlogin(MemberVO mv) throws RemoteException {
		// TODO Auto-generated method stub
		return loginDao.memberlogin(mv);
	}

	@Override
	public MemberVO getID(String mem_id) throws RemoteException {
		// TODO Auto-generated method stub
		return loginDao.getID(mem_id);
	}

}
