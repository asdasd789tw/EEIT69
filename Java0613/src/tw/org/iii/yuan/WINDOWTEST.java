package tw.org.iii.yuan;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class WINDOWTEST extends JFrame {
	private JPanel panel;

	public WINDOWTEST() {
		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel label = new JLabel("點擊我添加新的JLabel");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel newLabel = new JLabel("新的JLabel");
				panel.add(newLabel);
				panel.repaint();
			}
		});

		panel.add(label);
		add(panel);

		setTitle("視窗標題");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WINDOWTEST();
			}
		});
	}
}