package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/FormServlet2")
public class FormServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String gender =request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		
		PrintWriter no = response.getWriter();
		no.print(name);
		no.print(gender);
		
		for(int i=0; i<hobbies.length; i++) {
			no.print(hobbies[i]+ ":");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
