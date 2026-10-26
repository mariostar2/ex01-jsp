package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();

    	try {
    		int num1 = Integer.parseInt(request.getParameter("num1"));
    		int num2 = Integer.parseInt(request.getParameter("num2"));
    		int result = num1 + num2;
    		out.print(num1 + " + " + num2 + " = " + result);
    	} catch (NumberFormatException e) {
    		out.print("숫자를 입력하세요");
    	}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String result;
		try {
			double n1 = Double.parseDouble(request.getParameter("num1"));
			double n2 = Double.parseDouble(request.getParameter("num2"));
			String op = request.getParameter("op");

			switch (op) {
				case "+": result = String.valueOf(n1 + n2); break;
				case "-": result = String.valueOf(n1 - n2); break;
				case "*": result = String.valueOf(n1 * n2); break;
				case "/":
					if (n2 == 0) result = "0으로 나눌 수 없습니다";
					else         result = String.valueOf(n1 / n2);
					break;
				default: result = "잘못된 연산자";
			}
		} catch (NumberFormatException e) {
			result = "숫자를 입력하세요";
		}

		PrintWriter out = response.getWriter();
		out.println("<h1>계산 결과</h1>");
		out.println("<h2>" + result + "</h2>");
		out.println("<a href='" + request.getContextPath() + "/post.jsp'>다시 계산</a>");
	}
}