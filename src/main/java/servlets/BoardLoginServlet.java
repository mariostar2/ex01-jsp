package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DBPKG.userDao;
import domain.User;

@WebServlet("/boardlogin")
public class BoardLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private userDao dao = new userDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/user/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		User user = dao.login(id, pw);

		if (user == null) {
			request.setAttribute("errorMsg", "아이디와 비밀번호 체크 부탁드립니다");
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("loguser", user);
		response.sendRedirect(request.getContextPath() + "/boardlist");
	
	
	}
	
}
