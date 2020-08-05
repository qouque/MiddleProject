package kr.or.ddit.widu.service.profile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.widu.dao.profile.IProfileDao;
import kr.or.ddit.widu.dao.profile.ProfileDaoImpl;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import sun.misc.REException;

public class ProfileServiceImpl extends UnicastRemoteObject implements IProfileService{

	private IProfileDao dao;
	private static IProfileService service;
	
	protected ProfileServiceImpl() throws RemoteException {
		super();
		dao = ProfileDaoImpl.getInstance();
	}
	
	public static IProfileService getInstance() throws RemoteException {
		if(service == null) {
			service = new ProfileServiceImpl();
		}
		return service;
	}
	
	@Override
	public int countMyLike(String mem_id) throws RemoteException {
		return dao.countMyLike(mem_id);
	}

	@Override
	public int countMyHate(String mem_id) throws RemoteException {
		return dao.countMyHate(mem_id);
	}

	@Override
	public List<Shop_ItemVO> selectMyItem(String mem_id) throws RemoteException {
		return dao.selectMyItem(mem_id);
	}

	@Override
	public Shop_ItemVO selectMyItemInfo(String shop_item_name) throws RemoteException {
		return dao.selectMyItemInfo(shop_item_name);
	}

}
