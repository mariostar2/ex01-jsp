package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DBPKG.boardNoticeDao;
import domain.Board;


@WebServlet("/boardchecked")
public class BoardCheckedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private boardNoticeDao dao = new boardNoticeDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loguser") == null) {
			response.sendRedirect(request.getContextPath() + "/boardlogin");
			return;
		}
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		//목록을 가져오는데 그 번호에 하나의 글씩
		Board board =  dao.checked(noticeNo);
		if(board == null) {
			response.sendRedirect(request.getContextPath() + "/boardlist");
			return;
		}	
		//상세 화면단으로 가자!
		request.setAttribute("board", board);
		request.getRequestDispatcher("board/boarddetail.jsp").forward(request, response);
	}
	
}
