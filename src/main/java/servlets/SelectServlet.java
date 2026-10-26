package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//jdbc 연결 ---- >Dao 에게 위탁 	
		//저코드를 만나면 서버는 클라이언트한태 응답으로 문자열 형태로된 p2.jsp라는거에 보내준다
		//그럼 p2.jsp로 다시 요청 
		/*
		 *    p2.jsp
		 서버<ㅡㅡㅡㅡㅡㅡㅡㅡ>클라이언트
		 */
		response.sendRedirect("Index2.jsp");
	}		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
