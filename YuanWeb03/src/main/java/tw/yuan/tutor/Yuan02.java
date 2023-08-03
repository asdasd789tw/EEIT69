package tw.yuan.tutor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class yuan02
 */
@WebServlet("/yuan02")
public class Yuan02 extends HttpServlet {
	private int i;

	public Yuan02() {
		System.out.println("yuan02()");
	}//只有一開始會被建構一次，之後F5不會再次建構

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: yuan02").append(request.getContextPath());
		System.out.println("Hello, World" + i++);// 每次F5都會執行一次doGet
	}
}
