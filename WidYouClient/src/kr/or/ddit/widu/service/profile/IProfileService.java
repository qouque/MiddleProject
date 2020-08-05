package kr.or.ddit.widu.service.profile;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import sun.misc.REException;

/**
 * 프로필 관련 된 소스들이 모여있는 인터페이스
 * @author lhu
 *
 */
public interface IProfileService extends Remote{
	
	/**
	 * 내가 받은 좋아요수를 리턴 해주는 메소드
	 * @param mem_id
	 * @return 내가 받은 좋아요수
	 * @throws RemoteException
	 */
	public int countMyLike(String mem_id) throws RemoteException;
	
	/**
	 * 내가받은 싫어요수를 리턴 해주는 메소드
	 * @param mem_id
	 * @return 내가받은 싫어요 수
	 * @throws RemoteException
	 */
	public int countMyHate(String mem_id) throws RemoteException;
	
	/**
	 * 나의 아이템 보관함에 있는 아이템을 보여주는 메소드
	 * @param mem_id
	 * @return 내가 가지고있는 아이템
	 * @throws RemoteException
	 */
	public List<Shop_ItemVO> selectMyItem(String mem_id) throws RemoteException;
	
	/**
	 * 내가 가지고있는 아이템의 상세정보를 출력해주는 메소드
	 * @param shop_item_name
	 * @return 아이템 상세정보
	 * @throws REException
	 */
	public Shop_ItemVO selectMyItemInfo(String shop_item_name) throws RemoteException;
}
