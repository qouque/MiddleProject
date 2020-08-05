package kr.or.ddit.widu.dao.join;

import java.rmi.Remote;
import java.rmi.RemoteException;

import kr.or.ddit.widu.vo.member.MemberVO;

public interface IJoinDao extends Remote{

	public int insertMember (MemberVO mv) throws RemoteException;
}
