package network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{

	private JPanel panelCenter;
	private JPanel panelSouth;
	private JTextField tf;
	private JButton btn;
	private JButton btn2;
	private JTextArea ta;
		
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	
	public ChatClient(String title, int width, int height) {
						
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2700, 200);
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
			try {
				String outMsg = tf.getText();
				out.write(outMsg + "\n");
				out.flush();
				
				ta.append("[클라이언트] " + outMsg + "\n");
				tf.setText("");
				tf.requestFocus();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if(obj == btn2) {
			
		}
		
	}

	public JButton getBtn() { 
		return btn;
	}

	public JTextArea getTa() {
		return ta;
	}
	
	public void setSocket() {
		try {			
			socket = new Socket("127.0.0.1", 9999);	
			ta.append("서버 연결 완료!\n");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {			
				String inMessage = in.readLine();
				ta.append("[서버] : " + inMessage + "\n");			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();	
				
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		ChatClient cc = new ChatClient("채팅 클라이언트", 300, 400);
		cc.setSocket();
	}
	
}
