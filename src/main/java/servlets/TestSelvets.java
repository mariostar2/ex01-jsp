package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/*
 *서버가 응답하면 doget() 
 *서버가 죽으면 destroy
 */
@WebServlet("/TestSelvets")
public class TestSelvets extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public TestSelvets() {
        super();
        System.out.println("create.............................");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init.............................");
	}

	public void destroy() {
		System.out.println("destroy.............................");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doget.............................");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<");
		
	}

}
