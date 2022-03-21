package swing.layout;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoLayoutFrame extends JFrame{

	public NoLayoutFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 300);
		setSize(300, 200);
		
		setLayout(null);	
		
		
		JButton btn1 = new JButton("1");
		btn1.setSize(50, 25);
		btn1.setLocation(100, 100);
		
		JButton btn2 = new JButton("2");
		btn2.setSize(50, 50);
		btn2.setLocation(50, 50);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(70, 30, 100, 25);
		
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
		
		setVisible(true);
	}

}
