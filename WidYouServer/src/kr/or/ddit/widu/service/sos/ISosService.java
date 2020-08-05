package kr.or.ddit.widu.service.sos;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.widu.vo.report.Report_BoardVO;

public interface ISosService extends Remote{
	
	
	/**
	 * DB에 있는 모든 게시판 데이터를 불러오는 메소드
	 * @return board에 있는 모든 데이터
	 * @throws RemoteException 
	 */
	public List<Report_BoardVO> selectAllBoard() throws RemoteException;
	
	/**
	 * DB에 있는 게시판제목을 검색해서 데이터를 불러오는 메소드
	 * @param board_title
	 * @return 파라미터값을 검색한 데이터
	 * @throws RemoteException 
	 */
	public List<Report_BoardVO> selelectTitleBoard(String report_title) throws RemoteException;
	
	/**
	 * board테이블에 데이터 추가하기
	 * @param board
	 * @return 성공하면 1, 실패하면 0
	 */
	public int insertBoard(Report_BoardVO board) throws RemoteException;
	
	/**
	 * 날짜를 최근부터 내림차순으로 불러오는 메소드
	 * @return 날짜를 최근부터 내림차순으로 정렬해서 나온 데이터
	 */
	public List<Report_BoardVO> selectOderByBoard(int report_id) throws RemoteException;
	
	/**
	 * board_id을 이용한 게시물데이터 가져오기
	 * @param board_id 게시글 번호
	 * @return 파라미터랑 일치한 게시물 받아오기
	 */
	public Report_BoardVO selectBoardId(int report_id) throws RemoteException;
	
	/**
	 * board_writer를 이용한 게시물 데이터 가져오기
	 * @param board_writer
	 * @return board_writer랑 일치하는데이터를 가진 List<BoardVO>
	 */
	public List<Report_BoardVO> selectWriter(String report_com_id) throws RemoteException;

	
	public int updateBoard(Report_BoardVO board) throws RemoteException;

	public int deleteBoard(int board) throws RemoteException;
	
	
	
	
}
