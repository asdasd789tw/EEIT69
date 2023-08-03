package tw.yuan.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.yuan.apis.Bike;


@WebServlet("/Yuan14")
public class Yuan14 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dis = request.getRequestDispatcher("Yuan15");
		
		Bike b1 = new Bike("Yuan");
		request.setAttribute("b1", b1);
		//設置"b1"名稱給request，指向到b1物件
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.printf("<h1>Yuan Company</h1>");
		out.printf("<hr>");
		dis.include(request, response);
		//Yuan14的request、response會丟給Yuan15做使用
		out.printf("<hr>");
		out.printf("Copyleft...");
	}

}
