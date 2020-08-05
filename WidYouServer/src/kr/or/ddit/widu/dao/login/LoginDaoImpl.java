package kr.or.ddit.widu.dao.login;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.widu.util.SqlMapClientFactory;
import kr.or.ddit.widu.vo.member.MemberVO;

public class LoginDaoImpl extends UnicastRemoteObject implements ILoginDao {
	
	private SqlMapClient smc;
	
	private static LoginDaoImpl dao;
	
	private LoginDaoImpl() throws RemoteException {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static LoginDaoImpl getInstance() throws RemoteException {
		if (dao == null) {
			dao = new LoginDaoImpl();
		}
		return dao;
	}

	@Override
	public boolean memberlogin(MemberVO mv) {
		
		boolean chk = false;
		int cnt = 0;
		
		try {
			cnt = (int) (smc.queryForObject("login.getMember", mv));
			if (cnt > 0) {
				chk = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chk;
	}

	@Override
	public MemberVO getID(String mem_id) {
		MemberVO mem = null;
		
		try {
			mem = (MemberVO) smc.queryForObject("login.getID", mem_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mem;
	}
	
	

}
