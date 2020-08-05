package kr.or.ddit.widu.view.profile;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import kr.or.ddit.widu.service.profile.IProfileService;
import kr.or.ddit.widu.util.Store;
import kr.or.ddit.widu.vo.shop.Shop_ItemVO;
import sun.misc.REException;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class ItemIfoController implements Initializable{

	
	
	@FXML ImageView item_image;
	@FXML Label item_name;
	@FXML Button closedBtn;
	@FXML Label item_info;

	public static String itemName;
	private Registry reg;
	private IProfileService profileService;
	private Shop_ItemVO item;
	
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
		
		try {
			item = profileService.selectMyItemInfo(itemName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		//////이미지 해줘야함//////
		item_name.setText(item.getShop_name());
		item_info.setText(item.getShop_detail());
		
	}


	@FXML public void closedBtnClicked(ActionEvent event) {
		Store.closedWindow(event);
	}

}
