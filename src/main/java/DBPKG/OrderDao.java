package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Menber;
import domain.Order;
import domain.Product;


public class OrderDao {

	private static final String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	private static final String user = "green";
	private static final String pass = "1234";

	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(url, user, pass);
	}
	
	// 주문 등록
	public int insertMenu(Order or) {
		int result = 0;
		String sql = "INSERT INTO TBL_ORDER_202101(ORDERNO, SHOPNO, ORDERDATE, PCODE, AMOUNT) "
				+ "VALUES(?, ?, ?, ?, ?)";

		try (Connection con = getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, or.getOrderno());
			pstmt.setString(2, or.getShopno());
			pstmt.setString(3, or.getOrderdate());
			pstmt.setString(4, or.getPcode());
			pstmt.setInt(5, or.getAmount());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 주문 목록 조회
	public List<Order> selectOrderList() {
		List<Order> list = new ArrayList<>();
		String sql = "SELECT O.SHOPNO, S.SHOPNAME, O.ORDERNO, O.ORDERDATE, " 
		        + "O.PCODE, P.PNAME, O.AMOUNT, P.COST, "
				+ "P.COST * O.AMOUNT AS COST_PRICE, "
				+ "P.COST * O.AMOUNT * (100 - S.DISCOUNT) / 100 AS DISCOUNT_PRICE " 
				+ "FROM TBL_ORDER_202101 O "
				+ "JOIN TBL_SHOP_202101 S ON O.SHOPNO = S.SHOPNO " 
				+ "JOIN TBL_PRODUCT_202101 P ON O.PCODE = P.PCODE "
				+ "ORDER BY O.ORDERNO";
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Order or = new Order();
				or.setShopno(rs.getString("SHOPNO"));
				or.setShopname(rs.getString("SHOPNAME").trim());
				or.setOrderno(rs.getString("ORDERNO"));
				or.setOrderdate(rs.getString("ORDERDATE"));
				or.setPcode(rs.getString("PCODE"));
				or.setPname(rs.getString("PNAME"));
				or.setAmount(rs.getInt("AMOUNT"));
				or.setCost(rs.getInt("COST"));
				or.setCostPrice(rs.getInt("COST_PRICE"));
				or.setDiscountPrice(rs.getInt("DISCOUNT_PRICE"));
				list.add(or);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 점포별 주문 현황
	public List<Product> proList() {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT S.SHOPNO, P.PCODE, P.PNAME, "
				+ "SUM(O.AMOUNT) AS TOTAL_COUNT "
				+ "FROM TBL_ORDER_202101 O " 
				+ "JOIN TBL_SHOP_202101 S ON O.SHOPNO = S.SHOPNO "
				+ "JOIN TBL_PRODUCT_202101 P ON O.PCODE = P.PCODE "
				+ "GROUP BY S.SHOPNO, P.PCODE, P.PNAME "
				+ "ORDER BY S.SHOPNO, P.PCODE";
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				pr.setShopno(rs.getString("SHOPNO"));
				pr.setPcode(rs.getString("PCODE"));
				pr.setPname(rs.getString("PNAME"));
				pr.setTotalcount(rs.getInt("TOTAL_COUNT"));
				list.add(pr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}	

	// 제품 코드 조회
	public List<Product> prList() {
		List<Product> list = new ArrayList<>();
				String sql = "SELECT P.PCODE, P.PNAME, P.COST, "
			               + "ROUND(P.COST * (100 - MAX(S.DISCOUNT)) / 100, 0) AS DISCOUNT_PRICEA, "
			               + "ROUND(P.COST * (95 - MAX(S.DISCOUNT)) / 100, 0) AS DISCOUNT_PRICEB "
			               + "FROM TBL_ORDER_202101 O "
			               + "JOIN TBL_SHOP_202101 S ON O.SHOPNO = S.SHOPNO "
			               + "JOIN TBL_PRODUCT_202101 P ON O.PCODE = P.PCODE "
			               + "GROUP BY P.PCODE, P.PNAME,P.COST "
			               + "ORDER BY P.PCODE";
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product pr = new Product();
				pr.setPcode(rs.getString("PCODE"));
				pr.setPname(rs.getString("PNAME"));
				pr.setCost(rs.getString("COST"));
				pr.setDiscountPrice(rs.getInt("DISCOUNT_PRICEA"));
				pr.setDispriced(rs.getInt("DISCOUNT_PRICEB"));
				list.add(pr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	// 로그인 추가
	public Menber login(String id, String pw) {
		String sql = "SELECT ID "
				   + "FROM TBL_MEMBER_202101 "
				   + "WHERE ID = ? "
				   + "AND PW = ?";

		try (Connection con = getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Menber m = new Menber();
					m.setId(rs.getString("ID"));
					return m;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}