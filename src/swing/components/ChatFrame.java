package swing.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFrame extends JFrame implements ActionListener{

	private JPanel panelCenter;
	private JPanel panelSouth;
	private JTextField tf;
	private JButton btn;
	private JTextArea ta;
	
	public ChatFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 200);
		setSize(300, 300);
		setLayout(new BorderLayout());
		
		setCenter();		
		setSouth();
		
		setVisible(true);
		tf.setFocusable(true);
		tf.requestFocus();
	}

	private void setCenter() {
		panelCenter = new JPanel();
		panelCenter.setBackground(Color.BLUE);
		panelCenter.setLayout(new BorderLayout());
		
		ta = new JTextArea(7, 20);
		ta.setEditable(false);
		ta.setLineWrap(true); 
		JScrollPane sp = new JScrollPane(ta, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panelCenter.add(sp);
		
		add(panelCenter, BorderLayout.CENTER);
	}
	
	private void setSouth() {
		panelSouth = new JPanel();
		//panelSouth.setBackground(Color.RED);
		
		tf = new JTextField(18);
		tf.addActionListener(this);
		panelSouth.add(tf);
		
		btn = new JButton("전송");
		btn.addActionListener(this);
		panelSouth.add(btn);
		
		
		
		add(panelSouth, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn || obj == tf) {			
			ta.append("[사용자] " + tf.getText() + "\n");
			tf.setText("");
			tf.requestFocus();
		}
		
	}


}
