package db.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.login.DB;

public class MemberInsertForm extends JFrame implements ActionListener {

	private Dimension size;
	private JPanel panel;
	private JPanel panUp, panCenter;
	private JLabel lblTitle;
	private JLabel lblName, lblJumin, lblTel, lblAddr;
	private JTextField tfName, tfJumin, tfTel, tfAddr; 
	private JButton btnOK, btnCancel;
	
	private boolean check = true;
	
	public MemberInsertForm(String title, int width, int height) {
		size = new Dimension(width, height);

		panel = new JPanel();
		add(panel);
		componentLayout();

		setTitle(title);
		setSize(size);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void componentLayout() {
		panel.setLayout(null);
		
		panUp = new JPanel();
		panUp.setBounds(0, 0, size.width, 30);
		panUp.setBackground(Color.DARK_GRAY);
		setPanUp();
		panel.add(panUp);
		
		panCenter = new JPanel();
		panCenter.setBounds(0, 30, size.width, size.width - 30);
		setPanCenter();
		panel.add(panCenter);
		
	}

	private void setPanUp() {
		lblTitle = new JLabel("<HTML><B><FONT COLOR='white'>회원 등록</FONT></B></HTML>");
		panUp.add(lblTitle);		
	}

	private void setPanCenter() {
		panCenter.setLayout(null);
		
		// 라벨 설정 
		lblName = new JLabel("이름 : ");
		lblName.setBounds(5, 10, 90, 25);			// 라벨의 X축은 고정이고 Y축은 30씩 증가
		panCenter.add(lblName);
 
		lblJumin = new JLabel("주민번호 : ");
		lblJumin.setBounds(5, 40, 90, 25);
		panCenter.add(lblJumin);
		
		lblTel = new JLabel("연락처 : ");
		lblTel.setBounds(5, 70, 90, 25);
		panCenter.add(lblTel);
		
		lblAddr = new JLabel("주소 : ");
		lblAddr.setBounds(5, 100, 90, 25);
		panCenter.add(lblAddr);
		
		// 텍스트 필드 설정 
		tfName = new JTextField();
		tfName.setBounds(size.width-150, 10, 140, 25); 
		panCenter.add(tfName);
		
		tfJumin = new JTextField();
		tfJumin.setBounds(size.width-150, 40, 140, 25);
		panCenter.add(tfJumin);
		
		tfTel = new JTextField();
		tfTel.setBounds(size.width-150, 70, 140, 25);
		panCenter.add(tfTel);
		
		tfAddr = new JTextField();
		tfAddr.setBounds(size.width-150, 100, 140, 25);
		panCenter.add(tfAddr);
		
		// 버튼 추가 
		btnOK = new JButton("확인");
		btnOK.setBounds(60, 140, 90, 25);
		btnOK.addActionListener(this);
		panCenter.add(btnOK);
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(160, 140, 90, 25);
		btnCancel.addActionListener(this);
		panCenter.add(btnCancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnOK){
			check = true;
			if(check)
			{
				checkRequire();		// 빈칸이 존재하는 확인 
			}
			if(check)
			{
				checkJumin();		// 주민번호 중복 확인 
			}
			if(check)
			{
				insertDB();			// 회원 등록 수행 
			}
		} else if(obj == btnCancel){
			setVisible(false);
		}
	}

	/**
	 * 해당 필드가 비었는지 체크하는 메소드 
	 */
	private void checkRequire() {
		if(tfName.getText().equals("")){
			JOptionPane.showMessageDialog(null, "이름 항목은 필수 사항입니다.");
			tfName.requestFocus();	
			check = false;
		} else if(tfJumin.getText().equals("")){
			JOptionPane.showMessageDialog(null, "주민번호 항목은 필수 사항입니다.");
			tfJumin.requestFocus();
			check = false;
		} else if(tfTel.getText().equals("")){
			JOptionPane.showMessageDialog(null, "연락처 항목은 필수 사항입니다.");
			tfTel.requestFocus();
			check = false;
		} else if(tfAddr.getText().equals("")){
			JOptionPane.showMessageDialog(null, "주소 항목은 필수 사항입니다.");
			tfAddr.requestFocus();
			check = false;
		}
	}

	/**
	 * 중복되는 주민번호 확인 
	 */
	private void checkJumin() {
		String sql = "select mb_num "
				+ " from member "
				+ " where mb_num = '" + tfJumin.getText() + "';";
		
		ResultSet rs;
		try {
			rs = DB.getResultSet(sql);
			if(rs != null) {
				// 기존에 주민번호가 존재하는 경우 
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.");
					tfJumin.requestFocus();
					check = false;
					return; 
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * 회원 등록하기 수행 
	 */
	private void insertDB() {
		String sql = "insert into member (name, jumin, tel, addr) "
				+ " values ('" + tfName.getText() + "', '"
				+ tfJumin.getText() + "', '"
				+ tfTel.getText() + "', '"
				+ tfAddr.getText() + "')";
		
		System.out.println("SQL : " + sql);
		
		try {
			DB.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "회원 등록에 성공했습니다.");		
        setVisible(false);
		
	}

}
