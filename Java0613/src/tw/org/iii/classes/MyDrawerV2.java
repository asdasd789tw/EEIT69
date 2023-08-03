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
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyDrawerV2 extends JPanel {
	private LinkedList<Line> lines, lineundo;
	private Color nowColor;
	private float nowWidth;

	public MyDrawerV2() {
		lines = new LinkedList<>();
		lineundo = new LinkedList<>();
		setBackground(Color.yellow);
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		
		nowColor = Color.BLUE;
		nowWidth = 4;
	}
	public void setColor(Color newColor) {
		nowColor=newColor;
	}
	public Color getColor() {
		return nowColor;
	}
	public void setWidth(float newWidth) {
		nowWidth=newWidth;
	}

	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			Line line = new Line(nowColor,nowWidth);
			line.addPoint(x, y);
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
			lines.getLast().addPoint(x, y);;
			repaint();
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;


		for (Line line : lines) {
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));
			
			for (int i = 1; i < line.getSize(); i++) {
				g2d.drawLine(line.getpointX(i-1), line.getpointY(i-1), line.getpointX(i), line.getpointY(i));
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


	}

	public void redo() {
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
		lines = (LinkedList<Line>)obj;
		oin.close();
		repaint();
	}
	
}

class Line implements Serializable{
	
	private LinkedList<HashMap<String, Integer>> points;
	private Color color;
	private float width;
	
	public Line(Color color,float width) {
		points = new LinkedList<>();
		this.color = color;
		this.width = width;
		
	}//傳入顏色及線寬給建構式定義
	
	public void addPoint(int x , int y ) {
		HashMap<String, Integer> point = new HashMap<>();
		point.put("x", x);
		point.put("y", y);
		points.add(point);
	}
	
	public int getpointX(int index) {
		return points.get(index).get("x");		
	}
	
	public int getpointY(int index) {
		return points.get(index).get("y");		
	}
	
	public int getSize() {
		return points.size();
	}
	
	public Color getColor() {
		return color;
	}
	
	public float getWidth() {
		return width;
	}
	
	
}
