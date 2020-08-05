package kr.or.ddit.widu.service.question;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class QuestionServiceImpl extends UnicastRemoteObject implements IQuestionService{

	private static IQuestionService service;
	
	public static IQuestionService getInstance() throws RemoteException {
		
		if(service==null) {
			service = new QuestionServiceImpl();
			
		}
		return service;
		
	}
	
	protected QuestionServiceImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}
	
}
