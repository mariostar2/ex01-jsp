package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cookie/notice")
public class CookieNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hide =3;
		Cookie cookie = new Cookie("hideNotice","Y");
		cookie.setMaxAge(3);
		cookie.setPath("/");
		response.setContentType("text/plain; charset=UTF-8");
		
	}

}
