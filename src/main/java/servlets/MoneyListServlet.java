package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import DBPKG.MoneyDao;
import domain.Member;


@WebServlet("/moneylist")
public class MoneyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MoneyDao dao  =new MoneyDao();
		List<Member>list = dao.moneyList(); 
		System.out.println("매출 목록 개수: " + list.size());
		request.setAttribute("list", list);
		request.getRequestDispatcher("money.jsp").forward(request, response);
		
	}

}
