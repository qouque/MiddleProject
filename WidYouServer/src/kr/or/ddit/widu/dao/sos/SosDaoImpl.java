package kr.or.ddit.widu.dao.sos;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.widu.dao.board.BoardDaoImpl;
import kr.or.ddit.widu.dao.board.IBoardDao;
import kr.or.ddit.widu.util.SqlMapClientFactory;
import kr.or.ddit.widu.vo.report.Report_BoardVO;

public class SosDaoImpl implements ISosDao{

	private static ISosDao dao;
	private SqlMapClient client;
	
	public static ISosDao getInstance() {
		
		if(dao==null) {
			
			dao = new SosDaoImpl();
			
		}
		return dao;
		
	}
		
	private void IBoardDao() {
		Reader rd;
		try {
			Charset charset = Charset.forName("UTF-8"); // 설정파일의 인코딩 설정
			
			Resources.setCharset(charset);
			rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
			client = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // Reader객체 닫기
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}

	@Override
	public List<Report_BoardVO> selectAllBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report_BoardVO> selelectTitleBoard(String report_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(Report_BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Report_BoardVO> selectOderByBoard(int report_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report_BoardVO selectBoardId(int report_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report_BoardVO> selectWriter(String report_com_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoard(Report_BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int board) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
