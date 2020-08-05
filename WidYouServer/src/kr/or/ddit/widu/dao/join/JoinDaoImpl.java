package kr.or.ddit.widu.dao.join;

import java.rmi.RemoteException;
import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.widu.util.SqlMapClientFactory;
import kr.or.ddit.widu.vo.member.MemberVO;

public class JoinDaoImpl implements IJoinDao {
	
	private SqlMapClient smc;
	
	private static JoinDaoImpl dao;
	
	private JoinDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static JoinDaoImpl getInstance() {
		if(dao == null) {
			dao = new JoinDaoImpl();
		}
		return dao;
	}

	@Override
	public int insertMember(MemberVO mv) throws RemoteException {
		
		int cnt = 0;
		
		Object obj = null;
		
		try {
			obj = smc.insert("join.insertMember", mv);
			
			if(obj == null) {
				cnt = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
		
	}

}
