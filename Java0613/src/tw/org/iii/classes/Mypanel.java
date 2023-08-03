package tw.org.iii.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Mypanel extends JPanel {
	private BufferedImage ball0;
	private int ballW, ballH;

	private HashSet<BallTask> balls;
	private Timer timer;
	private int viewW, viewH;


	public Mypanel() {
//		setBackground(Color.GREEN);

		balls = new HashSet<BallTask>();
		timer = new Timer();
		try {
			ball0 = ImageIO.read(new File("dir1/dvd.png"));
			ballW = ball0.getWidth();
			ballH = ball0.getHeight();
			// 用BufferedImage接讀取到的圖片
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				createBall(e.getX(), e.getY());
			}
		});

		timer.schedule(new refreshTask(), 0, (1000 / 60));
		// 利用schedule重複執行實現FPS刷新率

	}

	private void createBall(int x, int y) {
		BallTask ball = new BallTask(x, y);
		balls.add(ball);
		timer.schedule(ball, 500, (1000 / 60));
	}



	private class BallTask extends TimerTask {
		int x, y, dx, dy;

		public BallTask(int x, int y) {
			this.x = (int) (x - (ballW * 0.5));
			this.y = (int) (y - (ballH * 0.5));
			dx = (int) (Math.random() * 9 - 4);
			dy = (int) (Math.random() * 9 - 4);
		}

		@Override
		public void run() {
			if (x <= 0 || x + ballW >= viewW) {
				dx = dx * -1;
			} // 乘-1改變該向量方向
			if (y <= 0 || y + ballH >= viewH) {
				dy = dy * -1;
			} // 乘-1改變該向量方向
			x = x + dx;// 增加座標值
			y = y + dy;// 增加座標值
		}
	}

	private class refreshTask extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth();
		viewH = getHeight();
		for (BallTask ball : balls) {
			g.drawImage(ball0, ball.x, ball.y, null);
		}
	}
}
