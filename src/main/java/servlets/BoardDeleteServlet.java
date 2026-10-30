package servlets;

import java.io.IOException;

import DBPKG.boardNoticeDao;
import domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/boarddelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private boardNoticeDao dao = new boardNoticeDao();



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("loguser");
		if(user  == null) {
			response.sendRedirect(request.getContextPath() + "/boardlogin");
			return;
		}
		
	int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
	int result = dao.deleteBoard(noticeNo, user.getId());
	response.sendRedirect(request.getContextPath() + "/boardlist");
		
	}

	

}
