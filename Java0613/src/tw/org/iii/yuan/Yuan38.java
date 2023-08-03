package tw.org.iii.yuan;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Yuan38 extends JFrame implements MouseListener {
	private JTextField mesg, mesg2, mesg3;

	public Yuan38() {
		super("Mouse");

		setLayout(new BorderLayout());
		mesg = new JTextField();
		add(mesg, BorderLayout.NORTH);

		mesg2 = new JTextField();
		add(mesg2, BorderLayout.SOUTH);

		mesg3 = new JTextField();
		add(mesg3, BorderLayout.NORTH);

		addMouseListener(new MyMouseListener(this));//1.
		addMouseListener(this);//2.
		addMouseListener(new MyMouseListenerV3());//4.
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}//5.在方法內建立物件並定義所需方法
		});//5.
		setSize(1024, 768);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setMesgText(String mesgText) {
		mesg.setText(mesgText);

	}

	public static void main(String[] args) {
		new Yuan38();

	}

	class MyMouseListenerV3 extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			mesg3.setText("123");
		}

	}// 4.直接在類別內建立類別，省去互相認識的步驟，稱抽象類別

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed" + e.getX() + "," + e.getY());
//		setMesgText(e.getX()+","+e.getY());
		mesg2.setText(e.getX() + "," + e.getY());

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Released");

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}// 2.直接繼承interface

class MyMouseListener implements MouseListener {
	private Yuan38 yuan38;

	public MyMouseListener(Yuan38 y38) {
		yuan38 = y38;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed" + e.getX() + "," + e.getY());
		yuan38.setMesgText(e.getX() + "," + e.getY());

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}// 1.類別之間溝通需要互相認識

class MyListener2 extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {

	}
}// 3.利用抽象類別忽略不想定義的方法，還是需要互相認識