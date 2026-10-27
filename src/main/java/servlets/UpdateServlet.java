package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DBPKG.MemberDto;
import domain.Member;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberDto dao =  new MemberDto();

    //화면 보이기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custno =  Integer.parseInt(request.getParameter("custno"));
		for(Member m : dao.selectMember()) {
			if(m.getCustno()== custno) {
				request.setAttribute("me", m);
				break;
			}
		}
		request.getRequestDispatcher("UpdateMember.jsp").forward(request, response);;
		
	}

	//회원정보의 기능만 서블릿단에서 ---> jsp(저장)
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
		dao.updateMember(me);
		
		//수정후 보일 경로는 webservlet로 경로 정해둔 select로 매핑
		response.sendRedirect("memberselect");
		
	}

}
