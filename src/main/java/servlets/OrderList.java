package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DBPKG.OrderDao;

@WebServlet("/orderselect")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao dao = new OrderDao();
		
		request.setAttribute("list", dao.selectOrderList());
		request.getRequestDispatcher("selectMenu.jsp").forward(request, response);
	}

	
	

}
