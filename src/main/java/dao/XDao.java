package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Student;

public class XDao  {
	//db 담당용 
	public List<Student> f() {
		List<Student>list =  new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:testdb",
							"green",
							"1234"
							);
		Statement stmt =  conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		
		while(rs.next()) {
			Student std = new Student();
			std.setStu_no(rs.getInt("STU_NO"));
			std.setStu_name(rs.getString("STU_NAME"));
			std.setStu_dept(rs.getString("STU_DEPT"));
			std.setGender(rs.getString("STU_GENDER").charAt(0));
			std.setStu_height(rs.getInt("STU_HEIGHT"));
			std.setStu_weight(rs.getInt("STU_WEIGHT"));
			list.add(std);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}	
}
