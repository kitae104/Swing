package swing.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MainFrame extends JFrame implements ActionListener {

    private JLabel imgLabel;
    private JList<String> list;
    private Vector<String> vecList;
    private Vector<String> vecCombo;

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
    private JTextField textField;
    private JComboBox<String> comboBox;

    public MainFrame(String title, int width, int height){
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setSize(width, height);
        setLayout(new BorderLayout());

        ImageIcon logo = new ImageIcon("images/logo.png");
        setIconImage(logo.getImage());

        vecList = new Vector<>();
        vecList.add("사과");
        vecList.add("배");
        vecList.add("체리");

        vecCombo = new Vector<>();
        vecCombo.add("AAA");
        vecCombo.add("BBB");
        vecCombo.add("CCC");

        setMenu();

        setToolBar();

        setCenter();

        setVisible(true);
    }

    private void setMenu() {
        menuFile = new JMenu("파일");

        itemNew = new JMenuItem("새파일");
        itemOpen = new JMenuItem("열기");
        itemSave = new JMenuItem("저장");
        itemExit = new JMenuItem("종료");
        itemExit.addActionListener(this);

        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.addSeparator();
        menuFile.add(itemExit);

        menuBar = new JMenuBar();
        menuBar.add(menuFile);

        menuProject = new JMenu("프로젝트");
        menuBar.add(menuProject);

        menuHelp = new JMenu("도움말");
        itemInfo = new JMenuItem("정보");
        menuHelp.add(itemInfo);
        menuBar.add(menuHelp);

        setJMenuBar(menuBar);
    }

    private void setToolBar() {
        toolbar = new JToolBar();

        ImageIcon iconNew = new ImageIcon("images/new.png");
        ImageIcon iconOpen = new ImageIcon("images/open.png");
        ImageIcon iconSave = new ImageIcon("images/save.png");
        ImageIcon iconExit = new ImageIcon("images/exit.png");

        btnNew = new JButton(iconNew);
        btnOpen = new JButton(iconOpen);
        btnSave = new JButton(iconSave);
        btnExit = new JButton(iconExit);
        btnExit.addActionListener(this);

        toolbar.add(btnNew);
        toolbar.add(btnOpen);
        toolbar.add(btnSave);
        toolbar.addSeparator();
        toolbar.add(btnExit);

        toolbar.add(new JLabel(" search : "));

        textField = new JTextField(10);
        toolbar.add(textField);

        comboBox = new JComboBox<>(vecCombo);
        toolbar.add(comboBox);

        add(toolbar, BorderLayout.NORTH);

    }

    private void setCenter() {

        list = new JList<>(vecList);

        ImageIcon img = new ImageIcon("images/gosling.jpg");
        imgLabel = new JLabel(img);
        JScrollPane sp = new JScrollPane(imgLabel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, sp);
        jsp.setDividerLocation(150);

        add(jsp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btnExit || source == itemExit){
            System.exit(0);
        }
    }
}
