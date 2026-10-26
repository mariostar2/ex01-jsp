package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Student;

public class StudentDao {
	public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";

        /* JDBC 연동 */
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return students;   
        }

        
        try (Connection conn = DriverManager.getConnection(
                 "jdbc:oracle:thin:@localhost:1521:testdb", 
                 "green",
                 "1234"
                 );
             PreparedStatement stmt = conn.prepareStatement(query);   
             ResultSet rs = stmt.executeQuery()) {                     

            // 결과 처리
            while (rs.next()) {
                Student stu = new Student();   // 반복마다 새 객체
                stu.setStu_no(rs.getInt("stu_no"));
                stu.setStu_name(rs.getString("stu_name"));
                stu.setStu_dept(rs.getString("stu_dept"));
                stu.setStu_grade(rs.getInt("stu_grade"));
                stu.setStu_class(rs.getString("stu_class").charAt(0));
                stu.setGender(rs.getString("stu_gender").charAt(0));
                stu.setStu_height(rs.getInt("stu_height"));
                stu.setStu_weight(rs.getInt("stu_weight"));
                students.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
