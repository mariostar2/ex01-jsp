package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

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

@WebServlet("/boardwrite")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boardNoticeDao dao = new boardNoticeDao(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 내부이관
		request.getRequestDispatcher("/board/boardwrite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//유저 세션단 데이터 가져와야함
		User user = (User) request.getSession().getAttribute("loguser");
		if(user == null) {
			//로그인 서블릿을 거처서 로그인화면으로 이동
			response.sendRedirect(request.getContextPath() + "/boardlogin");
			return;
		}
		//글자값 받아야 작성이 가능하니까~
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//업로드 준비!
		String upload = getServletContext().getRealPath("/uploads");
		
		File uploadDir = new File(upload);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		String fileName =null;
		Collection<Part> parts = request.getParts();
		for(Part part:  parts) {
			if(part.getSize() == 0 || part.getSubmittedFileName() == null) continue;
			fileName = new File(part.getSubmittedFileName()).getName();
			part.write(upload + File.separator + fileName);
		}
		
		Board board =new Board();
		board.setNoticeName(user.getId());
		board.setNoticeTitle(title);
		board.setNoticeForm(content);
		board.setNoticeImage(fileName);
		
		int result = dao.insertBoard(board);
		if(result ==1) {
			response.sendRedirect(request.getContextPath() + "/boardlist");
		}else {
			request.getRequestDispatcher("/board/boardwrite.jsp").forward(request, response);
		}
	}
}
