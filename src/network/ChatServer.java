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
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements ActionListener{

	private JPanel panelCenter;
	private JPanel panelSouth;
	private JTextField tf;
	private JButton btn;
	private JButton btn2;
	private JTextArea ta;
	
	private ServerSocket server = null;
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	
	
	public ChatServer(String title, int width, int height) {
						
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2400, 200);
		setSize(width, height);
		setLayout(new BorderLayout());
		
		setCenter();		
		setSouth();	
		
		setVisible(true);
		tf.setFocusable(true);
		tf.requestFocus();
	}

	public void setSocket() {
		try {
			server = new ServerSocket(9999);
			ta.append(">> 연결을 기다리고 있습니다....\n");
			socket = server.accept();
			ta.append(">> 연결되었습니다.\n");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inMessage = in.readLine();
				
				if(inMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트가 나갔습니다.");
					break;
				}				
				ta.append("[클라이언트] : " + inMessage + "\n");			
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
				server.close();				
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
		
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
				
				ta.append("[서버] " + outMsg + "\n");
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

	public static void main(String[] args) {
		ChatServer cs = new ChatServer("채팅 서버", 300, 400);
		cs.setSocket();
	}
	
}
