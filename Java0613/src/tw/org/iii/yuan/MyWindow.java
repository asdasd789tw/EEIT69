package tw.org.iii.yuan;
import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
	private GridBagConstraints gbc;
    public MyWindow() {
    	
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();// 用於控制GridBagLayout
        gbc.insets = new Insets(0,0, 0, 0);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        // 添加panel1上的元件...
        panel1.add(new JLabel("元件 1"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        // 添加panel2上的元件...
        panel2.add(new JLabel("元件 2"));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());

        // 添加panel2上的元件...
        panel3.add(new JLabel("元件 3"));
        gbc.gridx=0;
        gbc.gridy=0;
        mainPanel.add(panel1,gbc);
        gbc.gridy=1;
        mainPanel.add(panel2,gbc);
        gbc.gridy=2;
        mainPanel.add(panel3,gbc);

        add(mainPanel, BorderLayout.CENTER);

        
        setTitle("視窗標題");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyWindow();
            }
        });
    }
}