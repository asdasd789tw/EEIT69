package tw.yuan.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Yuan07
 */
@WebServlet("/Yuan07")
public class Yuan07 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String r, x, y, op;
		x = y = r = op = "";
		if (request.getParameter("x") != null) {
			x = request.getParameter("x");
			y = request.getParameter("y");
			op = request.getParameter("op");
			// 網頁傳遞的任何東西都是字串字串字串字串字串字串字串
			System.out.printf("%s : %s\n", x, y);
//			if (Integer.parseInt(request.getParameter("op")) == 1) {
//				int result = Integer.parseInt(x) + Integer.parseInt(y);
//				r = result + "";// +
//			} else if (Integer.parseInt(request.getParameter("op")) == 2) {
//				int result = Integer.parseInt(x) - Integer.parseInt(y);
//				r = result + "";// -
//			} else if (Integer.parseInt(request.getParameter("op")) == 3) {
//				int result = Integer.parseInt(x) * Integer.parseInt(y);
//				r = result + "";// *
//			} else if (Integer.parseInt(request.getParameter("op")) == 4) {
//				int result = Integer.parseInt(x) / Integer.parseInt(y);
//				r = result + "";// /
//			}
			int result, mod;
			switch (op) {
			case "1":
				result = Integer.parseInt(x) + Integer.parseInt(y);
				r = result + "";
				break;// +
			case "2":
				result = Integer.parseInt(x) - Integer.parseInt(y);
				r = result + "";
				break;// -
			case "3":
				result = Integer.parseInt(x) * Integer.parseInt(y);
				r = result + "";
				break;// *
			case "4":
				result = Integer.parseInt(x) / Integer.parseInt(y);
				mod = Integer.parseInt(x) % Integer.parseInt(y);
				r = result + "......" + mod;
				break;// /
			}
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<form>");
		out.printf("<input name = 'x' value='%s'>\n", x);

		out.println("<select name='op'>");
		out.printf("<option value='1'%s>+</option>\n", (op.equals("1") ? "selected" : ""));
		out.printf("<option value='2'%s>-</option>\n", (op.equals("2") ? "selected" : ""));
		out.printf("<option value='3'%s>*</option>\n", (op.equals("3") ? "selected" : ""));
		out.printf("<option value='4'%s>/</option>\n", (op.equals("4") ? "selected" : ""));
		out.println("</select>");

		out.printf("<input name = 'y' value='%s'>\n", y);
		out.println("<input type=\"submit\" value=\"=\">");
		out.println(r);
		out.println("</form>");
	}
}
