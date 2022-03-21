package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonFrame extends JFrame{

	public ButtonFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 300);
		setLayout(new FlowLayout());
		setSize(300, 300);
		
		JButton okBtn = new JButton("OK");
		okBtn.setBackground(Color.BLUE);
		
		
		JButton cancelBtn = new JButton("Cancel");
		
		
		JButton ignoreBtn = new JButton("Ignore");
		
		
		Container c = getContentPane();
		add(okBtn);
		add(cancelBtn);
		add(ignoreBtn);
		
		c.setBackground(Color.YELLOW);
		
		setVisible(true);
	}

}
