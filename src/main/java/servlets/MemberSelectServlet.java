package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DBPKG.MemberDto;
import domain.Member;


@WebServlet("/memberselect")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDto dto = new MemberDto();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = dto.selectMember();
		request.setAttribute("list", list);
		request.getRequestDispatcher("SelectMember.jsp").forward(request, response);
		
		
	}

}
