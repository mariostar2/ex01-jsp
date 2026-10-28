package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DBPKG.OrderDao;
import domain.Menber;


@WebServlet("/memulogin")
public class OrderFormLoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("loginForm3").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		Menber n = new OrderDao().login(id, pw);   // DB에서 확인

		if (n != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", n);
			response.sendRedirect("index4.jsp");
		} else {
			request.setAttribute("msg", "아이디 혹은 비밀번호 오류");
			request.getRequestDispatcher("loginForm3.jsp").forward(request, response);
		}
	}

}
