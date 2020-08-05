package kr.or.ddit.widu.view.profile;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import kr.or.ddit.widu.main.LoginSession;
import kr.or.ddit.widu.service.board.IBoardService;
import kr.or.ddit.widu.service.profile.IProfileService;
import kr.or.ddit.widu.util.Store;
import kr.or.ddit.widu.util.UtilFactory;
import kr.or.ddit.widu.vo.member.MemberVO;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemboxController implements Initializable {
	
	@FXML VBox itemVbox;
	@FXML ImageView closedBtn;

	private List<Shop_ItemVO> list;
	private Registry reg;
	private IProfileService profileService;
	private UtilFactory util;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			reg = LocateRegistry.getRegistry("localhost", 8413);
			
			
			profileService = (IProfileService) reg.lookup("profileService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		util = new UtilFactory();
		MemberVO mem = LoginSession.session;
		
		try {
			list = profileService.selectMyItem(mem.getMem_id());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		
		if(list != null) {
			for (int i = 0; i < list.size(); i++) {
				
				AnchorPane item = util.itemBoxChildren(list.get(i).getShop_name(), profileService);
				
				itemVbox.getChildren().add(item);
			}
			
		}
		
		
	}

	
	/**
	 * 창닫기
	 * @param event
	 */
	@FXML public void closedBtnClicked(MouseEvent event) {
		
		Store.closedWindow(event);
		Store.show_new_window(getClass().getResource("/kr/or/ddit/widu/view/profile/profile.fxml"), "마이페이지");
		
	}
	
	
}
