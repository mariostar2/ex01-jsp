package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet.............");
		response.setContentType("test/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//getparameter 앞에 jsp에 네임 속성이 들어가야함
		String data = request.getParameter("txt");
		System.out.println("파라미터 이름:" + data);
		out.print(data +"안녕?");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("doPost.............");
	}

}
