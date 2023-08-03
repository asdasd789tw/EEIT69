package tw.yuan.tutor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.yuan.apis.Yuan19M;

@WebServlet("/Yuan18C")
public class Yuan18C extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Controller 面對客戶端做的事情

		request.setCharacterEncoding("UTF-8");

		// 1. 接收參數
		String x = request.getParameter("x");
		String y = request.getParameter("y");

		
		// 2. 演算法
		if (x != null && y != null) {
			try {
				Yuan19M model = new Yuan19M(x, y);
				int result = model.plus();

				request.setAttribute("x", x);// 其實request原本就有，示範用
				request.setAttribute("y", y);// 其實request原本就有，示範用
				request.setAttribute("result", result+"");
				request.setAttribute("view", "view2");
				
				// 3. 呈現 View 給客戶端
				RequestDispatcher dispatcher = request.getRequestDispatcher("Yuan20V");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				System.out.println(e);
			}
		}else {
			request.setAttribute("x", "");// 其實request原本就有，示範用
			request.setAttribute("y", "");// 其實request原本就有，示範用
			request.setAttribute("result", "");
			request.setAttribute("view","view1");

			// 3. 呈現 View 給客戶端
			RequestDispatcher dispatcher = request.getRequestDispatcher("Yuan20V");
			dispatcher.forward(request, response);
		}






	}

}
