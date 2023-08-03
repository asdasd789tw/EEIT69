package tw.yuan.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.yuan.apis.YuanUtils;

/**
 * Servlet implementation class Yuan20V
 */
@WebServlet("/Yuan20V")
public class Yuan20V extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String x = (String) request.getAttribute("x");
		String y = (String) request.getAttribute("y");
		String result = (String) request.getAttribute("result");
		String view = (String)request.getAttribute("view");

		// Load views/view1.html => String
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String content = YuanUtils.loadView(view);
			out.printf(content, x, y, result);//由這邊印出網頁
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
