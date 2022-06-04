package db.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import db.login.DB;

@SuppressWarnings("serial")
public class MemberListFrame extends JFrame implements ActionListener
{
	
	private JButton btnRefresh, btnInsert, btnSearch, btnUpdate, btnDetete, btnBack;
	private DefaultTableModel model;
	private JTable table;
	

	public MemberListFrame(String title, int width, int height)
	{
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setButtonPanel();
		setTablePanel();

		setVisible(true);
	}

	private void setButtonPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		panel.add(panelButton);
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelButton.setBorder(BorderFactory.createLineBorder(Color.black));

		btnRefresh = new JButton("새로고침");
		btnRefresh.addActionListener(this);
		panelButton.add(btnRefresh);

		btnInsert = new JButton("등록");
		btnInsert.addActionListener(this);
		panelButton.add(btnInsert);

		btnSearch = new JButton("조회");
		btnSearch.addActionListener(this);
		panelButton.add(btnSearch);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		panelButton.add(btnUpdate);

		btnDetete = new JButton("삭제");
		btnDetete.addActionListener(this);
		panelButton.add(btnDetete);

		btnBack = new JButton("돌아가기");
		btnBack.addActionListener(this);
		panelButton.add(btnBack);
		add(panel, BorderLayout.NORTH);

	}

	private void setTablePanel()
	{
		JPanel panelTable = new JPanel();
		panelTable.setLayout(new BorderLayout());
		panelTable.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		model = new DefaultTableModel();
		table = new JTable(model);
		table.setRowSorter(new TableRowSorter<>(model));

		try
		{
			setTable();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setLocation(table.getLocation());
		scrollPane.setSize(table.getSize());
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
		panelTable.add(scrollPane);

		add(panelTable, BorderLayout.CENTER);
	}

	private void setTable()
	{
		// 1 컬럼 헤더 설정하기
		String[] colNames = { "이름", "주민번호", "전화번호", "주소" };
		setColumnHeader(colNames);

		// 2. 컬럼 사이즈 설정
		int[] colSize = { 25, 25, 25, 25 };
		setColumnSize(colSize);

		// 3. 컬럼에 데이터 정렬
		int[] align = {1, 2};
		setColumnAlign(align);

		// 4. 컬럼에 데이터 설정
		String sql = "SELECT * FROM MEMBER ";
		ResultSet rs = DB.getResultSet(sql);
		setColumnData(rs);

	}

	private void setColumnHeader(String[] colNames) {		
		for (int i = 0; i < colNames.length; i++) {
			model.addColumn(colNames[i]);
		}		
	}
	
	private void setColumnSize(int[] colSize) {
		for (int i = 0; i < colSize.length; i++) {
			int width = (int) (table.getSize().width * (colSize[i]/101.0));
			table.getColumnModel().getColumn(i).setPreferredWidth(width);			
		}		
	}

	private void setColumnAlign(int[] align) {
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		
		for (int i = 0; i < align.length; i++) {
			table.getColumnModel().getColumn(align[i]).setCellRenderer(right);
		}		
	}

	private void setColumnData(ResultSet rs)  {
		int colCnt;
		try
		{
			colCnt = rs.getMetaData().getColumnCount();
			String data[] = new String[colCnt];			
			
			while(rs.next())
			{				
				for (int i = 0; i < colCnt; i++) {
					data[i] = rs.getString(i + 1);			
				}
				model.addRow(data);				
			}					
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args)	
	{
		DB.init();
		new MemberListFrame("내 DB 프레임", 670, 490);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object obj = e.getSource();
		
		if(obj == btnInsert)
		{
			MemberInsertForm inf = new MemberInsertForm("회원등록", 300, 230);
		} 
		else if(obj == btnRefresh){
			String sql = "select * from MEMBER ";
			tableRefresh(sql);
		} 
	}

	/**
	 * 테이블 갱신하기
	 * @param sql
	 */
	public void tableRefresh(String sql) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}		
		
		ResultSet rs;
		try {
			rs = DB.getResultSet(sql);
			setColumnData(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
