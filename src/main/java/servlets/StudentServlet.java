package servlets;

import java.io.IOException;
import java.util.ArrayList;

import dao.StudentDao;
import domain.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao dao = new StudentDao();
    	
    	ArrayList<Student> students = dao.getStudents();         
        request.setAttribute("students", students);              
        request.getRequestDispatcher("select.jsp").forward(request, response);
    }
}