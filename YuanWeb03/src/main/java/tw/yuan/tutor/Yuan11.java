package tw.yuan.tutor;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Yuan11")
public class Yuan11 extends HttpServlet {

	public Yuan11() {
		System.out.println("Yuan11()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doget()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost()");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service(1)");
		System.out.println(req.getMethod());
		if (req.getMethod().equals("GET")) {

		} else if (req.getMethod().equals("POST")) {

		}
		super.service(req, resp);// 由這邊判斷該呼叫doget()或dopost()
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service(2)");
		super.service(req, res);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		super.init();
		// 只執行一次，在建構式及init(ServletConfig config)之後
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig config)");
//		super.init(config);
		// 只執行一次，在建構式之後，之後呼叫init()
	}

}
