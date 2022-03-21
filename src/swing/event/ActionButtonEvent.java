package swing.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionButtonEvent extends JFrame implements ActionListener{

	private JButton btn;	// 인스턴스 변수 
	private JButton btn2;
	
	public ActionButtonEvent(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 300);
		setSize(300, 300);
		setLayout(new FlowLayout());
		
		btn = new JButton("Action");			
		btn.addActionListener(this);
		
		btn2 = new JButton("Test");			
		btn2.addActionListener(this);
		
		add(btn);
		add(btn2);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();	// 누가 동작했는지?
		
		if(obj == btn) {
			System.out.println("AAAA");
		} else if (obj == btn2) {
			System.out.println("BBB");
		}
		
		
	}
}


