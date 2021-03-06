package swing.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainChatFrame extends JFrame implements ActionListener, ListSelectionListener, MouseListener{
	
	private JList<String> list;
	private Vector<String> vecList;
	private JLabel imgLabel;
	
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenuItem itemNew;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemExit;
	
	private JMenu menuProject;
	
	private JMenu menuHelp;
	private JMenuItem itemInfo;
	
	
	private JToolBar toolbar;
	private JButton btnNew;
	private JButton btnOpen;
	private JButton btnSave;
	private JButton btnExit;
	private Vector vecCombo;
	private JComboBox combo;
	private JTextField tf;
	private DefaultListModel<String> model;
	
	private ChatFrame cf;
	private JTextArea ta;
	
	public MainChatFrame(String title, int width, int height) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 200);
		setSize(width, height);
		setLayout(new BorderLayout());
		
		setMenu();
		setToolBar();
		setCenter();
		
		setVisible(true);
	}

	private void setMenu() {		
		
		menuBar = new JMenuBar();
		
		menuFile = new JMenu("??????");
		itemNew = new JMenuItem("?????????");
		itemOpen = new JMenuItem("??????");
		itemOpen.addActionListener(this);
		
		itemSave = new JMenuItem("??????");
		itemExit = new JMenuItem("??????");
		itemExit.addActionListener(this);
		
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.addSeparator();
		menuFile.add(itemExit);		
				
		menuProject = new JMenu("Project");
				
		menuHelp = new JMenu("?????????");
		itemInfo = new JMenuItem("???????????? ??????");
		itemInfo.addActionListener(this);
		
		menuHelp.add(itemInfo);
		
		menuBar.add(menuFile);
		menuBar.add(menuProject);
		menuBar.add(menuHelp);
		
		
		this.setJMenuBar(menuBar);
		
	}

	private void setToolBar() {
		toolbar = new JToolBar();
		//toolbar.setPreferredSize(new Dimension(20, 20));
		
		ImageIcon iconNew = new ImageIcon("images/new.png");		
		ImageIcon iconOpen = new ImageIcon("images/open.png");
		ImageIcon iconSave = new ImageIcon("images/save.png");
		ImageIcon iconExit = new ImageIcon("images/exit.png");
		
		btnNew = new JButton(iconNew);
		btnNew.addActionListener(this);
		//btnNew.setPreferredSize(new Dimension(20, 20));
		
		btnOpen = new JButton(iconOpen);
		btnOpen.addActionListener(this);
		
		btnSave = new JButton(iconSave);
		btnSave.addActionListener(this);
		
		btnExit = new JButton(iconExit);
		btnExit.addActionListener(this);
		
		toolbar.add(btnNew);
		toolbar.add(btnOpen);
		toolbar.add(btnSave);
		toolbar.addSeparator();
		toolbar.add(btnExit);
		
		toolbar.add(new JLabel(" Search : "));
		
		tf = new JTextField(10);
		tf.addActionListener(this);
		toolbar.add(tf);
		
		
		vecCombo = new Vector<>();
		vecCombo.add("AAA");
		vecCombo.add("BBB");
		vecCombo.add("CCC");
		
		combo = new JComboBox<>(vecCombo);
		toolbar.add(combo);
		
		add(toolbar, BorderLayout.NORTH);
		
	}

	private void setCenter() {
		
		model = new DefaultListModel<>();	
		
		model.addElement("??????");
		model.addElement("???");
		model.addElement("??????");
		
		list = new JList<>(model);
		list.addListSelectionListener(this);
		list.addMouseListener(this);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ImageIcon img = new ImageIcon("images/gosling.jpg");
		imgLabel = new JLabel(img);
		
		ta = new JTextArea();
		ta.setLineWrap(true);
		
		JScrollPane imgScroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, imgScroll);
		jsp.setDividerLocation(150);
		
		add(jsp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == itemExit || source == btnExit) {
			
			if((JOptionPane.showConfirmDialog(this, "?????? ?????????????", "???????????? ??????", 
					JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)) {
				System.exit(0);
			}			
			
		} else if(source == tf) {
			ta.append("[??????] " + tf.getText() + "\n");
			JTextArea ta2 = cf.getTa();
			ta2.append("[??????] " + tf.getText() + "\n");
			addListItem();
		} else if(source == itemInfo) {
			JOptionPane.showMessageDialog(this, "???????????? by ????????? ver 0.1");
		} else if (source == btnNew) {
			cf = new ChatFrame("??????", 300, 300, this);
			cf.setTitle("?????? ??????");
		} else if (source == btnOpen) {			
			cf.setTitle("?????? ?????? ??????");			
		} else if (source == btnSave) {
			JButton btn = cf.getBtn();
			btn.setText("Send");
		} else if(source == itemOpen) {
			System.out.println("111");
			JFileChooser fc = new JFileChooser();
			
			fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("Text", "txt"));
			
			fc.showSaveDialog(this);
			
			File in = fc.getSelectedFile();
			BufferedReader br = null;
			String line = null;
			
			try {
				br = new BufferedReader(new FileReader(in));
				while((line = br.readLine()) != null) {
					ta.append(line + "\n");
				}
				br.close();
				
			} catch (FileNotFoundException e1) {				
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}

	private void addListItem() {
		String s = tf.getText();			
		if(s == null || s.length() ==0) {
			return;
		}			
		model.addElement(s);
		tf.setText("");
		tf.requestFocus();
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

	public JTextArea getTa() {
		return ta;
	}

	
}
