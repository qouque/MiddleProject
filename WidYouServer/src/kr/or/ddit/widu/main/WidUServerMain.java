package kr.or.ddit.widu.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.widu.service.board.BoardServiceImpl;
import kr.or.ddit.widu.service.board.Board_CategoryServiceImpl;
import kr.or.ddit.widu.service.board.IBoardService;
import kr.or.ddit.widu.service.board.IBoard_CategoryService;
import kr.or.ddit.widu.service.join.IJoinService;
import kr.or.ddit.widu.service.join.JoinServiceImpl;
import kr.or.ddit.widu.service.login.ILoginService;
import kr.or.ddit.widu.service.login.LoginServiceImpl;
import kr.or.ddit.widu.service.profile.IProfileService;
import kr.or.ddit.widu.service.profile.ProfileServiceImpl;
import kr.or.ddit.widu.service.question.IQuestionService;
import kr.or.ddit.widu.service.question.QuestionServiceImpl;
import kr.or.ddit.widu.service.shop.IShopService;
import kr.or.ddit.widu.service.shop.ShopService;
import kr.or.ddit.widu.service.sos.ISosService;
import kr.or.ddit.widu.service.sos.SosServiceImpl;

public class WidUServerMain {
	
	public static void main(String[] args) {
		
		try {
			Registry reg = LocateRegistry.createRegistry(8413);
			
			/*
			예시
			//희욱
			IGoodcomService goodcom 	 = GoodcomServiceImpl.getInstance();	
			
			reg.rebind("goodcomService", goodcom);
			*/
			/*이희욱*/
			IBoard_CategoryService board_cate = Board_CategoryServiceImpl.getInstance();
			IProfileService profile_service = ProfileServiceImpl.getInstance();
			
			
			/*김아현*/
			IShopService shopService = ShopService.getInstance();
			
			/*하지민*/
			IBoardService board = BoardServiceImpl.getInstance();
			IQuestionService question = QuestionServiceImpl.getInstance();
			ISosService sos = SosServiceImpl.getInstance();
			
			/*정성훈 */
			ILoginService login = LoginServiceImpl.getInstance();
			IJoinService join = JoinServiceImpl.getInstance();
			
			///////////////////////////////////////////////////////////////////////////////////////////////////
			
			/*이희욱*/
			reg.rebind("board_CategoryService", board_cate);
			reg.rebind("profileService", profile_service);
			
			/*김아현*/
			reg.rebind("shopService", shopService);
			
			/*하지민*/
			reg.rebind("boardService", board);
			reg.rebind("questionService", question);
			reg.rebind("sosService", sos);
			
			/*정성훈*/
			reg.rebind("login", login);
			reg.rebind("join", join);

		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("이게뭐시여!");
		}
		System.out.println("나의 운명을 WidU~ , 위드유 서버 구동중 ... ♥");
	}
	
}

