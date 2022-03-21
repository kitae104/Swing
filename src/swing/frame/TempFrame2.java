package swing.frame;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TempFrame2 extends JFrame{

	public TempFrame2(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 300);
		setSize(300, 300);
		
		JButton btn = new JButton("¹öÆ°");
		
//		Container c = this.getContentPane();
//		c.add(btn);
		
		add(btn);
		
		setVisible(true);
	}

}
