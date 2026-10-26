package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/test")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿에는 page 영역이 없다.
		request.setAttribute("x", "request-x");
		HttpSession session =request.getSession();
		session.setAttribute("x", "session-x");
		String x = (String) session.getAttribute("x");
		
		ServletContext application = request.getServletContext();
		application.setAttribute("x", "application-x"); 
		String x2 =(String) application.getAttribute("x");
		
		//response.sendRedirect("test.jsp");
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}

}
