package tw.org.iii.classes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomMouseListener extends MouseAdapter{
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("test");
	}
	
	
}

