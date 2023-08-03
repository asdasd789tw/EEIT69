package tw.yuan.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Yuan05")
public class Yuan05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		// 網頁傳遞的任何東西都是字串字串字串字串字串字串字串
		System.out.printf("%s : %s\n", x, y);
		int result = Integer.parseInt(x) + Integer.parseInt(y);
		// ----↑request輸入 ↓respons輸出----
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("%s + %s = %d ", x, y, result);
	}

}
