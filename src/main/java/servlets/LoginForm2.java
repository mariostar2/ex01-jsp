package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginForm2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("loginid") != null) {
			response.sendRedirect("successForm.jsp");
			return;
		}
		request.getRequestDispatcher("log.jsp").forward(request, response);
	}

	//아이디가 aaaa 비밀번호가 1234라면 로그인 전용 페이지로 실패시 실패 페이지로 이동 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if ("aaaa".equals(id) && "1234".equals(pw)) {
			request.getSession().setAttribute("loginid", id);  
			response.sendRedirect("successForm.jsp");
		} else {
			request.setAttribute("error", "아이디 또는 비밀번호 오류입니다");
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}
}