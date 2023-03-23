package View;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DataAccessObj.ActTDataDAO;
import Util.DbUtil;
import Util.StringUtil;
import model.ActTData;
import model.ActTData;

public class ActTDataManageInterFrame extends JInternalFrame {

	private JTextField s_ActorIDTxt;
	private JTable ActTDataTable;
	private JTextField ActorIDTxt;
	private JTextField ShowIDTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private ActTDataDAO actTDataDAO = new ActTDataDAO();
	private JTextField cnameTTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActorDataManageInterFrame frame = new ActorDataManageInterFrame();
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
	public ActTDataManageInterFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Actor Data Manage");
		setBounds(100, 100, 564, 452);
		
		JLabel lblNewLabel = new JLabel("ActorID: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		s_ActorIDTxt = new JTextField();
		s_ActorIDTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Management Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_ActorIDTxt, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addGap(59))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_ActorIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("ActorID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("ShowID:  ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		ActorIDTxt = new JTextField();
		ActorIDTxt.setEditable(false);
		ActorIDTxt.setColumns(10);
		
		ShowIDTxt = new JTextField();
		ShowIDTxt.setEditable(false);
		ShowIDTxt.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Character: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		cnameTTxt = new JTextField();
		cnameTTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorDataUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ShowIDTxt)
						.addComponent(ActorIDTxt, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(cnameTTxt, Alignment.TRAILING))
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_2)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(ActorIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(ShowIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(cnameTTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		ActTDataTable = new JTable();
		ActTDataTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ActorDataTableMousePressed(e);
			}
		});
		ActTDataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ActorID", "ShowID", "Character Name"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		ActTDataTable.getColumnModel().getColumn(0).setPreferredWidth(136);
		ActTDataTable.getColumnModel().getColumn(1).setPreferredWidth(221);
		ActTDataTable.getColumnModel().getColumn(2).setPreferredWidth(127);
		scrollPane.setViewportView(ActTDataTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new ActTData());
		this.setLocation(550, 235);
	}
	
	private void ActorDataDeleteActionEvent(ActionEvent e) {
		String id = ActorIDTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "Confirm Deletion?");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = actTDataDAO.delete(con, id);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "Deletion Successed");
					this.resetValue();
					this.fillTable(new ActTData());
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

	private void ActorDataUpdateActionEvent(ActionEvent e) {
		String id = ActorIDTxt.getText();
		String showID = ShowIDTxt.getText();
		String cnameT = cnameTTxt.getText();
		
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "Please select data need to be modified!");
			return;
		}
		
		if (StringUtil.isEmpty(cnameT)) {
			JOptionPane.showMessageDialog(null, "Name Cannot be Empty!");
			return;
		}
		
		ActTData actTData = new ActTData(id, showID, cnameT);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = actTDataDAO.updata(con, actTData);
			if(modifyNum == 1) {
				JOptionPane.showMessageDialog(null, "Modification Successed!");
				this.resetValue();
				this.fillTable(new ActTData());
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
	private void ActorDataTableMousePressed(MouseEvent event) {
		int row = ActTDataTable.getSelectedRow();
		ActorIDTxt.setText((String)ActTDataTable.getValueAt(row, 0));
		ShowIDTxt.setText((String)ActTDataTable.getValueAt(row, 1));
		cnameTTxt.setText((String)ActTDataTable.getValueAt(row, 2));
	}

	/**
	 * Show Title Search Event Handle
	 * @param event
	 */
	private void ActorDataSearchActionPerformed(ActionEvent event) {

		String s_ActorID = this.s_ActorIDTxt.getText();
		ActTData actTData = new ActTData();
		actTData.setPersonID(s_ActorID);
		this.fillTable(actTData);
	}

	/**
	 * initialize Show Table
	 * @param ShowData
	 */
	private void fillTable(ActTData actorData) {
		DefaultTableModel dtm = (DefaultTableModel) ActTDataTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = actTDataDAO.list(con, actorData);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("PersonID"));
				v.add(rs.getString("ShowID"));
				v.add(rs.getString("cnameT"));
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
		this.ActorIDTxt.setText("");
		this.ShowIDTxt.setText("");
		this.cnameTTxt.setText("");
	}
}