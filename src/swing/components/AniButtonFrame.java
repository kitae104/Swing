package swing.components;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AniButtonFrame extends JFrame{

	private JButton btn;
	
	public AniButtonFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2600, 200);
		setSize(300, 300);
		setLayout(new FlowLayout());
		
		ImageIcon icon1 = new ImageIcon("images/normalIcon.gif");
		ImageIcon icon2 = new ImageIcon("images/rollOverIcon.gif");
		ImageIcon icon3 = new ImageIcon("images/pressedIcon.gif");
		
		btn = new JButton("Call", icon1);
		btn.setPressedIcon(icon3);
		btn.setRolloverIcon(icon2);
		add(btn);
		
		setVisible(true);
	}

}
