package swing.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEvent extends JFrame{

	public ButtonEvent(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 300);
		setSize(300, 300);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		MyActionListener mal = new MyActionListener();
		btn.addActionListener(mal);
		add(btn);
		
		setVisible(true);
	}
	
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton o = (JButton) e.getSource();
			String s = o.getText();
			if(s.equals("Action")) {
				o.setText("¹öÆ°");
			} else {
				o.setText("Action");
			}		
		}

	}

}

