package kr.or.ddit.widu.dao.question;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.widu.util.SqlMapClientFactory;

public class QuestionDaoImpl implements IQuestionDao{

	private static IQuestionDao dao;
	private SqlMapClient client;
	
	public static IQuestionDao getInstance() {
		
		if(dao == null) {
			dao = new QuestionDaoImpl();
		}
		return dao;
	}
	
	private QuestionDaoImpl() {
		
		client = SqlMapClientFactory.getInstance();
	}
	
}
