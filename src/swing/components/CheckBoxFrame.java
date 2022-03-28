package swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class CheckBoxFrame extends JFrame implements ItemListener{
	
	private JCheckBox[] ch;
	private JLabel result;
	private int sum = 0;
	private JRadioButton[] radio;	
	
	public CheckBoxFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2600, 200);
		setSize(220, 300);
		setLayout(new FlowLayout());
		
		JLabel lbl = new JLabel("사과 100원, 배 500원, 체리 2000");
		add(lbl);
		
		ch = new JCheckBox[3];
		
		String[] names = {"사과", "배", "체리"};
		
		for (int i = 0; i < ch.length; i++) {
			ch[i] = new JCheckBox(names[i]);
			ch[i].addItemListener(this);
			add(ch[i]);
		}
		
		result = new JLabel("현재 : 0 원");
		add(result);
		
		ButtonGroup g = new ButtonGroup();
		
		radio = new JRadioButton[3];
		for (int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(names[i]);
			g.add(radio[i]);
			add(radio[i]);
		}
		
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		int state = e.getStateChange();
		int sign =0;
		if(state == ItemEvent.SELECTED) {
			sign = 1;
		} else {
			sign = -1;
		}
		
		Object obj = e.getItem();
		if(obj == ch[0]) {   		// 사과 
			sum += (100 * sign);
		}else if(obj == ch[1]) {	// 배
			sum += (500 * sign);
		}else if(obj == ch[2]) {	// 체리
			sum += (2000 * sign);
		}
		
		
		result.setText("현재 : " + sum + " 원");
	}

}
