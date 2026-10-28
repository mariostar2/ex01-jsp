package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DBPKG.OrderDao;
import domain.Order;

@WebServlet("/insert")
public class OrderCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDao dao = new OrderDao();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("createMenu.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Order or = new Order();
		or.setOrderno(request.getParameter("orderno"));
		or.setShopno(request.getParameter("shopno"));
		or.setOrderdate(request.getParameter("orderdate").replace("-", ""));
		or.setPcode(request.getParameter("pcode"));
		or.setAmount(Integer.parseInt(request.getParameter("amount")));
		dao.insertMenu(or);

		// 전송경로
		response.sendRedirect("index4.jsp");
	}
}