package swing.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame implements ActionListener, ListSelectionListener, MouseListener{

	private JList<String> list;
	private JLabel imgLabel;
	private Vector vecList;
	private JMenuBar mbar;
	private JMenu fileMenu;
	private JMenuItem itemNew;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemExit;
	private JMenu projectMenu;
	private JMenu helpMenu;
	private JMenuItem itemInfo;
	private JToolBar toolBar;
	private JButton btnNew;
	private JButton btnOpen;
	private JButton btnSave;
	private JButton btnExit;
	private JComboBox<String> combo;
	private Vector<String> vecCombo;
	private JTextField tf;
	private DefaultListModel model;
	
	public MainFrame(String title, int width, int height) {
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(2400, 200);
		setSize(width, height);
		setLayout(new BorderLayout());
		
		setMenu();
		setToolBar();
		setCenter();
		
		setVisible(true);
	}

	private void setMenu() {
		mbar = new JMenuBar();
		
		fileMenu = new JMenu("파일");
		itemNew = new JMenuItem("새파일");
		itemOpen = new JMenuItem("열기");
		itemSave = new JMenuItem("저장");
		itemExit = new JMenuItem("종료");
		itemExit.addActionListener(this);
		
		fileMenu.add(itemNew);
		fileMenu.add(itemOpen);
		fileMenu.add(itemSave);
		fileMenu.addSeparator();
		fileMenu.add(itemExit);		
		
		projectMenu = new JMenu("Project");
		
		helpMenu = new JMenu("도움말");
		itemInfo = new JMenuItem("프로그램 정보");
		itemInfo.addActionListener(this);
		
		helpMenu.add(itemInfo);
						
		mbar.add(fileMenu);
		mbar.add(projectMenu);
		mbar.add(helpMenu);
		
		this.setJMenuBar(mbar);
	}

	private void setToolBar() {
		toolBar = new JToolBar("내 툴바");
		
		ImageIcon iconNew = new ImageIcon("images/new.png");
		ImageIcon iconOpen = new ImageIcon("images/open.png");
		ImageIcon iconSave = new ImageIcon("images/save.png");
		ImageIcon iconExit = new ImageIcon("images/exit.png");
		
		btnNew = new JButton(iconNew);
		btnOpen = new JButton(iconOpen);
		btnSave = new JButton(iconSave);
		btnExit = new JButton(iconExit);
		btnExit.addActionListener(this);
		
		toolBar.add(btnNew);
		toolBar.add(btnOpen);
		toolBar.add(btnSave);
		toolBar.addSeparator();
		toolBar.add(btnExit);
		
		toolBar.add(new JLabel(" Search : "));
		
		tf = new JTextField(10);
		tf.addActionListener(this);
		toolBar.add(tf);
		
		vecCombo = new Vector<String>();
		vecCombo.add("AAA");
		vecCombo.add("BBB");
		vecCombo.add("CCC");
		
		combo = new JComboBox<>(vecCombo);
		toolBar.add(combo);
		
		add(toolBar, BorderLayout.NORTH);		
	}

	private void setCenter() {
		model = new DefaultListModel<>();
		
		
		model.addElement("사과");
		model.addElement("배");
		model.addElement("체리");
		
		list = new JList<>(model);
		list.addListSelectionListener(this);
		list.addMouseListener(this);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ImageIcon img = new ImageIcon("images/gosling.jpg");		
		imgLabel = new JLabel(img);
		
		JScrollPane sp = new JScrollPane(imgLabel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, sp);
		jsp.setDividerLocation(150);
		add(jsp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == itemExit || obj == btnExit) {
			
			if(JOptionPane.showConfirmDialog(this, "정말 종료할까요?", "종료", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE)== JOptionPane.YES_OPTION ) {			
				System.exit(0);
			}
		} else if(obj == tf) {
			String s = tf.getText();
			model.addElement(s);
			tf.setText("");
			tf.requestFocus();
		} else if(obj == itemInfo) {
			JOptionPane.showMessageDialog(this, "프로그램 by 김기태 ver0.1");
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(list.getSelectedValue());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			vecCombo.add(list.getSelectedValue());
			model.remove(list.getSelectedIndex());
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
}
