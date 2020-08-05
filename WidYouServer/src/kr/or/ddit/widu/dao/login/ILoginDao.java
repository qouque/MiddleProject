package kr.or.ddit.widu.dao.login;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.widu.vo.member.MemberVO;

public interface ILoginDao extends Remote {
	
	public boolean memberlogin(MemberVO mv) throws RemoteException;
	
	public MemberVO getID(String mem_id) throws RemoteException;

}
