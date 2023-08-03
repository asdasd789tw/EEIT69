package tw.yuan.tutor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Yuan12")
public class Yuan12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int w = 400, h = 20;
		double rate = Double.parseDouble(request.getParameter("rate"));
		//由前端給rate值供後續作圖
		
		response.setContentType("image/jpeg");// 輸出類型

		BufferedImage img = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);// 設置畫布
		Graphics2D g2d = img.createGraphics();// 用Graphic2D畫圖

		g2d.setColor(Color.YELLOW);// 畫圖
		g2d.fillRect(0, 0, w, h);// 畫圖
		g2d.setColor(Color.RED);// 畫圖
		g2d.fillRect(0, 0, (int) (w * rate / 100), h);// 畫圖

		ServletOutputStream out = response.getOutputStream();// 取得response的OutputStream
		ImageIO.write(img, "jpeg", out);// 將畫好的img輸出到out上

		response.flushBuffer();

	}
}
