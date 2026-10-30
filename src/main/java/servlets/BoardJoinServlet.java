package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DBPKG.userDao;
import domain.User;

@WebServlet("/boardjoin")
public class BoardJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private userDao dao = new userDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("user/boardjoin.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//중복체크 
		if(dao.idCheck(id)) {
			request.setAttribute("errorMsg", "이미 사용중인 아이디 입니다");
			request.getRequestDispatcher("/user/boardjoin.jsp").forward(request, response);
			return;
		}
		User user =new User();
		user.setId(id);
		user.setPw(pw);
		int result = dao.insertUser(user);
		if(result == 1) {
			response.sendRedirect(request.getContextPath() + "/boardlogin");
		}else {
			//여기를 항상 조심하자 (체크!) 
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다");
			request.getRequestDispatcher("/user/boardjoin.jsp").forward(request, response);
		}
		
	}

}
