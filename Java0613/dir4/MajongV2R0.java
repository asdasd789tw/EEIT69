package tw.org.iii.yuan;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tw.org.iii.classes.JPMajong;

public class MajongV2 extends JFrame{
	private JPMajong jpmajong;
	private JButton test;
	
	public MajongV2() {
		setLayout(new BorderLayout());		
		jpmajong = new JPMajong();
		test = new JButton("TEST");
		JPanel top = new JPanel(new FlowLayout());
		top.add(test);
		add(jpmajong.getcard(3),BorderLayout.EAST);
		add(jpmajong.getcard(0),BorderLayout.SOUTH);
		add(jpmajong.getcard(1),BorderLayout.WEST);
		add(jpmajong.getcard(2),BorderLayout.NORTH);
		add(top,BorderLayout.CENTER);
		
		test.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				jpmajong.Mountainname();
				System.out.println("------------------");
				jpmajong.cardname();
				System.out.println("test");				
			}
		});
		
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MajongV2();
	}

}
