package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.User;

public class userDao {

	private static final String url  = "jdbc:oracle:thin:@localhost:1521:testdb";
	private static final String id   = "green";
	private static final String pass = "1234";

	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(url, id, pass);
	}

	//유저 로그인 (성공하면 User, 실패하면 null)
	public User login(String id, String pw) {
		User user = null;
		String sql = "SELECT USER_ID, ROLE FROM board_user " +
				"WHERE USER_ID = ? AND USER_PW = ?";

		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					user = new User();
					user.setId(rs.getString("USER_ID"));
					user.setRole(rs.getInt("ROLE"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//유저 회원가입 성공시 1
	public int insertUser(User user) {
		int result = 0;
		String sql = "INSERT INTO board_user (USER_ID, USER_PW, ROLE) " +
				"VALUES (?, ?, 1)";

		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//아이디 중복 확인
	public boolean idCheck(String id) {
		boolean exists = false;
		String sql = "SELECT COUNT(*) FROM board_user WHERE USER_ID = ?";

		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, id);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					exists = rs.getInt(1) > 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;
	}
}