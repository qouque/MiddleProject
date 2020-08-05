package kr.or.ddit.widu.service.shop;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.widu.dao.shop.IShopDao;
import kr.or.ddit.widu.dao.shop.ShopDao;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import kr.or.ddit.widu.vo.shop.Shop_RubbyVO;

public class ShopService extends UnicastRemoteObject implements IShopService {
	
	private static ShopService instance;
	private IShopDao dao;
	
	private ShopService() throws RemoteException {
		dao = ShopDao.getInstance();
	}
	
	public static IShopService getInstance() throws RemoteException {
		return (instance == null) ? instance = new ShopService() : instance;
	}

	@Override
	public List<Shop_ItemVO> selectAllItems(Map<String, String> params) throws RemoteException {
		return dao.selectAllItems(params);
	}

	@Override
	public int insertItem(Shop_ItemVO itemInfo) throws RemoteException {
		return dao.insertItem(itemInfo);
	}

	@Override
	public int modifyItem(Shop_ItemVO itemInfo) throws RemoteException {
		return dao.modifyItem(itemInfo);
	}

	@Override
	public int deleteItem(Map<String, String> params) throws RemoteException {
		return dao.deleteItem(params);
	}

	@Override
	public List<Shop_RubbyVO> rubyselectallitems(Map<String, String> params) throws RemoteException {
		return dao.rubyselectallitems(params);
	}

	@Override
	public int rubyinsertItem(Shop_RubbyVO rubyInfo) throws RemoteException {
		return dao.rubyinsertItem(rubyInfo);
	}

	@Override
	public int rubymodifyItem(Shop_RubbyVO rubyInfo) throws RemoteException {
		
		return dao.rubymodifyItem(rubyInfo);
	}

	@Override
	public int rubydeleteItem(Map<String, String> params) throws RemoteException {
		return dao.rubydeleteItem(params);
	}

	@Override
	public List<Shop_ItemVO> newItemList() throws RemoteException {
		return dao.newItemList();
	}

	@Override
	public List<Shop_ItemVO> popularItemList() throws RemoteException {
		return dao.popularItemList();
	}

	@Override
	public Shop_ItemVO itemInfo(Map<String, String> params) throws RemoteException {
		return dao.itemInfo(params);
	}
}
