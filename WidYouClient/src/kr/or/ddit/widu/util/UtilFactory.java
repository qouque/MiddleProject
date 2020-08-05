package kr.or.ddit.widu.util;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import kr.or.ddit.widu.service.profile.IProfileService;
import kr.or.ddit.widu.view.profile.ItemIfoController;

public class UtilFactory {
	
	public AnchorPane itemBoxChildren(String itemName, IProfileService profileService) {
		
		AnchorPane children = new AnchorPane();
		children.setPrefSize(440, 139);
		
		ImageView itemimage = new ImageView();
		itemimage.setFitHeight(89);
		itemimage.setFitWidth(94);
		itemimage.setLayoutX(27);
		itemimage.setLayoutY(25);
		
		Label itemNameLabel = new Label(itemName);
		itemNameLabel.setPrefSize(150, 55);
		itemNameLabel.setLayoutX(137);
		itemNameLabel.setLayoutY(42);
		
		Button infoBtn = new Button("상세 보기");
		infoBtn.setPrefSize(125, 43);
		infoBtn.setLayoutX(295);
		infoBtn.setLayoutY(48);
		
		Separator sp = new Separator();
		sp.setPrefSize(422, 4);
		sp.setLayoutX(9);
		sp.setLayoutY(123);
		
		children.getChildren().addAll(itemimage, itemNameLabel, infoBtn, sp);
		
		infoBtn.setOnAction((e) -> {
			
			ItemIfoController.itemName = itemNameLabel.getText();
			Store.show_new_window(getClass().getResource("/kr/or/ddit/widu/view/profile/iteminfo.fxml"), "아이템 상세정보");
			
		});
		
		return children;
	}
	
	
}
