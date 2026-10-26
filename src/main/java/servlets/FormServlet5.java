package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.XDao;
import domain.Student;


@WebServlet("/student/list")
public class FormServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		XDao xDao = new XDao();
		List<Student>list = xDao.f();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jspForm.jsp").forward(request, response);
		
	}

}
