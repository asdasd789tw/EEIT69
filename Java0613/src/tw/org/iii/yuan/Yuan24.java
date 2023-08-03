package tw.org.iii.yuan;

import javax.swing.JFrame;

public class Yuan24 extends JFrame{
	public Yuan24() {
		super("我的視窗");//視窗名稱
		setSize(640, 480);//Size
		setVisible(true);//是否顯示視窗
		setDefaultCloseOperation(EXIT_ON_CLOSE);//關閉時會停止程式運作
	}
	
	public static void main(String[] args) {
		new Yuan24();
		
	}

}
