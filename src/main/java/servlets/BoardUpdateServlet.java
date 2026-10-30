package servlets;

import java.io.File;
import java.io.IOException;

import DBPKG.boardNoticeDao;
import domain.Board;
import domain.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@WebServlet("/boardupdate")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private boardNoticeDao dao = new boardNoticeDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("loguser");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/boardlogin");
			return;
		}
		
		int updateno = Integer.parseInt(request.getParameter("noticeNo"));
		Board me = null;
		for(Board b : dao.BoardSelect()) {
			if(b.getNoticeNo() == updateno) {
				me =b;
				break;
			}
		}
		if(me == null || !me.getNoticeName().equals(user.getId())) {
			response.sendRedirect(request.getContextPath()+ "/boardlist");
			return;
		}
		request.setAttribute("me", me);
		request.getRequestDispatcher("/board/boardupdate.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = (User) request.getSession().getAttribute("loguser");
		if(user  ==null) {
			response.sendRedirect(request.getContextPath()+ "/boardlogin");
			return;
		}
		Board b = new Board();
		b.setNoticeTitle(request.getParameter("title"));
		b.setNoticeForm(request.getParameter("content"));
		String fileName = request.getParameter("image");
		b.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		Part file = request.getPart("file");
		if(file != null && file.getSize() > 0) {
			String upload = getServletContext().getRealPath("/uploads");
			fileName = new File(file.getSubmittedFileName()).getName();
			file.write(upload + File.separator + fileName);
		}
		b.setNoticeImage(fileName);
	
		
		
		int result = dao.updateNotice(b,user.getId());
		response.sendRedirect(request.getContextPath()+ "/boardlist");
	}

}
