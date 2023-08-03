package tw.org.iii.yuan;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame {
	private JButton guess;// 執行
	private JTextField input;// 輸入數字
	private JTextArea log;// 歷史紀錄
	private String answer;// 答案
	private int count;// 計數器
	private LinkedList<JButton> jb;

	public GuessNumber() {
		super("猜數字");// 視窗名稱

		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		// JButton、JTextField、JTextArea都是類別，需要宣告new產生物件
		jb=new LinkedList<>();
		
		JPanel but = new JPanel(new GridLayout(10,1));
		for (int i = 0; i < 10; i++) {
			JButton temp = new JButton();
			jb.add(temp);
			but.add(jb.get(i));
		}
		setLayout(new BorderLayout());
		
		JPanel inside = new JPanel(new BorderLayout());
		add(inside,BorderLayout.CENTER);
		inside.add(log, BorderLayout.CENTER);
		inside.add(but,BorderLayout.EAST);
		
		
		JPanel top = new JPanel(new BorderLayout());
		add(top, BorderLayout.NORTH);
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);

		JScrollPane jsp = new JScrollPane(inside);
		add(jsp, BorderLayout.CENTER);


		setSize(640, 480);// Size
		setVisible(true);// 是否顯示視窗
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 關閉時會停止程式運作

		input.setFont(new Font(null, Font.BOLD, 48));
		log.setFont(new Font(null, Font.BOLD, 48));

		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guess();

			}
		});// 按鈕按下後執行指令

		initGame();
	}// 建構式

	private void guess() {
		count++;
		String g = input.getText();
		String result = checkAB(g);
		log.append(String.format("%d.%s => %s\n", count, g, result));
		input.setText("");

		if (g.equals(answer)) {
			JOptionPane.showMessageDialog(null, "恭喜");
			restart();
		} else if (count == 10) {
			JOptionPane.showMessageDialog(null, "Loser:answer:" + answer);
			restart();
		} // 比對字串用equals 直接用==比對會比對記憶體位置

	}

	private void restart() {
		input.setText("");
		log.setText("");
		initGame();
	}

	private String checkAB(String g) {
		int A, B;
		A = B = 0;
		for (int i = 0; i < g.length(); i++) {
			char c = g.charAt(i);
			if (c == answer.charAt(i)) {
				A++;
			} else if (answer.indexOf(c) >= 0) {
				B++;
			}
		}
		return String.format("%dA%dB", A, B);
	}

	private void initGame() {
		answer = createAnswer(3);
		count = 0;
	}

	private static String createAnswer(int d) {

		// 買新牌、洗牌
		int num = 10;
		int[] poker = new int[num];
		int rand = 0;
		int temp = 0;
		for (int i = 0; i < poker.length; i++) {
			poker[i] = i;
		} // 新牌

		for (int i = num - 1; i > 0; i--) {
			rand = (int) (Math.random() * (i + 1));
			// poker[rand] <=> poker[i]
			temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		} // 洗牌
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < d; i++) {
			sb.append(poker[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		new GuessNumber();

	}

}
