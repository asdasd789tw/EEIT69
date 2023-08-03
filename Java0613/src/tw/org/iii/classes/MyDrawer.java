package tw.org.iii.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, lineundo;

	public MyDrawer() {
		lines = new LinkedList<>();
		lineundo = new LinkedList<>();
		setBackground(Color.yellow);
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}

	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", x);
			point.put("y", y);
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
			line.add(point);
			lines.add(line);
			lineundo.clear();
			repaint();// 重複觸發paintComponent

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", x);
			point.put("y", y);
			lines.getLast().add(point);
			repaint();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(5));// 線粗

		for (LinkedList<HashMap<String, Integer>> line : lines) {
			for (int i = 1; i < line.size(); i++) {
				System.out.println(i);
				HashMap<String, Integer> p0 = line.get(i - 1);
				HashMap<String, Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
		}

	}

	public void clear() {
		lines.clear();
		lineundo.clear();
		repaint();
	}

	public void undo() {
		if (lines.size() > 0) {
			lineundo.add(lines.removeLast());// removeLast會return刪除的元素
			repaint();
		}

//		try {
//			lineundo.getLast().add(lines.getLast().getLast());
//			lines.getLast().removeLast();
//			repaint();			
//		} catch (NoSuchElementException e) {
//			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
//			lineundo.add(line);
//			lines.removeLast();
//			System.out.println(e);
//
//		}一次恢復一個點

	}

	public void redo() {
//		try {
//			lines.getLast().add(lineundo.getLast().getLast());
//			lineundo.getLast().removeLast();
//			repaint();			
//		} catch (Exception e) {
//		}一次恢復一個點
		if (lineundo.size() > 0) {
			lines.add(lineundo.removeLast());// removeLast會return刪除的元素
			repaint();
		}
	}
	
	public void saveJPEG() {
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		paint(g);
		try {
			ImageIO.write(image, "jpg", new File("dir1/yuan.jpg"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void saveLines() throws Exception {
		try(ObjectOutputStream oout = 
			new ObjectOutputStream(new FileOutputStream("dir1/Yuan.sign"))){
			oout.writeObject(lines);
			oout.flush();
		}
	}
	
	public void loadLines() throws Exception{
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/Yuan.sign"));
		Object obj = oin.readObject();
		lines = (LinkedList<LinkedList<HashMap<String, Integer>>>)obj;
		oin.close();
		repaint();
	}
	
}
