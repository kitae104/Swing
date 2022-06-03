package swing.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuFrame extends JFrame implements ActionListener{

	private JButton btn1;
	private JButton btn2;
	private MainChatFrame mcf;

	public MenuFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2600, 200);
		setSize(100, 200);
		setLayout(new BorderLayout());
		
		setPanelCenter();
		
		setVisible(true);
	}
	
	private void setPanelCenter() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(2, 1, 10, 10));
		panelCenter.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));

		btn1 = new JButton("Main");
		btn1.addActionListener(this);
		btn1.setPreferredSize(new Dimension(80, 60));
		btn2 = new JButton("Sub");
		btn2.addActionListener(this);
		btn2.setPreferredSize(new Dimension(80, 60));
		panelCenter.add(btn1);
		panelCenter.add(btn2);
		
		add(panelCenter);		
	}

	public static void main(String[] args) {
		new MenuFrame("메뉴");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn1) {
			mcf = new MainChatFrame("메인 채팅", 600, 300);
		} else if(obj == btn2) {
			new ChatFrame("채팅", 300	, 300, mcf);
		}
		
	}

}
