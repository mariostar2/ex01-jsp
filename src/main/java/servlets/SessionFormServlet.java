package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/member")
public class SessionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loginid") == null) {
			response.sendRedirect("login");
			return;
		}
		request.getRequestDispatcher("successForm.jsp").forward(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		String loginid =  (String) session.getAttribute("loginid");
		//로그인하는데 아이디가 비어있다면
		if(loginid == null) {
			response.sendRedirect("login");
			return;
		}
		//로그인 성공시 성공하는 페이지로
		request.getRequestDispatcher("successForm.jsp").forward(request, response);
	}

}
