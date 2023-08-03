package tw.yuan.tutor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Yuan08")
public class Yuan08 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// 輸入的東西轉換編碼UTF-8
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");

		System.out.println(account + ":" + passwd + ":" + gender);
		if (hobbies != null) {
			for (String hobby : hobbies) {
				System.out.println(hobby);
			}
		}

		response.setContentType("text/html; charset=UTF-8");// 輸出的東西轉換編碼UTF-8
	}// 透過URL傳遞，有隱密資料不建議用get傳遞

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("doPost()");
	}// 透過body傳遞，有隱密資料建議用post傳遞

}
