package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DataAccessObj.ShowDataDAO;
import DataAccessObj.ShowDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.ShowData;
import model.ShowData;

public class ShowDataManageInterFrame extends JInternalFrame {

private JTable ShowDataTable;
	
private JTable showDataTable;

private DbUtil dbUtil = new DbUtil();
private ShowDataDAO showDataDao = new ShowDataDAO();
private JTextField s_showTitleTxt;
private JTextField idTxt;
private JTextField showTitleTxt;
private JTextField showDescTxt;
private JTextField yearTxt;
private JTextField IMDBidTxt;
private JTextField popularityTxt;
private JTextField runtimeTxt;
private JTextField seasonTxt;

/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				ShowDataManageInterFrame frame = new ShowDataManageInterFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
 * Create the frame.
 */
public ShowDataManageInterFrame() {
	setResizable(true);
	setIconifiable(true);
	setClosable(true);
	setTitle("Show Data Management");
	setBounds(100, 100, 782, 531);
	
	JScrollPane scrollPane = new JScrollPane();
	
	JLabel lblNewLabel = new JLabel("Show Title: ");
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	
	s_showTitleTxt = new JTextField();
	s_showTitleTxt.setColumns(10);
	
	JButton btnNewButton = new JButton("Search");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showDataSearchActionPerformed(e);
		}
		
	});
	btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
	
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Management Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	GroupLayout groupLayout = new GroupLayout(getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.TRAILING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(74)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(s_showTitleTxt, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 626, Short.MAX_VALUE))
				.addGap(70))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(45)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel)
					.addComponent(s_showTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnNewButton))
				.addGap(32)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(47, Short.MAX_VALUE))
	);
	
	JLabel lblNewLabel_1 = new JLabel("ID: ");
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
	
	idTxt = new JTextField();
	idTxt.setEditable(false);
	idTxt.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("Title: ");
	lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
	
	showTitleTxt = new JTextField();
	showTitleTxt.setColumns(10);
	
	JLabel lblNewLabel_3 = new JLabel("Description: ");
	lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
	
	showDescTxt = new JTextField();
	showDescTxt.setColumns(10);
	
	JButton btnNewButton_1 = new JButton("Modify");
	btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showDataUpdateActionEvent(e);
		}
	});
	
	JButton btnNewButton_2 = new JButton("Delete");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			showDataDeleteActionEvent(e);
		}
	});
	btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
	
	JLabel lblNewLabel_4 = new JLabel("Year: ");
	lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
	
	JLabel lblNewLabel_5 = new JLabel("IMDBid: ");
	lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
	
	yearTxt = new JTextField();
	yearTxt.setColumns(10);
	
	IMDBidTxt = new JTextField();
	IMDBidTxt.setColumns(10);
	
	JLabel lblNewLabel_6 = new JLabel("Runtime: ");
	lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
	
	JLabel lblNewLabel_7 = new JLabel("Popularity: ");
	lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
	
	popularityTxt = new JTextField();
	popularityTxt.setColumns(10);
	
	runtimeTxt = new JTextField();
	runtimeTxt.setColumns(10);
	
	JLabel lblNewLabel_8 = new JLabel("Season: ");
	lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 13));
	
	seasonTxt = new JTextField();
	seasonTxt.setColumns(10);
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(runtimeTxt, 0, 0, Short.MAX_VALUE)
							.addComponent(yearTxt, 0, 0, Short.MAX_VALUE)
							.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(IMDBidTxt)
							.addComponent(showTitleTxt, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
							.addComponent(popularityTxt))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(12)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(seasonTxt, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(showDescTxt, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
				.addContainerGap())
	);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblNewLabel_1)
					.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewLabel_2)
					.addComponent(seasonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(showTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblNewLabel_8))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4)
							.addComponent(yearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_5)
							.addComponent(lblNewLabel_3)
							.addComponent(IMDBidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_6)
							.addComponent(runtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_7)
							.addComponent(popularityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addComponent(showDescTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addComponent(btnNewButton_2)
					.addComponent(btnNewButton_1)))
	);
	panel.setLayout(gl_panel);
	
	showDataTable = new JTable();
	showDataTable.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			showDataTableMousePressed(e);
		}
	});
	showDataTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	showDataTable.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"ShowID", "Show Tilte", "Description", "Year", "Runtime", "Season", "IMDBid", "Popularity"
		}
	) {
		boolean[] columnEditables = new boolean[] {
			false, false, false, true, true, true, true, true
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	});
	showDataTable.getColumnModel().getColumn(0).setPreferredWidth(61);
	showDataTable.getColumnModel().getColumn(1).setPreferredWidth(96);
	showDataTable.getColumnModel().getColumn(2).setPreferredWidth(157);
	showDataTable.getColumnModel().getColumn(3).setPreferredWidth(40);
	showDataTable.getColumnModel().getColumn(4).setPreferredWidth(59);
	showDataTable.getColumnModel().getColumn(5).setPreferredWidth(49);
	showDataTable.getColumnModel().getColumn(6).setPreferredWidth(64);
	showDataTable.getColumnModel().getColumn(7).setPreferredWidth(74);
	scrollPane.setViewportView(showDataTable);
	getContentPane().setLayout(groupLayout);

	this.fillTable(new ShowData());
	this.setLocation(550, 235);
}

