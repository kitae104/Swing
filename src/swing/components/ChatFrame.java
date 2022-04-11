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
	private JButton btn2;
	private JTextArea ta;
	private MainChatFrame mainChatFrame;
	
	public ChatFrame(String title, int width, int height, MainChatFrame mainChatFrame) {
		
		this.mainChatFrame = mainChatFrame;
		mainChatFrame.setTitle("이건 내꺼");
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2900, 200);
		setSize(width, height);
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
		
		btn2 = new JButton("전송2");
		btn2.addActionListener(this);
		
		panelSouth.add(btn);
//		panelSouth.add(btn2);
		
		
		
		add(panelSouth, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn || obj == tf) {			
			ta.append("[클라이언트] " + tf.getText() + "\n");
			
			JTextArea ta2 = mainChatFrame.getTa();
			ta2.append("[클라이언트] " + tf.getText() + "\n");
			
			tf.setText("");
			tf.requestFocus();
			
			
		} else if(obj == btn2) {
			mainChatFrame.setTitle("제목 수정..");
		}
		
	}

	public JButton getBtn() { 
		return btn;
	}

	public JTextArea getTa() {
		return ta;
	}

	
	
}
