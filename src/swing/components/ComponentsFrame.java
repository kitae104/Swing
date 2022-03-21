package swing.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ComponentsFrame extends JFrame implements ActionListener{

	private JButton btn1;
	private JButton btn2;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	
	public ComponentsFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 300);
		setSize(300, 600);
		setLayout(new FlowLayout());
		
		btn1 = new JButton("버튼1");
		btn1.addActionListener(this);
		btn1.setForeground(Color.RED);
		btn2 = new JButton("버튼2");
		btn2.setEnabled(false);
		btn2.setVisible(true);
		
		add(btn1);
		add(btn2);
		
		lbl1 = new JLabel("지금은 자바 수업중...");	
		
		ImageIcon image = new ImageIcon("images/apple.jpg");
		lbl2 = new JLabel(image);
		
		ImageIcon image2 = new ImageIcon("images/gosling.jpg");
		lbl3 = new JLabel("제임스 고슬링", image2, JLabel.NORTH_EAST);
		
		add(lbl1);
		add(lbl2);
		add(lbl3);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn1) {
			btn2.setVisible(true);
		}
		
	}

}
