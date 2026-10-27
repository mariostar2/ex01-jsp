package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Member;

public class MemberDto {
	
	private static final String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	private static final String user = "green";
	private static final String pass = "1234";

	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(url, user, pass);
		
	}
	
	//번호자동생성
	public int autoNumber() {
		int custno = 0;
		String sql = "SELECT NVL(MAX(custno), 100000) + 1 FROM member_tbl_02";
		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) custno =  rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return custno;
	}
	
			
	//맴버 등록
	public int insertMember(Member me) {
		int result =0;
		String sql =  "insert into member_tbl_02(custno,custname,phone,address,joindate,grade,city)"
				+ "values (?, ?, ?, ?, to_date(?, 'yyyy-mm-dd'), ?, ?)";
		try {
			Connection	con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, me.getCustno());
			pstmt.setString(2,me.getCustname());
			pstmt.setString(3,me.getPhone());
			pstmt.setString(4, me.getAddress());
			pstmt.setString(5, me.getJoindate());
			pstmt.setString(6, me.getGrade());
			pstmt.setString(7, me.getCity());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//맴버 조회
	public List<Member> selectMember() {
	    List<Member> list = new ArrayList<>();
	    String sql = "SELECT custno, custname, phone, address, "
	               + "TO_CHAR(joindate, 'YYYY-MM-DD') AS joindate, grade, city "
	               + "FROM member_tbl_02 ORDER BY custno";
	    try (Connection con = getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            Member m = new Member();
	            m.setCustno(rs.getInt("custno"));
	            m.setCustname(rs.getString("custname"));
	            m.setPhone(rs.getString("phone"));
	            m.setAddress(rs.getString("address"));
	            m.setJoindate(rs.getString("joindate"));
	            m.setGrade(rs.getString("grade"));
	            m.setCity(rs.getString("city"));
	            list.add(m);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;   
	}	
	
	//맴버 수정
	public int updateMember(Member me) {
		String sql = "Update member_tbl_02 SET custname = ? , phone =? , address =? ," + "joindate = TO_DATE(? ,'YYYY-MM-DD'), grade =?, city =?" + "where custno = ?";
		int update =0;
		try {
			Connection	con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, me.getCustname());
			pstmt.setString(2,me.getPhone());
			pstmt.setString(3,me.getAddress());
			pstmt.setString(4, me.getJoindate());
			pstmt.setString(5, me.getGrade());
			pstmt.setString(6, me.getCity());
			pstmt.setInt(7, me.getCustno());
			update = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return update;
	}
	
	
}
