package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DBPKG.MemberDto;
import domain.Member;


@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private MemberDto dao =  new MemberDto();
     //화면에 보일단
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("custno", dao.autoNumber());
		request.getRequestDispatcher("CreateMember.jsp").forward(request, response);
	}

	//화면에는 안보임
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Member me = new Member();
		me.setCustno(Integer.parseInt(request.getParameter("custno")));
		me.setCustname(request.getParameter("custname"));
	    me.setPhone(request.getParameter("phone"));
	    me.setAddress(request.getParameter("address"));
	    me.setJoindate(request.getParameter("joindate"));
	    me.setGrade(request.getParameter("grade"));
	    me.setCity(request.getParameter("city"));
	
		dao.insertMember(me);
		//등록후 이동할 경로는 index
		response.sendRedirect("index3.jsp");
	}

}
