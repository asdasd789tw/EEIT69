package tw.org.iii.yuan;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tw.org.iii.classes.Mypanel;

public class MyballGame extends JFrame {
	private Mypanel mypanel;
	private ImageIcon backgroundtest ;
	public MyballGame() {
		setLayout(new BorderLayout());//設置版面為BorderLayout()
		
		mypanel = new Mypanel();//宣告一個panel類別供之後add
		add(mypanel,BorderLayout.CENTER);
		//只add進去BorderLayout.CENTER，可佈滿整個版面
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//add要是Component類別，Container本身也是Component
		mypanel.setOpaque(false);
		//背景
		backgroundtest = new ImageIcon("dir1/green.png");
		JLabel bkjlabel = new JLabel(backgroundtest);
		bkjlabel.setBounds(0, 0, getWidth(),getHeight());
		add(bkjlabel);
		//背景
	}

	public static void main(String[] args) {
		new MyballGame();
		

	}

}
