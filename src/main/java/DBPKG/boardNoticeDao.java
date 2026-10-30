package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Board;

public class boardNoticeDao {
	
	private static final String  url = "jdbc:oracle:thin:@localhost:1521:testdb";
	private static final String  id = "green";
	private static final String pass = "1234";
	
	
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(url, id, pass);
	}  
	
	//번호 게시글 작성시 번호 자동증가 
	public int AutoNumberBoard() {
		int autono = 0;
		String sql  ="SELECT NVL(MAX(board_no),0)+1 FROM BOARD_NOTICE";
		try {
			Connection 	con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				autono = rs.getInt(1);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return autono;
		
	}
	
	//게시글 작성 추가
	public int insertBoard(Board board) {
		int result = 0;
		String sql = "INSERT INTO board_notice (board_no, user_id,title,content,image_path) "
				+ "values(?, ?, ? ,? ,?)";
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,AutoNumberBoard());
			pstmt.setString(2, board.getNoticeName());	
			pstmt.setString(3, board.getNoticeTitle());
			pstmt.setString(4, board.getNoticeForm());
			pstmt.setString(5, board.getNoticeImage());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//조회
	public List<Board>BoardSelect (){
		ArrayList<Board>list = new ArrayList<>();
		String sql = "SELECT BOARD_NO, USER_ID, TITLE, CONTENT, IMAGE_PATH, "
					+ "TO_CHAR(CREATED_AT, 'YYYY-MM-DD HH24:MI') AS CREATED_AT, "
					+ "TO_CHAR(UPDATED_AT, 'YYYY-MM-DD HH24:MI') AS UPDATED_AT "
					+ "FROM BOARD_NOTICE ORDER BY BOARD_NO ASC";
		try {
			Connection con =  getConnection();
			PreparedStatement pstmt =  con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board bo = new Board();
				bo.setNoticeNo(rs.getInt("board_no"));
				bo.setNoticeName(rs.getString("user_id"));
				bo.setNoticeTitle(rs.getString("title"));
				bo.setNoticeForm(rs.getString("content"));
				bo.setNoticeImage(rs.getString("image_path"));  
				bo.setNoticeDate(rs.getString("created_at"));
				bo.setNoticeUpdate(rs.getString("updated_at"));
				list.add(bo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//상세조회
	public Board checked(int noticeNo){
		String sql = "SELECT BOARD_NO, USER_ID, TITLE, CONTENT, IMAGE_PATH," +
				     "TO_CHAR(CREATED_AT, 'YYYY-MM-DD HH24:MI') AS CREATED_AT, " +
				     "TO_CHAR(UPDATED_AT, 'YYYY-MM-DD HH24:MI') AS UPDATED_AT " +
					 "FROM BOARD_NOTICE WHERE BOARD_NO = ?";
		Board bo = new Board();
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bo.setNoticeNo(rs.getInt("board_no"));
				bo.setNoticeName(rs.getString("user_id"));
				bo.setNoticeTitle(rs.getString("title"));
				bo.setNoticeForm(rs.getString("content"));
				bo.setNoticeImage(rs.getString("image_path"));
				bo.setNoticeDate(rs.getString("created_at"));
				bo.setNoticeUpdate(rs.getString("updated_at"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}
	//수정 
	public int updateNotice(Board bo ,String loginId) {
		int update =0;
		String sql = "UPDATE BOARD_NOTICE SET TITLE = ?, CONTENT = ?, IMAGE_PATH = ?, UPDATED_AT = SYSDATE " +
				"WHERE BOARD_NO = ? AND USER_ID = ?";

		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bo.getNoticeTitle());
			pstmt.setString(2, bo.getNoticeForm());
			pstmt.setString(3, bo.getNoticeImage());
			pstmt.setInt(4, bo.getNoticeNo());
			pstmt.setString(5,loginId);
			update = pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return update;
	}
	
	//삭제
	public int deleteBoard(int noticeNo, String loginId) {
		int result =0;
		String sql  ="DELETE FROM BOARD_NOTICE WHERE BOARD_NO = ? AND USER_ID =?";
		try {
			Connection con  =getConnection();
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setInt(1,noticeNo );
			pstmt.setString(2, loginId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
