package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/cookie/cookieLogin")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("logout".equals(request.getParameter("action"))) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect("logincookie.jsp");
			return;
		}

	
		HttpSession session = request.getSession(false);
		String logid = null;
		if (session != null) {
			logid = (String) session.getAttribute("id");
		}
		if (logid == null) {
			response.sendRedirect("logincookie.jsp");
			return;
		}

		boolean hideNotice = false;
		int result = 0;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("hideNotice") && c.getValue().equals("Y")) {
					hideNotice = true;
				}
				if (c.getName().equals("result")) {
					result = Integer.parseInt(c.getValue());
				}
			}
		}
	
		result++;
		Cookie countCookie = new Cookie("result", String.valueOf(result));
		countCookie.setMaxAge(60 * 60 * 24);
		response.addCookie(countCookie);

		request.setAttribute("logid", logid);
		request.setAttribute("result", result);
		request.setAttribute("hideNotice", hideNotice);
		request.getRequestDispatcher("/cookie/cookieMain.jsp").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if ("admin".equals(id) && "1234".equals(pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			response.getWriter().print("success");
		} else {
			response.getWriter().print("fail");
		}
	}

}