/**
 * show data delete event handle
 * @param e
 */
private void showDataDeleteActionEvent(ActionEvent e) {
	String id = idTxt.getText();
	if (StringUtil.isEmpty(id)) {
		JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
		return;
	}
	int n = JOptionPane.showConfirmDialog(null, "Confirm Deletion?");
	if (n == 0) {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int deleteNum = showDataDao.delete(con, id);
			if (deleteNum == 1) {
				JOptionPane.showMessageDialog(null, "Deletion Successed");
				this.resetValue();
				this.fillTable(new ShowData());
			} else {
				JOptionPane.showMessageDialog(null, "Deletion Failed");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Deletion Failed");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}

private void showDataUpdateActionEvent(ActionEvent e) {
	String id = idTxt.getText();
	String showTitle = showTitleTxt.getText();
	String showDesc = showDescTxt.getText();
	int year = Integer.parseInt(yearTxt.getText());
	int runtime = Integer.parseInt(runtimeTxt.getText());
	int season = Integer.parseInt(seasonTxt.getText());
	String IMDBid = IMDBidTxt.getText();
	Double popularity = Double.parseDouble(popularityTxt.getText());

	if (StringUtil.isEmpty(id)) {
		JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
		return;
	}
	
	if (StringUtil.isEmpty(showTitle)) {
		JOptionPane.showMessageDialog(null, "Show Title Cannot be Empty!");
		return;
	}
	
	ShowData showData = new ShowData(id, showTitle, showDesc, year, runtime, season, IMDBid, popularity);
	Connection con = null;
	try {
		con = dbUtil.getCon();
		int modifyNum = showDataDao.updata(con, showData);
		if(modifyNum == 1) {
			JOptionPane.showMessageDialog(null, "Modification Successed!");
			this.resetValue();
			this.fillTable(new ShowData());
		} else {
			JOptionPane.showMessageDialog(null, "Modification Failed!");
		}
	} catch (Exception e1){
		e1.printStackTrace();
	} finally {
		try {
			dbUtil.closeCon(con);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}

/**
 * mouse pressed event handle
 * @param event
 */
private void showDataTableMousePressed(MouseEvent event) {
	int row = showDataTable.getSelectedRow();
	idTxt.setText((String)showDataTable.getValueAt(row, 0));
	showTitleTxt.setText((String)showDataTable.getValueAt(row, 1));
	showDescTxt.setText((String)showDataTable.getValueAt(row, 2));
	yearTxt.setText(String.valueOf(showDataTable.getValueAt(row, 3)));
	runtimeTxt.setText(String.valueOf(showDataTable.getValueAt(row, 4)));
	seasonTxt.setText(String.valueOf(showDataTable.getValueAt(row, 5)));
	IMDBidTxt.setText((String)showDataTable.getValueAt(row, 6));
	popularityTxt.setText(String.valueOf(showDataTable.getValueAt(row, 7)));

}

/**
 * Show Title Search Event Handle
 * @param event
 */
private void showDataSearchActionPerformed(ActionEvent event) {

	String s_showTitle = this.s_showTitleTxt.getText();
	ShowData showData = new ShowData();
	showData.setShowTitle(s_showTitle);
	this.fillTable(showData);
}

/**
 * initialize Show Table
 * @param showData
 */
private void fillTable(ShowData showData) {
	DefaultTableModel dtm = (DefaultTableModel) showDataTable.getModel();
	dtm.setRowCount(0);
	Connection con = null;
	try {
		con = dbUtil.getCon();
		ResultSet rs = showDataDao.list(con, showData);
		while(rs.next()) {
			Vector v = new Vector();
			v.add(rs.getString("ShowID"));
			v.add(rs.getString("title"));
			v.add(rs.getString("Description"));
			v.add(rs.getInt("year"));
			v.add(rs.getInt("length"));
			v.add(rs.getInt("season"));
			v.add(rs.getString("IMDBid"));
			v.add(rs.getDouble("popularity"));

			dtm.addRow(v);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			dbUtil.closeCon(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

private void resetValue() {
	this.idTxt.setText("");
	this.showTitleTxt.setText("");
	this.showDescTxt.setText("");
	this.yearTxt.setText("");
	this.runtimeTxt.setText("");
	this.seasonTxt.setText("");
	this.IMDBidTxt.setText("");
	this.popularityTxt.setText("");

}
}
