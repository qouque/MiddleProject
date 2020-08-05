package kr.or.ddit.widu.dao.shop;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import kr.or.ddit.widu.vo.shop.Shop_RubbyVO;

public interface IShopDao {
	
	
	/**
	 * DB에 있는 아이템 데이터를 불러오는 메소드
	 * @return Shop_ItemVO에 있는 모든 데이터
	 */
	public List<Shop_ItemVO> selectAllItems(Map<String, String> params);
	
	public int insertItem(Shop_ItemVO itemInfo);
	
	public int modifyItem(Shop_ItemVO itemInfo);
	
	public int deleteItem(Map<String, String> params);
	
	public List<Shop_RubbyVO> rubyselectallitems(Map<String, String> params);
	
	public int rubyinsertItem(Shop_RubbyVO rubyInfo);
	
	public int rubymodifyItem(Shop_RubbyVO rubyInfo);
	
	public int rubydeleteItem(Map<String, String> params);
	
	public List<Shop_ItemVO> newItemList();
	
	public List<Shop_ItemVO> popularItemList();
	
	public Shop_ItemVO itemInfo(Map<String, String> params);
}
