package tw.org.iii.yuan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.classes.MyClock;
import tw.org.iii.classes.MyDrawerV2;

public class MySign extends JFrame {
	private MyDrawerV2 mydrawer;
	private JButton clear , undo , redo,saveJPEG,saveObj,loadobj,
			changeColor; 
	private MyClock clock ;
	
	
	public MySign() {
		super("簽名程式");
		setLayout(new BorderLayout());
		mydrawer = new MyDrawerV2();
		add(mydrawer,BorderLayout.CENTER);
		
		clear = new JButton("清除");
		undo = new JButton("上一步");
		redo = new JButton("還原");
		saveJPEG = new JButton("存檔");
		saveObj = new JButton("序列化");
		loadobj = new JButton("解序列化");
		changeColor = new JButton("顏色");		
		
		clock = new MyClock();
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(saveJPEG);
		top.add(saveObj);
		top.add(loadobj);
		top.add(changeColor);
		top.add(clock);
		
		add(top,BorderLayout.NORTH);
		
		clear.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mydrawer.clear();
				
			}
		});
		
		undo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mydrawer.undo();
				
			}
		});
		
		redo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mydrawer.redo();
				
			}
		});
		
		saveJPEG.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mydrawer.saveJPEG();
			}
		});
		
		saveObj.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mydrawer.saveLines();
				} catch (Exception e1) {
					System.out.println(e);
				}
				
			}
		});
		
		loadobj.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mydrawer.loadLines();
				} catch (Exception e1) {
					System.out.println(e);
				}
			}
		});
		
		changeColor.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(null, "換顏色", mydrawer.getColor());
				if(newColor!=null) {
					mydrawer.setColor(newColor);
				}
				
			}
		});
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MySign();
		

	}

}
