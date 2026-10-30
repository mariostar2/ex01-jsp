package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DBPKG.boardNoticeDao;
import domain.Board;


@WebServlet("/boardlist")
public class Boardlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  boardNoticeDao dao =  new boardNoticeDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("loguser") == null) {
			response.sendRedirect(request.getContextPath() + "/boardlogin");
			return;
		}
		
		List<Board> list = dao.BoardSelect();
		request.setAttribute("boardlist", list);
		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}



}
