package tw.yuan.tutor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Yuan13")
public class Yuan13 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String src = "C:\\Users\\User\\eclipse-workspace\\YuanWeb03\\src\\main\\webapp\\upload\\5120X3200.jpg";

		String str = request.getParameter("str");

		BufferedImage img = ImageIO.read(new File(src));
		Graphics2D g2d = img.createGraphics();

		g2d.setColor(Color.RED);
		Font font = new Font(null, Font.BOLD, 64);
//		g2d.setFont(font);

		AffineTransform tran = new AffineTransform();
		for (int i = 0; i < str.length(); i++) {
			String s = str.substring(i, i + 1);// 對每個字做尋訪
			double ang = Math.random() * 60 - 30;// 設定隨機旋轉角度
			tran.rotate(Math.toRadians(ang));// 選轉角度
			Font font2 = font.deriveFont(tran);// 參數帶進去font2
			g2d.setFont(font2);// 設置font2到g2d
			g2d.drawString(s, 100 + (i * 50), 200);// 把字印出來
			tran.rotate(Math.toRadians(ang * -1));// 角度賦歸
		}

		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();// 取得response的OutputStream
		ImageIO.write(img, "jpeg", out);// 將畫好的img輸出到out上

		FileOutputStream fout = new FileOutputStream(
				"C:\\Users\\User\\eclipse-workspace\\YuanWeb03\\src\\main\\webapp\\upload\\new.jpg");
		ImageIO.write(img, "jpeg", fout);//輸出到upload
		
		response.flushBuffer();
	}

}
