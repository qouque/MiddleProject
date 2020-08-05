package kr.or.ddit.widu.dao.profile;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.widu.util.SqlMapClientFactory;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import sun.misc.REException;

public class ProfileDaoImpl implements IProfileDao{

	private static IProfileDao dao;
	private SqlMapClient smc;
	
	private  ProfileDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	
	public static IProfileDao getInstance() {
		if(dao == null) {
			dao = new ProfileDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public int countMyLike(String mem_id) throws RemoteException {
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("profile.countMyLike",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int countMyHate(String mem_id) throws RemoteException {
		int cnt = 0;
		
		try {
			cnt = (int) smc.queryForObject("profile.countMyHate",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<Shop_ItemVO> selectMyItem(String mem_id) throws RemoteException {
		List<Shop_ItemVO> list = null;
		
		try {
			list = smc.queryForList("profile.selectMyItem", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Shop_ItemVO selectMyItemInfo(String shop_item_name) throws RemoteException {
		Shop_ItemVO item = null;
		
		try {
			item = (Shop_ItemVO) smc.queryForObject("profile.selectMyItemInfo", shop_item_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return item;
	}

}
