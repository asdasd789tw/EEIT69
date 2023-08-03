package tw.org.iii.yuan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
//	private long[] times;
	private int Rank;

	public Racing() {
		setLayout(new GridLayout(9, 1));

		go = new JButton("Go!");
		add(go);

		cars = new Car[8];
		lanes = new JLabel[8];
//		times = new long[8];
		for (int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel((i + 1) + ". ");
			add(lanes[i]);
		}
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();

			}
		});

		setSize(1024, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void go() {
		for (int i = 0; i < lanes.length; i++) {
			lanes[i].setText((i + 1) + ". ");
		}//清空
		go.setEnabled(false);//反黑按鈕
		Rank = 0;//重設排名
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(i);
			cars[i].start();
		}//把類別陣列內的8個類別初始化並執行
	}

	private class Car extends Thread {
		private int lane;

		Car(int lane) {
			this.lane = lane;
		}

		@Override
		public void run() {
//			long start = System.currentTimeMillis();
			for (int i = 0; i < 100; i++) {
				try {
					if (i == 99) {
						lanes[lane].setText(lanes[lane].getText() + ">" + ++Rank);
						stopGame();
					} else {
						lanes[lane].setText(lanes[lane].getText() + ">");
					}
					sleep(10 + (int) ((Math.random() * 101)));
				} catch (InterruptedException e) {
					break;
				}
			}
		}
//			times[lane] = System.currentTimeMillis() - start;
//			lanes[lane].setText(lanes[lane].getText() + times[lane]);
	}

	private void stopGame() {
		for (int i = 0; i < cars.length; i++) {
			cars[i].interrupt();
		}
		go.setEnabled(true);//取消反黑按鈕
	}

	public static void main(String[] args) {
		new Racing();
	}

}
