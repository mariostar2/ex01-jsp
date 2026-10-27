package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Member;
import domain.Money;

public class MoneyDao {
	
	private static final String url= "jdbc:oracle:thin:@localhost:1521:testdb";
	private static final String user = "green";
	private static final String pass = "1234";

	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(url, user, pass);
	}  
	
	
	
	public List<Member>moneyList(){
		List<Member>memberlist = new ArrayList<Member>();
		String sql = "SELECT e1.custno, e1.custname, e1.grade, SUM(e2.price) AS total_price " +
	             "FROM member_tbl_02 e1, money_tbl_02 e2 " +
	             "WHERE e1.custno = e2.custno " +
	             "GROUP BY e1.custno, e1.custname, e1.grade " +
	             "ORDER BY total_price DESC";
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
			    Member member = new Member();
	            member.setCustno(rs.getInt("custno"));
	            member.setCustname(rs.getString("custname"));
	            member.setGrade(rs.getString("grade"));
	            member.setPrice(rs.getInt("total_price")); 
	            memberlist.add(member);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return memberlist;
		

	}
	
}
