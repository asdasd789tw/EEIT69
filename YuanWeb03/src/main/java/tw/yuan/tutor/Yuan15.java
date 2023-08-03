package tw.yuan.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.yuan.apis.Bike;

@WebServlet("/Yuan15")
public class Yuan15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int max = 0;
		try {
			max = Integer.parseInt(request.getParameter("max"));
		} catch (Exception e) {
			System.out.println(e);
		}

		PrintWriter out = response.getWriter();
		out.println((int) (Math.random() * max + 1));
		out.println("<hr>");
		Object obj = request.getAttribute("b1");
		Bike b1 = (Bike)obj;
			
		out.println(b1);
	}

}
