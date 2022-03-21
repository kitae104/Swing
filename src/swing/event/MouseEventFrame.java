package swing.event;

import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventFrame extends JFrame implements MouseListener, KeyListener, MouseMotionListener{

	private JLabel lbl;				// 인스턴스 변수 
	private Container c;
	
	public MouseEventFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 300);
		setSize(300, 300);
		
		c = this.getContentPane();
		
		c.setLayout(null);
		
		lbl = new JLabel("홍길동");
		lbl.setSize(40, 20);
		lbl.setLocation(100, 100);
		c.add(lbl);
		
		c.addMouseListener(this);
		c.addKeyListener(this);
		c.addMouseMotionListener(this);
		
		c.setFocusable(true);
		c.requestFocus();
		
		setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();		
		lbl.setLocation(x, y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Random rand = new Random();
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		c.setBackground(new Color(r, g, b));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char keyChar = e.getKeyChar();
		int keyCode = e.getKeyCode();
		
		int x = lbl.getX();
		int y = lbl.getY();		
		
		final int STEP = 30;
		
		if(keyCode == 37) {
			lbl.setLocation(x-STEP, y);
		} else if(keyCode == KeyEvent.VK_RIGHT) {
			lbl.setLocation(x + STEP, y);
		} else if(keyCode == KeyEvent.VK_UP) {
			lbl.setLocation(x, y - STEP);
		} else if(keyCode == KeyEvent.VK_DOWN) {
			lbl.setLocation(x, y + STEP);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {		
		lbl.setLocation(e.getPoint());		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
